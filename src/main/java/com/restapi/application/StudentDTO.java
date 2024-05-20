package com.restapi.application;

import jakarta.persistence.Column;

public record StudentDTO(
        String firstName,

        String lastName,

        String email,

        Integer age,

        Integer schoolId
) {
}
