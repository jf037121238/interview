package com.hammerhead.io.service

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.springframework.test.web.servlet.MvcResult

class TestUtil {
    companion object {

        val objectMapper = ObjectMapper().registerModule(KotlinModule())

        fun <T> resultToTypeRef(mvcResult: MvcResult, typeReference: TypeReference<T>) : T {
            return objectMapper.readValue(mvcResult.response.contentAsString, typeReference)
        }
    }
}