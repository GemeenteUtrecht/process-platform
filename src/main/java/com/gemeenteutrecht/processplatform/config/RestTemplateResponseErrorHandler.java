package com.gemeenteutrecht.processplatform.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;
import org.testcontainers.shaded.com.google.common.io.ByteStreams;

import java.io.IOException;
import java.nio.charset.Charset;

import static org.springframework.http.HttpStatus.Series.CLIENT_ERROR;
import static org.springframework.http.HttpStatus.Series.SERVER_ERROR;

@Component
public class RestTemplateResponseErrorHandler implements ResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse httpResponse) throws IOException {
        return (httpResponse.getStatusCode().series() == CLIENT_ERROR || httpResponse.getStatusCode().series() == SERVER_ERROR);
    }

    @Override
    public void handleError(ClientHttpResponse httpResponse) throws IOException {
        final String responseString = new String(ByteStreams.toByteArray(httpResponse.getBody()), Charset.forName("UTF-8"));

        if (httpResponse.getStatusCode().series() == SERVER_ERROR) {
            // handle SERVER_ERROR
        } else if (httpResponse.getStatusCode().series() == CLIENT_ERROR) {
            // handle CLIENT_ERROR
            if (httpResponse.getStatusCode() == HttpStatus.NOT_FOUND) {
                //throw new NotFoundException();
            }
        }
    }

}
