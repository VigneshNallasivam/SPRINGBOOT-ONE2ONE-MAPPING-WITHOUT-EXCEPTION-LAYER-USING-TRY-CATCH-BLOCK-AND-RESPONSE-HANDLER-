package com.spring.map.service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.map.model.Person;
import com.spring.map.repository.PersonRepository;

@Service
//@Transactional
public class PersonService 
{
	@Autowired
	PersonRepository personRepository;

	public Person create(Person person) 
	{
		return personRepository.save(person);	
	}

	public Person update(Long id,Person person) throws Exception 
	{
		Person person2 = personRepository.findById(id).get();
		if(personRepository.findById(id).isPresent())
		{
			person2.setName(person.getName());
			person2.setPlace(person.getPlace());
			person2.setAge(person.getAge());
			person2.setGender(person.getGender());
			person2.setMobile(person.getMobile());
			person2.setMail(person.getMail());
			personRepository.save(person2);
			return person2;
		}
		else
		{
			throw new Exception("ID NOT-FOUND..!!");
		}
		
	}

	public List<Person> read() throws Exception 
	{
		if(personRepository!=null)
		{
		return personRepository.findAll();
		}
		else
		{
			throw new Exception("EMPTY DATA-BASE..!!");
		}
	}

	public void delete(Long id) throws Exception
	{
		Person person  = personRepository.findById(id).get();
		if(personRepository.findById(id).isPresent())
		{
			personRepository.deleteById(id);
		}
		else
		{
			throw new Exception("ID NOT-FOUND..!!");
		}

	}
}
