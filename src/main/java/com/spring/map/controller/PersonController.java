package com.spring.map.controller;

import java.awt.print.Pageable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.map.model.Person;
import com.spring.map.response.Message;
import com.spring.map.response.Response;
import com.spring.map.service.PersonService;


@RestController
@RequestMapping("/pers")
public class PersonController 
{
	Logger logger = LoggerFactory.getLogger(PersonController.class);

	@Autowired
	PersonService personService;


	@PostMapping("/persPost")
	public ResponseEntity<Object> create(@RequestBody Person person)
	{
		try
		{
		Person person1 = personService.create(person);
		Message message = new Message("Data Added..!!",person1);
		return Response.generateResponse("Data Addition = Success",true,HttpStatus.CREATED, message);
		}
		catch(Exception ex)
		{
			logger.error("Error while Create all category data: {}", ex.getMessage());
			return Response.generateResponse("Check Client/Server Error..!!",false,HttpStatus.BAD_GATEWAY,null);
		}
	}

	@PutMapping("/persPut")
	public ResponseEntity<Object> update(Long id,@RequestBody Person person)
	{
		try
		{	
		Person person1 = personService.update(id,person);
		Message message = new Message("Data Updated..!!",person1);
		return Response.generateResponse("Data Updation = Success",true,HttpStatus.OK, message);
		}catch(Exception ex)
		{
			logger.error("Error while Update all category data: {}", ex.getMessage());
			return Response.generateResponse("Check Client/Server Error..!!",false,HttpStatus.BAD_GATEWAY,null);
		}
	}

	@GetMapping("/persGet")
	public ResponseEntity<Object> read(@PageableDefault(size = 10, page = 0, sort = "name", direction = Direction.ASC) Pageable pageable)
	{
		try
		{
		personService.read();
		Message message = new Message("Data Readed..!!");
		return Response.generateResponse("Data Reading = Success",true,HttpStatus.OK, message);
		}
		catch (Exception ex)
		{
			logger.error("Error while get all category data: {}", ex.getMessage());
			return Response.generateResponse("Check Client/Server Error..!!",false,HttpStatus.BAD_GATEWAY,null);
        }
	}

	@DeleteMapping("/persDelete")
	public ResponseEntity<Object> delete(Long id)
	{
		try
		{
		personService.delete(id);
		Message message = new Message("Data Deleted..!!");
		return Response.generateResponse("Data Deletion = Success",true,HttpStatus.OK, message);
		}
		catch(Exception ex)
		{
			logger.error("Error while Delete category data: {}", ex.getMessage());
			return Response.generateResponse("Check Client/Server Error..!!",false,HttpStatus.BAD_GATEWAY,null);
		}
	}
}
