package com.example.Module
import de.undercouch.bson4jackson.types.Timestamp
import jdk.jshell.Snippet.Status
import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import java.time.Instant
import java.time.LocalDateTime
import java.util.Date

@Serializable
data class MasterData(val name : String,
                      val id : String,
                      var quantity : Int)

@Serializable
data class Cart(@BsonId val userId : String,
                val items : MutableList<MasterData> = mutableListOf()
)

@Serializable
data class CountResponse(val name : String,
                       val cartCount : Int )

@Serializable
data class NotFoundResponse(val status : Int,
                            val timeStamp : String,
                            val message : String)