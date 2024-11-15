package com.example.plugins

import com.example.Module.*
import com.example.Module.DatabaseConnectivity.collection
import com.example.Module.Exception.HttpResponseException
import com.example.Module.LoggerLoading.Companion.log
import com.example.constants.ConstantVariable.BAD_REQUEST
import com.example.constants.ConstantVariable.BODY_NOTFOUND
import com.example.constants.ConstantVariable.DELETED
import com.example.constants.ConstantVariable.ID
import com.example.constants.ConstantVariable.ITEM
import com.example.constants.ConstantVariable.NOT_FOUND
import com.example.constants.ConstantVariable.NO_CUSTOMER_FOUND
import com.example.constants.ConstantVariable.NO_PARAMETER
import com.example.constants.ConstantVariable.OK
import com.example.constants.ConstantVariable.QUANTITY_COUNT
import com.example.constants.ConstantVariable.USER_NOTFOUND
import com.mongodb.client.MongoCollection
import com.mongodb.client.model.UpdateOptions
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.html.body
import kotlinx.html.h1
import kotlinx.html.title
import org.koin.java.KoinJavaComponent
import org.koin.java.KoinJavaComponent.getKoin
import org.koin.java.KoinJavaComponent.inject
import org.koin.java.KoinJavaComponent.injectOrNull
import org.litote.kmongo.*
import org.slf4j.LoggerFactory
import java.util.*
import java.util.logging.Logger


val date = Date(System.currentTimeMillis())

fun Application.configureRouting() {
    routing {
        val obj : CartService by inject<CartService>(CartService::class.java)  //koin dependency injection
//      val cartService by KoinJavaComponent.inject<CartService>(CartService::class.java)
        post("/add") {
            addToDataBase(call, collection)
        }
        get("/get") {
            getSpecificRecord(call, collection)
        }
        delete("/delete") {
            deleteSpecificItem(call, collection)
        }
        delete("/cart") {
            deleteCart(call, collection)
        }
        delete("/delete-user") {
            deleteUserFromCart(call, collection)
        }
        get("/all") {
            getAll(call, collection)
        }
        get("/cart-count") {
            cartCount(call, collection)
        }
        get("/koin") {
            val obj = obj.hello()
            call.respond(HttpStatusCode.OK,obj)
        }
        put("/add-to-existing") {
            updateCart(call, collection)
        }
        put("/update-item-quantity") {
            updateQuantityInCart(call, collection)
        }
        get("/exception") {
            val id = call.request.headers[ID]
            log.info("header is stored in id")
            if(id != null) {
                val find = collection.findOneById(id)
                find?.let {
                    call.respond(HttpStatusCode.OK,"")
                } ?: run{
                    call.respond(HttpStatusCode.NotFound,NotFoundResponse(NOT_FOUND,date.toString(), NO_CUSTOMER_FOUND))
                }
            }
            throw HttpResponseException(HttpStatusCode.Unauthorized, date.toString(), "No header found")
        }
        get("/UUID") {
            val uuid = UUID.randomUUID().toString()
            call.respond(HttpStatusCode.OK,"User hash : $uuid")
        }
        get("/calling-another-endpoint") {
            call.respondRedirect("/all",false)
        }
        get("/html") {
            call.respondHtml {
                head {
                        +"hello this is html"
                }
                body {
                    h1 { +"hello, sai preetham reddy" }
                }
            }
        }
        get("/hello") {
            call.respond(HttpStatusCode.OK,"Hello")
        }
        get("/check") {
            val result = Check1.env.name
            call.respond(HttpStatusCode.OK,"$result")
        }

    }
}

suspend fun addToDataBase(call: ApplicationCall, collection: MongoCollection<Cart>) {
    val userid = call.request.headers[ID].toString()
    if(userid != "null" && userid != "") {
        val data = call.receive<MasterData>()

        val user = collection.findOneById(userid) ?: Cart(userid)
        user.items.add(data)

        collection.save(user)
        val obj = NotFoundResponse(OK, data.toString(),"Item added to cart")
        call.respond(HttpStatusCode.OK,obj)
    }
    else {
        val obj = NotFoundResponse(NOT_FOUND, date.toString(), NO_PARAMETER)
        call.respond(HttpStatusCode.NotFound, obj)
    }


}

suspend fun getSpecificRecord(call: ApplicationCall, collection: MongoCollection<Cart>) {
    val id = call.request.headers[ID]?.toString()
    id?.let {
        val findUser = collection.findOne(Cart::userId eq id)
        findUser?.let { call.respond(HttpStatusCode.OK,it) } ?: run { call.respond(HttpStatusCode.NotFound,NotFoundResponse(
            NOT_FOUND, date.toString(), NO_CUSTOMER_FOUND)) }
    } ?: run{
        val obj = NotFoundResponse(BAD_REQUEST, date.toString(), NO_PARAMETER)
        call.respond(HttpStatusCode.BadRequest,obj)
    }
}

