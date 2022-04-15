package com.example.service.exception;

public class WorkerServiceException extends RuntimeException {

    public WorkerServiceException() {
    }

    public WorkerServiceException(String message) {
        super(message);
    }
}
