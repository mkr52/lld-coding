package com.mkr.ir.lld.rate_limiter.server.controller;

import com.mkr.ir.lld.rate_limiter.server.dao.ServiceConfigDAO;
import com.mkr.ir.lld.rate_limiter.server.models.ServiceConfiguration;

import java.util.concurrent.CompletableFuture;

public class ServiceConfig {

    private ServiceConfigDAO serviceConfigDAO;

    public CompletableFuture<Void> updateServiceConfig(ServiceConfiguration serviceConfiguration) {
        return serviceConfigDAO.updateServiceConfig(serviceConfiguration);
    }
}
