package com.aris.employee.management.api.dto;

public class EmptyResponseDTO {

    public static String MESSAGE_EMPTY = "void";

    public EmptyResponseDTO() {
    }

    public String getMessage() {
        return MESSAGE_EMPTY;
    }
}

