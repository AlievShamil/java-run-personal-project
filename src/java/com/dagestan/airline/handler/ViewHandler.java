package com.dagestan.airline.handler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ViewHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        byte[] content = getViewBytes();
        OutputStream outputStream = exchange.getResponseBody();
        exchange.sendResponseHeaders(200, content.length);
        outputStream.write(content);
        outputStream.flush();
        outputStream.close();
    }

    private byte[] getViewBytes() {
        ClassLoader classLoader = ViewHandler.class.getClassLoader();
        URL resource = classLoader.getResource("index.html");
        if (resource != null) {
            try {
                Path path = Paths.get(resource.toURI());
                return Files.readAllBytes(path);
            } catch (URISyntaxException | IOException e) {
                e.printStackTrace();
            }
        }
        return "View not found".getBytes(StandardCharsets.UTF_8);
    }
}
