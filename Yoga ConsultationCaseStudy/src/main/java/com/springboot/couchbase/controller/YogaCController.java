package com.springboot.couchbase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.couchbase.entity.YogaC;
import com.springboot.couchbase.exception.EntityNotFound;
import com.springboot.couchbase.service.YogaCService;

import lombok.extern.slf4j.Slf4j;

//lombok annotation
@Slf4j
//spring annotations
@RestController
@RequestMapping("/api")
public class YogaCController {

    @Autowired
    YogaCService service;

    //URL - http://localhost:9300/api/YogaCs
    @GetMapping("/YogaCs")
    @ResponseStatus(HttpStatus.OK)
    public List<YogaC> getYogaCs() {
        return service.getYogaCs();
    }

    //URL - http://localhost:9300/api/YogaC/<eid>
    //Example - http://localhost:9300/api/YogaC/73a02968-70a8-426a-b6d8-deaa96a597df
    @GetMapping("/YogaC/{id}")
    @ResponseStatus(HttpStatus.OK)
    public YogaC getYogaCById(@PathVariable String id)
            throws EntityNotFound {
        return service.getYogaC(id);
    }

    //URL - http://localhost:9300/api/YogaC/<work_department>
    //Example - http://localhost:9300/api/YogaCs/Health
    @GetMapping("/YogaCs/{email}")
    @ResponseStatus(HttpStatus.OK)
    public List<YogaC> getYogaCByemail(@PathVariable(name = "email") String email) {
        return service.getYogaCsByemail(email);
    }

    //URL - http://localhost:9300/api/YogaCs/count
    @GetMapping("/YogaCs/count")
    @ResponseStatus(HttpStatus.OK)
    public long getTotalYogaCs() {
        return service.count();
    }
    
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.OK)
    public YogaC registerYogaC(@RequestBody YogaC YogaC) throws EntityNotFound {
        return service.insertYogaC(YogaC);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public YogaC updateYogaC(@RequestBody YogaC YogaC) throws EntityNotFound {
        return service.updateYogaC(YogaC);
    }
    
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteYogaC(@PathVariable("id") String id) throws EntityNotFound {
        service.deleteYogaC(id);
        
        return "YogaC deleted successfully";
    }
}
