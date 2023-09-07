package com.springboot.couchbase.repository;

import java.util.List;

import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.couchbase.entity.YogaC;

//couchbase annotations
@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "YogaC")
//spring annotation
@Repository
public interface YogaCRepository extends CrudRepository<YogaC, String> {

	List<YogaC> findAllByemail(String email);
}
