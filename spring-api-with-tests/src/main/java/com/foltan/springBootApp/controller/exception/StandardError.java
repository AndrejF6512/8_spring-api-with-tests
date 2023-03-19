package com.foltan.springBootApp.controller.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class StandardError {

    private String timestamp;
    private Integer status;
    private String error;
    private String path;
}
