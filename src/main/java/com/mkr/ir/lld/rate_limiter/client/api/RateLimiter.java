package com.mkr.ir.lld.rate_limiter.client.api;

import com.mkr.ir.lld.rate_limiter.client.models.ServiceConfiguration;
import com.mkr.ir.lld.rate_limiter.client.request.ReadConfigRequest;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;

public class RateLimiter<T> {

    private RateLimiterServer rateLimiterServer;

    private String serviceName;

    private Function<T, CompletableFuture<Void>> onAccept;
    private Function<T, CompletableFuture<Void>> onReject;

    private ExecutorService executorService;

    public RateLimiter(String serviceName, int threadCount) throws Exception {
        this(serviceName, null, null, threadCount);
    }

    public RateLimiter(String serviceName,
                       Function<T, CompletableFuture<Void>> onAccept,
                       Function<T, CompletableFuture<Void>> onReject,
                       int threadCount) throws Exception {
        this.serviceName = serviceName;
        this.onAccept = onAccept;
        this.onReject = onReject;
        executorService = Executors.newFixedThreadPool(threadCount);
    }

    // IO call to get the service configuration, so the completable future is used
    public CompletableFuture<ServiceConfiguration> getServiceConfiguration() {
        return rateLimiterServer.getServiceConfig(serviceName);
    }

    public CompletableFuture<Map<String, Limit>> readKey(String json) {
        return rateLimiterServer.readKey();
//                CompletableFuture.supplyAsync(() -> rateLimiterServer.readKey(), executorService)
//                .thenCompose(Function.identity());
    }

    public CompletableFuture<Void> updateKey(String key, int amount) {
        return rateLimiterServer.updateKey(key, amount, System.currentTimeMillis());
//                CompletableFuture.supplyAsync(() -> rateLimiterServer.updateKey(key, amount, System.currentTimeMillis()), executorService)
//                .thenCompose(Function.identity());
    }

    public Object onAccept(T request) {
        return onAccept.apply(request);
    }

    public Object onReject(T request) {
        return onReject.apply(request);
    }
}

class RateLimiterServer {

    public CompletableFuture<ServiceConfiguration> getServiceConfig(String serviceName) {
        // readServiceConfig (ReadConfigRequest)
        new ReadConfigRequest(serviceName, UUID.randomUUID().toString());

        // Simulate an IO call to fetch the service configuration
        return CompletableFuture.supplyAsync(() -> {
            // Fetch the configuration from a database or external service
            // For now, returning a dummy configuration
            return new ServiceConfiguration();
        });
    }

    public CompletableFuture<Map<String, Limit>> readKey() {
        return null;
    }

    public CompletableFuture<Void> updateKey(String key, int amount, long currentTimeMillis) {
        return null;
    }
}


class Limit {
    int amount;
    String timeUnit;
}