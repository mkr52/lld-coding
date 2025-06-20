package com.mkr.lld.coding.ratelimiter;

public class RateLimiterFactory {

    public static RateLimiter createRateLimiter(String type, int maxRequests, long windowSizeInMillis) {
        switch (type.toLowerCase()) {
            case "fixed":
                return new FixedWindowRateLimiter(maxRequests, windowSizeInMillis);
            case "sliding":
                return new SlidingWindowRateLimiter(maxRequests, windowSizeInMillis);
            default:
                throw new IllegalArgumentException("Unsupported type: " + type);
        }
    }
}
