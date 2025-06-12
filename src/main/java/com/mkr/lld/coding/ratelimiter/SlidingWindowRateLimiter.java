package com.mkr.lld.coding.ratelimiter;

public class SlidingWindowRateLimiter implements RateLimiter {
    public SlidingWindowRateLimiter(int maxRequests, long windowSizeInMillis) {
    }

    @Override
    public boolean allowRequest(String clientId) {
        return false;
    }
}
