package com.gemeenteutrecht.processplatform.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.camunda.spin.impl.json.jackson.format.JacksonJsonDataFormat;
import org.camunda.spin.spi.DataFormatConfigurator;

public class CamundaSpinDataFormatConfigurator implements DataFormatConfigurator<JacksonJsonDataFormat> {

    private ObjectMapper objectMapper;

    public CamundaSpinDataFormatConfigurator() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
    }

    @Override
    public Class<JacksonJsonDataFormat> getDataFormatClass() {
        return JacksonJsonDataFormat.class;
    }

    @Override
    public void configure(JacksonJsonDataFormat dataFormat) {
        dataFormat.setObjectMapper(objectMapper);
    }
}
