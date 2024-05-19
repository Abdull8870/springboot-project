package com.restapi.application;

import com.fasterxml.jackson.annotation.JsonProperty;

public record OrderRecord(int quantity,

        String customerName,

        String productName) {


}
