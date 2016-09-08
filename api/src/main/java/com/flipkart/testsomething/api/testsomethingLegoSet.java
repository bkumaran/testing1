package com.flipkart.testsomething.api;

import com.flipkart.poseidon.api.APILegoSet;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class testsomethingLegoSet extends APILegoSet {
    @Override
    public List<String> getPackagesToScan() {
        return Arrays.asList("com.flipkart.testsomething.datasources", "com.flipkart.poseidon.serviceclients", "com.flipkart.testsomething.api.filters", "com.flipkart.testsomething.api.mappers");
    }
}
