package com.ibs.customermanagement.web_tier.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class BaseRequestResponse {

    private Integer responseCode;
    private String responseMessage;
}
