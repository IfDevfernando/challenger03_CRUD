package com.challenger03.challenger03_crud.dto;

import java.time.LocalDate;

import com.challenger03.challenger03_crud.entities.Client;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

public class ClientDTO {
	
	private Long id;
	
	@Size(min=3,max=80,message="Name must have a minimum of 3 and a maximum 8 characters")
	@NotBlank(message="Required field")
	private String name;
	
	@Size(min=11,message="CPF must have 11 numbers")
	@NotBlank(message="Required field")
	private String cpf;
	
	private Double income;
	
	@PastOrPresent(message="The date of birth cannot be in the future")
	@NotNull
	private LocalDate birthDate;
	
	private Integer children;
	
	
	
	public ClientDTO(Long id, String name, String cpf, Double income, LocalDate birthDate, Integer children) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.income = income;
		this.birthDate = birthDate;
		this.children = children;
	}
	
	public ClientDTO(Client entity) {
		super();
		id = entity.getId();
		name =entity.getName();
		cpf = entity.getCpf();
		income = entity.getIncome();
		birthDate = entity.getBirthDate();
		children = entity.getChildren();
	}
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getCpf() {
		return cpf;
	}
	public Double getIncome() {
		return income;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public Integer getChildren() {
		return children;
	}
	
	

}
