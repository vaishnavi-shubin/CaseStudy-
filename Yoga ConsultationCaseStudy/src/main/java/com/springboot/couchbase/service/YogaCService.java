package com.springboot.couchbase.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.couchbase.entity.YogaC;
import com.springboot.couchbase.exception.EntityNotFound;
import com.springboot.couchbase.repository.YogaCRepository;

//spring annotation
@Service
public class YogaCService {

    @Autowired
    YogaCRepository repository;

    //save new YogaC in the couchbase
    public void save(final YogaC e) {
        repository.save(e);
    }

    //get total count in the couchbase
    public long count() {
        return repository.count();
    }

    //get all YogaCs from the couchbase
    public List<YogaC> getYogaCs() {
        final Iterable<YogaC> YogaCIterable = repository.findAll();
        return StreamSupport.stream(YogaCIterable.spliterator(), false).collect(Collectors.toList());
    }

    //get YogaC by id from the couchbase
    public YogaC getYogaC(final String id) throws EntityNotFound {
        return repository.findById(id).orElseThrow(EntityNotFound::new);
    }

  //insert YogaC by id from the couchbase
    public YogaC insertYogaC(final YogaC YogaC) throws EntityNotFound {
        return repository.save(YogaC);
    }
    
  //update YogaC by id from the couchbase
    public YogaC updateYogaC(final YogaC YogaC) throws EntityNotFound {
        return repository.save(YogaC);
    }
    
  //delete YogaC by id from the couchbase
    public void deleteYogaC(final String id) throws EntityNotFound{
        repository.deleteById(id);
    }
    //get YogaCs by department from the couchbase
    public List<YogaC> getYogaCsByemail(final String email) {
        return repository.findAllByemail(email);
    }
}
