package com.restapi.application.student;

import jakarta.validation.constraints.NotEmpty;

public record StudentDTO(

        @NotEmpty(message="first name should not be empty")
        String firstName,

        @NotEmpty(message = "last name should not be empty")
        String lastName,

        String email,

        Integer age,

        Integer schoolId
) {
}
