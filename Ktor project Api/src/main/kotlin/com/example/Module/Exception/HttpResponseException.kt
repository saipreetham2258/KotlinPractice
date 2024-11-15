package com.example.Module.Exception

import io.ktor.http.*

class HttpResponseException(val status : HttpStatusCode,val date : String,val mess : String) : RuntimeException()