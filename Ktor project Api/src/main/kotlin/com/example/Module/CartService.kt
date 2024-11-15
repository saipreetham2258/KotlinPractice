package com.example.Module

import com.example.constants.ConstantVariable.OK
import java.util.*

class CartService {
    suspend fun hello() : NotFoundResponse {
        return NotFoundResponse(OK, Date(System.currentTimeMillis()).toString(),"Hello, welcome to cart service")
    }
}