package com.jiajia.support.http;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.util.Map;
import java.util.Objects;

public class HttpUtil {

    public static String get(String url) {
        return get(url, null);
    }

    public static String get(String url, Map<String, String> queries) {
        String responseBody = "";
        StringBuilder sb = new StringBuilder(url);
        if (queries != null && queries.keySet().size() > 0) {
            boolean firstFlag = true;

            for (Map.Entry<String, String> entry : queries.entrySet()) {
                String separator = "&";
                if (firstFlag) {
                    separator = "?";
                    firstFlag = false;
                }
                sb.append(separator).append(entry.getKey()).append("=").append(entry.getValue());
            }
        }
        Request request = new Request.Builder()
                .url(sb.toString())
                .build();
        try (Response response = new OkHttpClient().newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                return Objects.requireNonNull(response.body()).string();
            }
        } catch (Exception e) {
//            LogUtils.e(e.getMessage());
        }
        return responseBody;
    }

}
