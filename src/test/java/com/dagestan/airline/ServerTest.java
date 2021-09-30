package com.dagestan.airline;

import com.dagestan.airline.config.LoggerConfiguration;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class ServerTest {
    private static final String BASE_URL_PATTERN = "http://localhost:%d%s";
    private static OkHttpClient client;
    private static Server httpServer;
    private static int port;

    @BeforeClass
    public static void setUp() throws Exception {
        LoggerConfiguration.init();

        client = new OkHttpClient();
        port = (int) (8000 + (Math.random() * 80));
        httpServer = new Server(port, 0);

        httpServer.start();
    }

    @Test
    public void testSuccessServerResponseOnTicketsSearchRequest() throws IOException {
        Request request = new Request.Builder()
                .url(String.format(BASE_URL_PATTERN, port, "/tickets/search"))
                .build();
        Response response = client.newCall(request).execute();

        assertThat(response.code()).isEqualTo(200);
    }

    @Test
    public void testSuccessServerResponseOnTicketsRequest() throws IOException {
        Request request = new Request.Builder()
                .url(String.format(BASE_URL_PATTERN, port, "/tickets"))
                .build();
        Response response = client.newCall(request).execute();

        assertThat(response.code()).isEqualTo(200);
    }

    @AfterClass
    public static void tearDown() {
        httpServer.stop(0);
    }
}