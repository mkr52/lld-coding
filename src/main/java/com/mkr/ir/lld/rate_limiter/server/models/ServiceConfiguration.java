package com.mkr.ir.lld.rate_limiter.models;

import java.util.concurrent.TimeUnit;

public class ServiceConfiguration {

    String service;
    String key;
    TimeUnit timeUnit;
    int limit;

    public String getService() {
        return service;
    }

    public String getKey() {
        return key;
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    public int getLimit() {
        return limit;
    }
}
