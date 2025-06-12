package com.mkr.lld.coding.ratelimiter;

public class RateLimiterManager {

    private static volatile RateLimiterManager instance;
    private RateLimiter rateLimiter;

    private RateLimiterManager() {
        // initialize the rate limiter with a fixed window strategy
        this.rateLimiter = RateLimiterFactory.createRateLimiter("fixed", 100, 60000);
    }

    public static RateLimiterManager getInstance() {
        if(instance == null) {
            synchronized (RateLimiterManager.class) {
                if(instance == null) {
                    instance = new RateLimiterManager();
                }
            }
        }
        return instance;
    }

    public boolean allowRequest(String clientId) {
        return rateLimiter.allowRequest(clientId);
    }


}
