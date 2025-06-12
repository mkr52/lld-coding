package com.mkr.ir.lld.rate_limiter.server.api;

import com.mkr.ir.lld.rate_limiter.server.controller.RateLimiter;
import com.mkr.ir.lld.rate_limiter.server.controller.ServiceConfig;
import com.mkr.ir.lld.rate_limiter.server.models.ServiceConfiguration;
import com.mkr.ir.lld.rate_limiter.server.request.UpdateRequest;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class APIGateway {

    public RateLimiter rateLimiter;
    public ServiceConfig serviceConfig;
    public ExecutorService executorService = Executors.newFixedThreadPool(10);

    public void updateKey(String json) {
        CompletableFuture.runAsync(() ->
                rateLimiter.updateKeyMetrics(toObject(json, UpdateRequest.class)), executorService);
//                .thenAccept(response -> client.returnResponse(response));
    }

    public void updateServiceConfig(String json) {
        CompletableFuture.runAsync(() ->
                serviceConfig.updateServiceConfig(toObject(json, ServiceConfiguration.class)), executorService);

    }

    private <T> T toObject(String json, Class<T> requestType) {
        return null;
    }
}
