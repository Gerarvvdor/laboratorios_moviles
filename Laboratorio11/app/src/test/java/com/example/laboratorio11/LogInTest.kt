package com.example.laboratorio11

import com.example.laboratorio11.network.dto.login.LoginRequest
import com.example.laboratorio11.network.service.AuthService
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LogInTest {
    private lateinit var mockWebServer: MockWebServer
    private lateinit var outhService: AuthService

    @Before
    fun setup(){
        mockWebServer = MockWebServer()

        outhService = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AuthService::class.java)
    }
    @Test
    fun loginTest() = runTest {
        val mockResponse = MockResponse()
        mockResponse.setBody("""{"msg": "Login successfull", "token": ""testToken"}""")
        mockResponse.setResponseCode(200)
        mockWebServer.enqueue(mockResponse)

        val response = outhService.login(LoginRequest("admin", "admin"))
        mockWebServer.takeRequest()

        Assert.assertEquals("Login Successfull", response.message)
        Assert.assertEquals("testToken", response.token)
    }

    fun unsuccessfullLogin() = runTest {
        val mockResponse = MockResponse()
        mockResponse.setBody("""{"msg": "Check credentials"}""")
        mockWebServer.enqueue(mockResponse)

        val response = outhService.login(LoginRequest("admin", "admin"))
        mockWebServer.takeRequest()

        Assert.assertEquals("Check credentials", response.message)
    }

    @After
    fun tearDown(){
        mockWebServer.shutdown()
    }
}