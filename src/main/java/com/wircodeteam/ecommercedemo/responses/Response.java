package com.wircodeteam.ecommercedemo.responses;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public abstract class Response implements Serializable {
    private int httpStatus;
    private final LocalDateTime dateTime=LocalDateTime.now();
    private String message;
    private String title;
    private String path;
}
