package com.spring.map.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "passport_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Passport //CHILD
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

	@Column(name="dob")
	private LocalDate dob = LocalDate.now();

	@Column(name="signature")
	private String signature;

	@Column(name="expiration")
	private LocalDateTime expiration = LocalDateTime.now();

	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="person_id",referencedColumnName = "id")
	@JsonBackReference
	private Person persons;


}
