package com.example.employee;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.Assert.assertNotNull;


public class WiremockTest {
    @Rule
    public WireMockRule wireMockRule=new WireMockRule(8084);
    private  WireMockServer wireMockServer;

    @BeforeEach
    void setup(){
        wireMockServer = new WireMockServer();
        configureFor("localhost", 8084);
        wireMockServer.start();

    }

    @Test
    public void TestWireMock() throws IOException {
        stubFor(any((anyUrl())).willReturn(ok()));
        // configureStub();
        OkHttpClient client=new OkHttpClient().newBuilder().build();
        Request request= new Request.Builder().url("http://localhost:8084/getAll").method("GET",null).build();
        Response response=client.newCall(request).execute();
        assertNotNull(response);
    }
    @Test
    public void TestWireMockInsert() throws  IOException{
        stubFor(any((anyUrl())).willReturn(ok()));
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder().url("http://localhost:8084/insertUser").build();
        Response response = client.newCall(request).execute();
        assertNotNull(response);
    }


@Test
public void TestWireMockGetById() throws IOException {
    stubFor(any((anyUrl())).willReturn(ok()));
    OkHttpClient client = new OkHttpClient().newBuilder().build();
    Request request = new Request.Builder().url("http://localhost:8084/getById/{id}").method("GET", null).build();
    Response response = client.newCall(request).execute();
    assertNotNull(response);
}
    @Test
    public void TestWireMockDelete() throws IOException {
        stubFor(any((anyUrl())).willReturn(ok()));
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder().url("http://localhost:8084/deleteById/{id}").method("DElETE", null).build();
        Response response = client.newCall(request).execute();
        assertNotNull(response);
    }
    @Test
    public void TestWireMockgetAll() throws IOException {
        stubFor(any((anyUrl())).willReturn(ok()));
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder().url("http://localhost:8084/getAll").method("GET", null).build();
        Response response = client.newCall(request).execute();
        assertNotNull(response);
    }
    @AfterEach
    void after(){

        wireMockServer.stop();
    }


}

