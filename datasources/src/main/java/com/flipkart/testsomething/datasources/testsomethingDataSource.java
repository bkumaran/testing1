package com.flipkart.testsomething.datasources;

import com.flipkart.poseidon.datasources.AbstractDataSource;
import com.flipkart.poseidon.model.annotations.Description;
import com.flipkart.poseidon.model.annotations.Name;
import com.flipkart.poseidon.model.annotations.Version;
import com.flipkart.poseidon.model.annotations.Trace;
import com.flipkart.testsomething.datatypes.testsomethingDataType;
import flipkart.lego.api.entities.LegoSet;
import flipkart.lego.api.entities.Request;

@Name("testsomethingDS")
@Version(major = 1, minor = 0, patch = 0)
@Description("Says hello")
@Trace(false)
public class testsomethingDataSource extends AbstractDataSource<testsomethingDataType> {
    public testsomethingDataSource(LegoSet legoset, Request request) {
        super(legoset, request);
    }

    @Override
    public testsomethingDataType call() throws Exception {
        testsomethingDataType dataType =  new testsomethingDataType();
        dataType.setGreeting("Hello " + request.getAttribute("msg"));
        return dataType;
    }
}
