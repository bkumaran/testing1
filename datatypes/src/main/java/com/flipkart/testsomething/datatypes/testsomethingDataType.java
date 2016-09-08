package com.flipkart.testsomething.datatypes;

import com.flipkart.poseidon.datatypes.AbstractDataType;

public class testsomethingDataType extends AbstractDataType {
    private String greeting;

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    @Override
    public String getShortDescription() {
        return "testsomething Data Type";
    }

    @Override
    public String getDescription() {
        return getShortDescription();
    }
}
