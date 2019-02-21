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
class UserRouteServiceTest {
    lateinit var mockMvc : MockMvc

    @Autowired
    lateinit var webApplicationContext: WebApplicationContext

    @Before
    fun setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build()
    }

    @Test
    fun `test get user route expecting 2 42SRT 2 42CRT 2 42Perkiomen 2 42Welsh Mountain 2 42Oaks to Philly`() {
        val mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/user/42/route")).andExpect(MockMvcResultMatchers.status().isOk).andReturn()
        val routeList = TestUtil.resultToTypeRef(mvcResult, object : TypeReference<List<String>>(){})
        assert(routeList.filter { it == "42SRT" }.size == 2) { "SRT route was not returned exactly 2 times" }
        assert(routeList.filter { it == "42CVT" }.size == 2) { "CVT route was not returned exactly 2 times" }
        assert(routeList.filter { it == "42Perkiomen" }.size == 2) { "Perkiomen route not returned exactly 2 times" }
        assert(routeList.filter { it == "42Welsh Mountain" }.size == 2) { "Welsh Mountain route was not returned exactly 2 times" }
        assert(routeList.filter { it == "42Oaks to Philly" }.size == 1) { "Oaks to Philly route was not returned exactly once" }
    }

    @Test
    fun `test get user route passing service Komoot,RWGPS filter expecting 1 42SRT 1 42CVT 1 42Perkiomen 2 42Welsh Mountain 1 42Oaks to Philly`() {
        val mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/user/42/route?service=Komoot,RWGPS")).andExpect(MockMvcResultMatchers.status().isOk).andReturn()
        val routeList = TestUtil.resultToTypeRef(mvcResult, object : TypeReference<List<String>>(){})
        assert(routeList.filter { it == "42SRT" }.size == 1) { "SRT route was not returned exactly 1 times" }
        assert(routeList.filter { it == "42CVT" }.size == 1) { "CVT route was not returned exactly 2 times" }
        assert(routeList.filter { it == "42Perkiomen" }.size == 1) { "Perkiomen route not returned exactly 2 times" }
        assert(routeList.filter { it == "42Welsh Mountain" }.size == 2) { "Welsh Mountain route was not returned exactly 2 times" }
        assert(routeList.filter { it == "42Oaks to Philly" }.size == 1) { "Oaks to Philly route was not returned exactly once" }

    }
}