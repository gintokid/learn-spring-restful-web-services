package com.madroid.rest.webservices.restfulwebservices.filtering;


import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter("SomeBeanFilter")
//@JsonIgnoreProperties("field1")
public class SomeBean {

    private String field1;

    //@JsonIgnore
    private String field2;
    private String field3;
}
