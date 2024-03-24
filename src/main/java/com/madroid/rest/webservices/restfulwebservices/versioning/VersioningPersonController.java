package com.madroid.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    @GetMapping("/v1/person")
    public PersonV1 getFirstVersionOfPerson() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping("/v2/person")
    public PersonV2 ge2ndVersionOfPerson() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    @GetMapping(value = "/person", params = "version=1")
    public PersonV1 getFirstVersionOfPersonWithParam() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(value = "/person", params = "version=2")
    public PersonV2 getSecondVersionOfPersonWithParam() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    @GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 getFirstVersionOfPersonWithHeader() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 getSecondVersionOfPersonWithHeader() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    @GetMapping(value = "/person/accept", produces = "application/vnd.company.app-v1+json")
    public PersonV1 getFirstVersionOfPersonWithAcceptHeader() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(value = "/person/accept", produces = "application/vnd.company.app-v2+json")
    public PersonV2 getSecondVersionOfPersonWithAcceptHeader() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

}
