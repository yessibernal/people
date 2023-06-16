package com.innter.ms.people.utils;

import com.innter.commons.response.SuccessResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Component
public class ResponseUtils {
    public SuccessResponse successResponseOK(Object data, String message) {
        SuccessResponse successResponse = new SuccessResponse();
        successResponse.setCode(HttpStatus.OK.value());
        successResponse.setData(data);
        successResponse.setMessage(message);
        successResponse.setUUID(UUID.randomUUID().toString());
        return successResponse;
    }


    public SuccessResponse successResponseCreate(Object data, String message) {
        SuccessResponse successResponse = new SuccessResponse();
        successResponse.setCode(HttpStatus.CREATED.value());
        successResponse.setData(data);
        successResponse.setMessage(message);
        successResponse.setUUID(UUID.randomUUID().toString());
        return successResponse;
    }

    public SuccessResponse  successResponseOKVoid( String message){
        SuccessResponse successResponse = new SuccessResponse();
        successResponse.setCode(HttpStatus.OK.value());
        successResponse.setMessage(message);
        successResponse.setUUID(UUID.randomUUID().toString());
        return successResponse;
    }
}
