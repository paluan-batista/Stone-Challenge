package com.stone.challenge.impl;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.stone.challenge.model.Person;

public interface ShoppingListInterface {
	
	public List<Person> findAll() throws IOException;
	
	public Person findById(Integer id) throws IOException;
	
	public Person findByEmail(String email) throws IOException;
	
	public Map<String, String> getBalancePayablePerPerson(String email) throws IOException;

}
