package com.spring.map.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.spring.map.model.Passport;

@Repository
public interface PassportRepository extends JpaRepository<Passport,Long>
{

}
