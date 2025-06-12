package com.mkr.ir.lld.rate_limiter.client.request;

abstract class Request {
    String serviceName;
    String id;

    public Request(String serviceName, String id) {
        this.serviceName = serviceName;
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getId() {
        return id;
    }
}
