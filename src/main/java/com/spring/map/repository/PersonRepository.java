package com.spring.map.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.map.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long>{

}
