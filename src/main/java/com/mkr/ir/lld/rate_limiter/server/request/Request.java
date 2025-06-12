package com.mkr.ir.lld.rate_limiter.request;

public abstract class Request {

    String id;
    String serviceName;

    public String getId() {
        return id;
    }

    public String getServiceName() {
        return serviceName;
    }
}
