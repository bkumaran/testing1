package com.flipkart.testsomething.api.config;

import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.flipkart.poseidon.api.TracingConfiguration;
import com.flipkart.testsomething.commons.ConfigProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.flipkart.poseidon.helpers.ObjectMapperHelper.getMapper;

@Component
public class testsomethingTracingConfiguration implements TracingConfiguration {
    private final static Logger LOGGER = LoggerFactory.getLogger(testsomethingTracingConfiguration.class);

    @Override
    public String getCollectorHost() {
        return ConfigProvider.getInstance().get("poseidon.tracing.collectorHost", "localhost");
    }

    @Override
    public int getCollectorPort() {
        return ConfigProvider.getInstance().getInt("poseidon.tracing.collectorPort", 9410);
    }

    @Override
    public boolean enableTracing() {
        return ConfigProvider.getInstance().getBoolean("poseidon.tracing.enableTracing", false);
    }

    @Override
    public Map<String, Integer> getSampleRateMap() {
        String sampleRateMapStr = ConfigProvider.getInstance().get("poseidon.tracing.sampleRateMap", "");
        try {
            MapType mapType = TypeFactory.defaultInstance().constructMapType(HashMap.class, String.class, Integer.class);
            return getMapper().readValue(sampleRateMapStr, mapType);
        } catch (IOException e) {
            LOGGER.error("Exception reading config - poseidon.tracing.sampleRateMap", e);
            return null;
        }
    }
}
