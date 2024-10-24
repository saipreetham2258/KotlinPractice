package com.example.customer.module
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import kotlinx.serialization.Serializable

@Serializable
@JsonIgnoreProperties(ignoreUnknown = true)
data class CustomerDetails(val id : String,
                           val name : String,
                           val product_purchased : String,
                           val price : Double)
