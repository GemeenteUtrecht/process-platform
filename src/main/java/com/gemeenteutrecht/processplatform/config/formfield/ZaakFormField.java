package com.gemeenteutrecht.processplatform.config.formfield;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gemeenteutrecht.processplatform.domain.Zaak;
import org.camunda.bpm.engine.ProcessEngineException;
import org.camunda.bpm.engine.impl.form.type.AbstractFormFieldType;
import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.engine.variable.type.ValueType;
import org.camunda.bpm.engine.variable.value.ObjectValue;
import org.camunda.bpm.engine.variable.value.TypedValue;

import java.io.IOException;

public class ZaakFormField extends AbstractFormFieldType {

    public final static String TYPE_NAME = "zaak";
    private ObjectMapper objectMapper;

    public ZaakFormField() {
        objectMapper = new ObjectMapper();
    }

    public Object getInformation(String key) {
        return "asd";
    }

    @Override
    public String getName() {
        return TYPE_NAME;
    }

    @Override
    public TypedValue convertToFormValue(TypedValue modelValue) {

        if (modelValue.getValue() == null) {

            ObjectValue objectValue = Variables.objectValue(null)
                    .serializationDataFormat(Variables.SerializationDataFormats.JSON)
                    .create();

            return objectValue;
        } else if (modelValue.getType() == ValueType.OBJECT) {
            try {
                final String jsonZaak = objectMapper.writeValueAsString(modelValue.getValue());
                return Variables.serializedObjectValue(jsonZaak, modelValue.isTransient()).create();
            } catch (JsonProcessingException e) {
                throw new ProcessEngineException("Expected value to be of type '" + ValueType.OBJECT + "' but got '" + modelValue.getType() + "'.");
            }
        } else {
            throw new ProcessEngineException("Expected value to be of type '" + ValueType.OBJECT + "' but got '" + modelValue.getType() + "'.");
        }
    }

    @Override
    public TypedValue convertToModelValue(TypedValue propertyValue) {
        Object value = propertyValue.getValue();
        if (value == null) {
            return Variables.objectValue(null, propertyValue.isTransient()).create();
        } else if (value instanceof Zaak) {
            return Variables.objectValue(value, propertyValue.isTransient()).create();
       /* } else if (value instanceof Zaak) {
            String strValue = ((String) value).trim();
            if (strValue.isEmpty()) {
                return Variables.dateValue(null, propertyValue.isTransient());
            }
            try {
                return Variables.dateValue((Date) dateFormat.parseObject(strValue), propertyValue.isTransient());
            } catch (ParseException e) {
                throw new ProcessEngineException("Could not parse value '" + value + "' as date using date format '" + datePattern + "'.");
            }*/
        } else {
            throw new ProcessEngineException("Value '" + value + "' cannot be transformed into a Date.");
        }
    }

    @Override
    public Object convertFormValueToModelValue(Object propertyValue) {
        if (propertyValue == null || "".equals(propertyValue)) {
            return null;
        }
        try {
            return objectMapper.readValue(propertyValue.toString(), Zaak.class);
        } catch (IOException e) {
            throw new ProcessEngineException("invalid value " + propertyValue);
        }
    }

    @Override
    public String convertModelValueToFormValue(Object modelValue) {
        if (modelValue == null) {
            return null;
        }
        try {
            return objectMapper.writeValueAsString(modelValue);
        } catch (JsonProcessingException e) {
            throw new ProcessEngineException("invalid form Value " + modelValue);
        }
    }

}
