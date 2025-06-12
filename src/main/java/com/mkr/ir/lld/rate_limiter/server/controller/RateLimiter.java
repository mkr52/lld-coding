package com.mkr.ir.lld.rate_limiter.server.controller;

import com.mkr.ir.lld.rate_limiter.server.dao.RateLimiterDAO;
import com.mkr.ir.lld.rate_limiter.server.request.UpdateRequest;
import com.mkr.ir.lld.rate_limiter.server.response.UpdateResponse;

import java.util.concurrent.CompletableFuture;

public class RateLimiter {

    private RateLimiterDAO connector;

    public CompletableFuture<UpdateResponse> updateKeyMetrics(UpdateRequest request) {
        return updateLimit(request.getServiceName(), request.getKey(), request.getCount(), request.getTimestamp())
                .thenApply(__ -> new UpdateResponse());

    }

    private CompletableFuture<Void> updateLimit(String serviceName, String key, int count, long timestamp) {
        // Make DB changes
        return connector.updateLimit();
    }
}
