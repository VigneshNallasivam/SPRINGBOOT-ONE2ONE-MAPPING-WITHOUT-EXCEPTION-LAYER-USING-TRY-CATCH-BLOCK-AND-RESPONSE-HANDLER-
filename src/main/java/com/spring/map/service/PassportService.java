package com.spring.map.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.map.model.Passport;
import com.spring.map.repository.PassportRepository;

@Service
//@Transactional
public class PassportService 
{
	@Autowired
	PassportRepository passportRepository;

	public Passport create(Passport passport) 
	{
		return passportRepository.save(passport);	
	}

	public Passport update(Long id,Passport passport) throws Exception 
	{
		Passport passport2 = passportRepository.findById(id).get();
		if(passportRepository.findById(id).isPresent())
		{
			passport2.setName(passport.getName());
			passport2.setPlace(passport.getPlace());
			passport2.setDob(passport.getDob());
			passport2.setSignature(passport.getSignature());
			passport2.setExpiration(passport.getExpiration());
			passportRepository.save(passport2);
			return passport2;
		}
		else
		{
			throw new Exception("ID NOT-FOUND..!!");
		}
		
	}

	public List<Passport> read() throws Exception 
	{
		if(passportRepository!=null)
		{
			return passportRepository.findAll();
		}
		else
		{
			throw new Exception("EMPTY DATA-BASE..!!");
		}
	
	}

	public void delete(Long id) throws Exception
	{
		Passport passport  = passportRepository.findById(id).get();
		if(passportRepository.findById(id).isPresent())
		{
			passportRepository.deleteById(id);
		}
		else
		{
			throw new Exception("ID NOT-FOUND..!!");
		}

	}

}
