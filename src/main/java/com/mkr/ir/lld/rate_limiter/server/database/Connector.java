package com.mkr.ir.lld.rate_limiter.server.database;

import java.util.List;


// TODO: Analysis on THRIFT to define the contract for the db connector
public class Connector {
    public void updateDB(String sql) {

    }

    public <T> List<T> readDB(String sql, Class<T> type) {
        // This is a placeholder for the actual database read operation
        // In a real implementation, this would connect to a database and execute the query
        return List.of(); // Returning an empty list for now

    }
}
