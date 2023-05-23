package com.spring.map.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Message 
{
	public String message;
	public Object object;
	
	public Message(String message, Object object) 
	{
		this.message = message;
		this.object = object;
	}
	
	public Message(String message) 
	{
		this.message = message;
	}
	
	public Message() 
	{
		super();
	}
}
