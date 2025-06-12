package com.mkr.ir.lld.rate_limiter.request;

public class UpdateRequest extends Request {

    String key;
    long timestamp;
    int count;

    public String getKey() {
        return key;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public int getCount() {
        return count;
    }
}
