package com.flipkart.testsomething.commons;

import com.flipkart.cp.cfgsvc.ConfigServiceClientWrapper;

import java.util.Arrays;
import java.util.Map;

public class ConfigProvider {
    private final static ConfigProvider INSTANCE = new ConfigProvider();

    private ConfigServiceClientWrapper clientWrapper;

    public ConfigProvider() {
        clientWrapper = new ConfigServiceClientWrapper(Arrays.asList(testsomethingConstants.CONFIG_SERVICE_BUCKET_NAME));
    }

    public static ConfigProvider getInstance() {
        return INSTANCE;
    }

    public String get(String configKey, String defaultValue) {
        String configValue = clientWrapper.get(configKey);
        if (configValue != null) {
            return configValue;
        }
        return defaultValue;
    }

    public Boolean getBoolean(String configKey, Boolean defaultValue) {
        Boolean configValue = clientWrapper.getBoolean(configKey);
        if (configValue != null) {
            return configValue;
        }
        return defaultValue;
    }

    public Integer getInt(String configKey, Integer defaultValue) {
        Integer configValue = clientWrapper.getInt(configKey);
        if (configValue != null) {
            return configValue;
        }
        return defaultValue;
    }

    public Map<String, Object> getKeys(String bucketName) {
        return clientWrapper.getAll(bucketName);
    }
}
