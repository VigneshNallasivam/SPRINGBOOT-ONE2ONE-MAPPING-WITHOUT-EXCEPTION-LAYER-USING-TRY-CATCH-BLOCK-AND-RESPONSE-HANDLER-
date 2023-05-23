package com.spring.map.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="person_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Person //PARENT
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@Pattern(regexp="^[A-Za-z]{2,15}$")	
	@Column(name="name")
	private String name;
	
	@Column(name="place")
	private String place;
	
	@Column(name="age")
	private String age;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="mobile")
	private long mobile;
	
	@Column(name="mail")
	private String mail;
	
	@OneToOne(mappedBy = "persons" ,cascade = CascadeType.ALL)
	@JsonManagedReference
	private Passport passports;

}
