package com.example.rest.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkerErrorResponse {
    private int status;
    private String message;
    private long timeStamp;
}
