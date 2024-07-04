package com.tracledger.web.Utils;

import lombok.Data;
@Data
public class APIResponse {
    private Boolean result;
    private Integer statusCode;
    private String statusCodeDescription;
    private String message;
    private Object response;
}
