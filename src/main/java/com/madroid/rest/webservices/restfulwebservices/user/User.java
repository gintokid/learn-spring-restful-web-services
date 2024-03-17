package com.madroid.rest.webservices.restfulwebservices.user;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer id;
    private String name;
    private LocalDate birthDate;
}
