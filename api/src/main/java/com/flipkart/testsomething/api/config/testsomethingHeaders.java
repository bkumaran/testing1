package com.flipkart.testsomething.api.config;

import com.flipkart.poseidon.api.HeaderConfiguration;
import com.flipkart.poseidon.api.Headers;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static com.flipkart.testsomething.commons.testsomethingConstants.PERF_TEST_HEADER;
import static com.flipkart.testsomething.commons.testsomethingConstants.REQUEST_ID_HEADER;

@Component
public class testsomethingHeaders implements Headers {
    private Set<HeaderConfiguration> passThroughHeaders;

    public testsomethingHeaders() {
        passThroughHeaders = new HashSet();
        passThroughHeaders.add(new HeaderConfiguration(REQUEST_ID_HEADER, () -> UUID.randomUUID().toString()));
        passThroughHeaders.add(new HeaderConfiguration(PERF_TEST_HEADER));

    }

    @Override
    public Set<HeaderConfiguration> getGlobalHeaders() {
        return passThroughHeaders;
    }
}