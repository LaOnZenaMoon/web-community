package me.lozm.global.service;

import me.lozm.object.dto.ApiException;
import me.lozm.object.dto.ApiResponseDto;

public class BaseService {

    static public void checkResponseBody(ApiResponseDto dto, String exceptionMessage) throws ApiException {
        if(!dto.isSuccess()) {
            throw new ApiException(null, exceptionMessage);
        }
    }

}
