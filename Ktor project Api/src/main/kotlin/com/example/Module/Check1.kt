package com.example.Module

import io.ktor.server.application.*

object Check1 {
    lateinit var env : Check

    fun initConfig(environment : ApplicationEnvironment) {
        env = Check("sai",22)
    }
}