suspend fun deleteSpecificItem(call : ApplicationCall,collection: MongoCollection<Cart>) {
    val id = call.request.headers[ID].toString()
    val item = call.request.headers[ITEM]
    val user = collection.findOneById(id)
    if(user != null) {
        val isRemoved = user?.items?.removeIf { it.name == item }
        if(isRemoved == true) {
            collection.save(user)
            val obj = NotFoundResponse(OK,date.toString(),"Item $item removed Successfully")
            call.respond(HttpStatusCode.OK,obj)
        }
        else {
            val obj = NotFoundResponse(NOT_FOUND,date.toString(),"Item not $item found")
            call.respond(HttpStatusCode.NotFound,obj)
        }
    }
    else {
        val obj = NotFoundResponse(NOT_FOUND,date.toString(),"User not found of id: $id")
        call.respond(HttpStatusCode.NotFound,obj)
    }

}
suspend fun deleteCart(call:ApplicationCall,collection: MongoCollection<Cart>) {
    val id = call.request.headers[ID]
    id?.let {
        val user = collection.findOneById(id)
        if(user?.items?.isEmpty() == true){
            val obj = NotFoundResponse(BAD_REQUEST,date.toString(),"Already cart is empty")
            call.respond(HttpStatusCode.BadRequest,obj)
        }
        else if(user != null) {
            user.items.clear()
            collection.save(user)
            val obj = NotFoundResponse(OK,date.toString(), DELETED)
            call.respond(HttpStatusCode.OK,obj)
        }
        else {
            val obj = NotFoundResponse(OK,date.toString(), USER_NOTFOUND)
            call.respond(HttpStatusCode.OK, obj)
        }
    } ?: run{
        val obj = NotFoundResponse(BAD_REQUEST , date.toString(), NO_PARAMETER)
        call.respond(HttpStatusCode.BadRequest, obj)
    }
}
suspend fun deleteUserFromCart(call : ApplicationCall,collection : MongoCollection<Cart>) {
    val user = call.request.headers[ID]
    user?.let {
        val findUser = collection.findOne(Cart::userId eq user)
        if(findUser != null) {
            val isDeleted = collection.deleteOneById(user)
            if(isDeleted.deletedCount > 0) {
                val obj = NotFoundResponse(
                    OK,
                    date.toString(),
                    "Successfully user deleted"
                )
                call.respond(HttpStatusCode.OK,obj)
            }
            else {
                val obj = NotFoundResponse(OK, date.toString(), "User not deleted")
                call.respond(HttpStatusCode.OK,obj)
            }
        }
        else {
            val obj = NotFoundResponse(NOT_FOUND, date.toString(), NO_CUSTOMER_FOUND)
            call.respond(HttpStatusCode.NotFound,obj)
        }

    } ?: run {
        val obj = NotFoundResponse(BAD_REQUEST,date.toString(), NO_PARAMETER)
        call.respond(HttpStatusCode.BadRequest, obj)
    }
}
suspend fun getAll(call : ApplicationCall, collection: MongoCollection<Cart>) {
    log!!.info("Api is started...")
    val allData = collection.find().toList()
    log.info(allData.toString())
    call.respond(HttpStatusCode.OK,allData)

}
suspend fun cartCount(call : ApplicationCall,collection: MongoCollection<Cart>) {
    val user = call.request.headers[ID]
    user?.let {
        val customer = collection.findOneById(user)
        if(customer != null) {
            val size = customer?.items?.size ?: 0
            val obj = CountResponse(customer.userId.toString(),size)
            call.respond(HttpStatusCode.OK,obj)
        }
        else {
            val obj = NotFoundResponse(NOT_FOUND,date.toString(), NO_CUSTOMER_FOUND)
            call.respond(HttpStatusCode.NotFound,obj)
        }
    } ?: run {
        val obj = NotFoundResponse(BAD_REQUEST , date.toString(), NO_PARAMETER)
        call.respond(HttpStatusCode.BadRequest, obj)
    }
}
suspend fun updateCart(call : ApplicationCall,collection: MongoCollection<Cart>) {
    val name = call.request.headers[ID].toString()
    val cart = call.receive<MasterData>()
    val find = collection.findOneById(name)
    find?.let {
        find.items.add(cart)
        collection.updateOne(find)
        val obj = NotFoundResponse(OK,date.toString(),"Updated cart")
        call.respond(HttpStatusCode.OK,obj)

    } ?: run {
        val obj = NotFoundResponse(NOT_FOUND,date.toString(), NO_CUSTOMER_FOUND)
        call.respond(obj)
    }

}
suspend fun updateQuantityInCart(call : ApplicationCall,collection: MongoCollection<Cart>) {
        val user = call.request.headers[ID].toString()
        val itemName = call.request.headers[ITEM].toString()
        val quantity = call.request.headers[QUANTITY_COUNT]?.toInt()
        if (quantity != null && quantity > 0) {
            val findUser = collection.findOneById(user)
            if (findUser != null) {
                val findItem = findUser.items.find { it.name == itemName }
                if (findItem != null) {
                    if(findItem.quantity == quantity) {
                        val obj = NotFoundResponse(BAD_REQUEST,date.toString(),"Existing item count and updating item count is same")
                        call.respond(HttpStatusCode.BadRequest,obj)
                    }
                    else {
                        findItem.quantity = quantity
                        collection.updateOne(findUser)
                        val obj = NotFoundResponse(
                            OK,
                            date.toString(),
                            "Successfully item quantity updated"
                        )
                        call.respond(HttpStatusCode.OK,obj)
                    }
                } else {
                    val obj =
                        NotFoundResponse(BAD_REQUEST, date.toString(), "No item Found")
                    call.respond(HttpStatusCode.BadRequest,obj)
                }
            } else {
                val obj = NotFoundResponse(BAD_REQUEST, date.toString(), NO_CUSTOMER_FOUND)
                call.respond(HttpStatusCode.BadRequest,obj)
            }
        } else {
            val obj = NotFoundResponse(
                BAD_REQUEST,
                Date().toString(),
                "Quantity must be greater than 0"
            )
            call.respond(HttpStatusCode.BadRequest,obj)
        }

}

