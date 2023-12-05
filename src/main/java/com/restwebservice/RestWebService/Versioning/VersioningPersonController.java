package com.restwebservice.RestWebService.Versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class VersioningPersonController {

    @GetMapping("/v1/person")
    public PersonV1 getVersion1Person(){
        return new PersonV1("md imran");
    }
    @GetMapping("/v2/person")
    public PersonV2 getVersion2Person(){
        return new PersonV2(new Name("md", "imran"));
    }
    @GetMapping(path="/api/version", headers = "X-API-VERSION=v1")
    public PersonV1 getVersionFromHeadersV1(){
        return new PersonV1("md imran");
    }@GetMapping(path="/api/version", headers = "X-API-VERSION=v2")
    public PersonV2 getVersionFromHeadersV2(){

            return new PersonV2(new Name("md", "imran"));

    }
}
