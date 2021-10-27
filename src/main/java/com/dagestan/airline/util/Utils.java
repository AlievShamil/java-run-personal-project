package com.dagestan.airline.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Utils {
    public static Map<String, String> queryToMap(String query) {
        if (query == null || query.isEmpty()) {
            return Collections.emptyMap();
        }

        Map<String, String> result = new HashMap<>();
        for (String param : query.split("&")) {
            String[] entry = param.split("=");
            if (entry.length > 1) {
                result.put(entry[0].toUpperCase(), entry[1]);
            }
        }
        return result;
    }
}
