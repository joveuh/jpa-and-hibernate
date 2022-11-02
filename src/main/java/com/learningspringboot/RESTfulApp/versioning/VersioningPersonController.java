package com.learningspringboot.RESTfulApp.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    @GetMapping("/v1/person")
    public PersonV1 getFirstVersionOfPerson() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping("/v2/person")
    public PersonV2 getSecondVersionOfPerson() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    @GetMapping(path = "/person", params = "version=1")
    public PersonV1 getVersionedPerson1() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(path = "/person", params = "version=2")
    public PersonV2 getVersionedPerson2() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    @GetMapping(path = "/person/header", headers = "RANDOM-HEADER=1")
    public PersonV1 getHeaderedPerson1() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(path = "/person/header", headers = "RANDOM-HEADER=2")
    public PersonV2 getHeaderedPerson2() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    @GetMapping(path = "/person/accpet", produces = "application/vndtest")
    public PersonV2 getVerionedPersonAcceptHeader() {
        return new PersonV2(new Name("Test", "Charlie"));
    }
}