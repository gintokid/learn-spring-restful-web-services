package com.madroid.rest.webservices.restfulwebservices.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer id;

    @Size(min = 3, message = "Name should have at least 2 characters")
    @JsonProperty("user_name")
    private String name;

    @Past(message = "Birth Date should be in the past")
    @JsonProperty("birth_date")
    private LocalDate birthDate;
}
