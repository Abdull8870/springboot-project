package com.restapi.application.school;

import jakarta.validation.constraints.NotEmpty;

public record SchoolDTO(
        @NotEmpty(message = "School Name Cannot be Empty")
        String schoolName
) {
}
