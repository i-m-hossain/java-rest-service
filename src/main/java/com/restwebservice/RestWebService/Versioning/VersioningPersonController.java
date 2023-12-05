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
}
