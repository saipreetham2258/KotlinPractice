package org.example

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true) //this will stop the unknown properties without raising exception, unknown means with are not present in data class
data class User3(val name : String,
                 val age : Int,
                 val isStudent : Boolean)