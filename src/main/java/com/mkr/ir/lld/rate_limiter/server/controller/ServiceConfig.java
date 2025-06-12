package com.mkr.ir.lld.rate_limiter.controller;

import com.mkr.ir.lld.rate_limiter.dao.RateLimiterDAO;
import com.mkr.ir.lld.rate_limiter.dao.ServiceConfigDAO;
import com.mkr.ir.lld.rate_limiter.models.ServiceConfiguration;

import java.util.concurrent.CompletableFuture;

public class ServiceConfig {

    private ServiceConfigDAO serviceConfigDAO;

    public CompletableFuture<Void> updateServiceConfig(ServiceConfiguration serviceConfiguration) {
        return serviceConfigDAO.updateServiceConfig(serviceConfiguration);
    }
}
