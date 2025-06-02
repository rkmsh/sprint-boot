package com.rkmsh.request_handler.requestResponseModels;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class CommonResponseModel {

    private String status;
    private String message;
    private String data;
    private String errorCode;
    private String errorMessage;

    
    CommonResponseModel(String status, String message, String data, String errorCode, String errorMessage) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
