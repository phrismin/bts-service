package com.example.service.exception;

public class WorkerException extends RuntimeException {
    public WorkerException(Long id) {
        super(String.format("Worker with this id isn't exist: + id)"));
    }
}
