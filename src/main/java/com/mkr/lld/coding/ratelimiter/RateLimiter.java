package com.mkr.lld.coding.ratelimiter;

public interface RateLimiter {
    boolean allowRequest(String clientId);
}
