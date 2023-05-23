package com.spring.map.response;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Response 
{
	public static ResponseEntity<Object> generateResponse(String message, Boolean status, HttpStatus statuscode, Object object)
	{
		Map<String, Object> map = new HashMap<>();
		map.put("message", message);
		map.put("status", status);
		map.put("statuscode", statuscode.value());
		map.put("data",object);
		return new ResponseEntity<>(map,statuscode);
	}
}
