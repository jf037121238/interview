package com.hammerhead.io.service.integration

import com.fasterxml.jackson.core.type.TypeReference
import com.hammerhead.io.service.TestUtil
import com.hammerhead.io.service.config.DbConfig
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

@RunWith(SpringRunner::class)
@SpringBootTest(classes = [DbConfig::class])
class ServiceRouteServiceTest {
    lateinit var mockMvc : MockMvc

    @Autowired
    lateinit var webApplicationContext: WebApplicationContext

    @Before
    fun setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build()
    }

    @Test
    fun `test route service expecting exactly 2 SRT`(){
        val mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/service/route")).andExpect(MockMvcResultMatchers.status().isOk).andReturn()
        val routeList = TestUtil.resultToTypeRef(mvcResult, object : TypeReference<List<String>>(){})
        assert(routeList.filter { it == "SRT" }.size == 2) { "SRT route was not returned exactly 2 times" }
    }


    @Test
    fun `test route service expecting exactly 2 CVT`(){
        val mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/service/route")).andExpect(MockMvcResultMatchers.status().isOk).andReturn()
        val routeList = TestUtil.resultToTypeRef(mvcResult, object : TypeReference<List<String>>(){})
        assert(routeList.filter { it == "CVT" }.size == 2) { "CVT route was not returned exactly 2 times" }
    }

    @Test
    fun `test route service expecting exactly 2 Perkiomen`(){
        val mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/service/route")).andExpect(MockMvcResultMatchers.status().isOk).andReturn()
        val routeList = TestUtil.resultToTypeRef(mvcResult, object : TypeReference<List<String>>(){})
        assert(routeList.filter { it == "Perkiomen" }.size == 2) { "Perkiomen route not returned exactly 2 times" }
    }

    @Test
    fun `test route service expecting exactly 2 Welsh Mountain`(){
        val mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/service/route")).andExpect(MockMvcResultMatchers.status().isOk).andReturn()
        val routeList = TestUtil.resultToTypeRef(mvcResult, object : TypeReference<List<String>>(){})
        assert(routeList.filter { it == "Welsh Mountain" }.size == 2) { "Welsh Mountain route was not returned exactly 2 times" }
    }

    @Test
    fun `test route service expecting exactly 1 Oaks to Philly`(){
        val mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/service/route")).andExpect(MockMvcResultMatchers.status().isOk).andReturn()
        val routeList = TestUtil.resultToTypeRef(mvcResult, object : TypeReference<List<String>>(){})
        assert(routeList.filter { it == "Oaks to Philly" }.size == 1) { "Oaks to Philly route was not returned exactly once" }
    }
    @Test
    fun `test route service expecting exactly 9 records returned`() {
        val mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/service/route")).andExpect(MockMvcResultMatchers.status().isOk).andReturn()
        val routeList = TestUtil.resultToTypeRef(mvcResult, object : TypeReference<List<String>>() {})
        assert(routeList.size == 9) { "More or less than 9 records were returned" }
    }


}