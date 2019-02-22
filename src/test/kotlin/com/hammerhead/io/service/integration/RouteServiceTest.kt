package com.hammerhead.io.service.integration

import com.fasterxml.jackson.core.type.TypeReference
import com.hammerhead.io.service.TestUtil
import com.hammerhead.io.service.config.DbConfig
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

@RunWith(SpringRunner::class)
@SpringBootTest(classes = [DbConfig::class])
class RouteServiceTest {

    lateinit var mockMvc : MockMvc

    @Autowired
    lateinit var webApplicationContext: WebApplicationContext

    @Before
    fun setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build()
    }

    @Test
    fun `test route service expecting exactly 1 SRT`() {
        val mvcResult = this.mockMvc.perform(get("/route")).andExpect(status().isOk).andReturn()
        val routeList = TestUtil.resultToTypeRef(mvcResult, object : TypeReference<List<String>>(){})
        assert(routeList.filter { it == "SRT" }.size == 1) { "SRT route was missing or returned more than once!" }
    }

    @Test
    fun `test route service expecting exactly 1 CRT`() {
        val mvcResult = this.mockMvc.perform(get("/route")).andExpect(status().isOk).andReturn()
        val routeList = TestUtil.resultToTypeRef(mvcResult, object : TypeReference<List<String>>(){})
        assert(routeList.filter { it == "CVT" }.size == 1) { "CVT route was missing or returned more than once!" }
    }

    @Test
    fun `test route service expecting exactly 1 Perkiomen`() {
        val mvcResult = this.mockMvc.perform(get("/route")).andExpect(status().isOk).andReturn()
        val routeList = TestUtil.resultToTypeRef(mvcResult, object : TypeReference<List<String>>(){})
        assert(routeList.filter { it == "Perkiomen" }.size == 1) { "Perkiomen route was missing or returned more than once!" }
    }

    @Test
    fun `test route service expecting exactly 1 Welsh Mountain`() {
        val mvcResult = this.mockMvc.perform(get("/route")).andExpect(status().isOk).andReturn()
        val routeList = TestUtil.resultToTypeRef(mvcResult, object : TypeReference<List<String>>(){})
        assert(routeList.filter { it == "Welsh Mountain" }.size == 1) { "Welsh Mountain route was missing or returned more than once!" }
    }

    @Test
    fun `test route service expecting exactly 1 Oaks to Philly`() {
        val mvcResult = this.mockMvc.perform(get("/route")).andExpect(status().isOk).andReturn()
        val routeList = TestUtil.resultToTypeRef(mvcResult, object : TypeReference<List<String>>(){})
        assert(routeList.filter { it == "Oaks to Philly" }.size == 1) { "Oaks to Philly route was missing or returned more than once!" }
    }

    @Test
    fun `test route service expecting exactly 5 routes` () {
        val mvcResult = this.mockMvc.perform(get("/route")).andExpect(status().isOk).andReturn()
        val routeList = TestUtil.resultToTypeRef(mvcResult, object : TypeReference<List<String>>(){})
        assert(routeList.size == 5) { "More or less than 5 routes were returned" }
    }

}