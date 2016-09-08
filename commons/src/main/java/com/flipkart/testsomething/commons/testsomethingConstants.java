package com.flipkart.testsomething.commons;

public class testsomethingConstants {
    // Used in distributed tracing,
    public final static String APP_NAME = "Poseidontestsomething";

    // New config service bucket name
    // Refer http://config-service.nm.flipkart.com/v1/buckets/poseidon-testsomething
    public final static String CONFIG_SERVICE_BUCKET_NAME = "poseidon-testsomething";

    public final static String REQUEST_ID_HEADER = "X-REQUEST-ID";
    public final static String PERF_TEST_HEADER = "X-PERF-TEST";
}
