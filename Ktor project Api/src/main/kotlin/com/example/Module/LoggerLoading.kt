package com.example.Module

import org.slf4j.LoggerFactory
import java.util.logging.Logger


class LoggerLoading {
    companion object {
        val log : org.slf4j.Logger? = LoggerFactory.getLogger(LoggerLoading::class.java)
//        val log1 : org.slf4j.Logger? = LoggerFactory.getLogger(javaClass)
    }
}