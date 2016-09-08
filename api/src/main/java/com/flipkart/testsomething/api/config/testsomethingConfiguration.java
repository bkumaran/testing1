package com.flipkart.testsomething.api.config;

import com.flipkart.poseidon.api.*;
import com.flipkart.testsomething.commons.testsomethingConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class testsomethingConfiguration implements Configuration {

    @Value("${poseidon.port}")
    private int port;

    @Value("${poseidon.sendServerVersion:false}")
    private boolean sendServerVersion;

    @Value("${poseidon.rewriteFilePath}")
    private String rewriteFilePath;

    @Value("${poseidon.logbackAccessPath}")
    private String logbackAccessPath;

    @Value("${poseidon.rotationStatusFilePath}")
    private String rotationStatusFilePath;

    @Value("${poseidon.apiFilesPath}")
    private String apiFilesPath;

    @Autowired
    private TracingConfiguration tracingConfiguration;

    @Autowired
    private Headers headers;

    @Override
    public int getPort() {
        return port;
    }

    @Override
    public boolean sendServerVersion() {
        return sendServerVersion;
    }

    @Override
    public String getRewriteFilePath() {
        return rewriteFilePath;
    }

    @Override
    public String getLogbackAccessPath() {
        return logbackAccessPath;
    }

    @Override
    public String getRotationStatusFilePath() {
        return rotationStatusFilePath;
    }

    @Override
    public String getApiFilesPath() {
        return apiFilesPath;
    }

    @Override
    public String[] getFilterIds() {
        return null;
    }

    @Override
    public String getAppName() {
        return testsomethingConstants.APP_NAME;
    }

    @Override
    public TracingConfiguration getTracingConfiguration() {
        return tracingConfiguration;
    }

    @Override
    public JettyConfiguration getJettyConfiguration() {
        return null;
    }

    @Override
    public ExceptionMapper getExceptionMapper(){
        return null;
    }

    @Override
    public Headers getHeadersConfiguration(){
        return headers;
    }
}
