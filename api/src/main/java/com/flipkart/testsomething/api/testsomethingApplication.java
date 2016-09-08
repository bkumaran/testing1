package com.flipkart.testsomething.api;

import com.flipkart.poseidon.api.APIApplication;
import com.flipkart.poseidon.api.APIManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class testsomethingApplication extends APIApplication {
    @Autowired
    public testsomethingApplication(APIManager apiManager, testsomethingLegoSet legoSet) {
        super(apiManager, legoSet);
    }
}