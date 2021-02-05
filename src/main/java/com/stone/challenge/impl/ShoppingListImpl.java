package com.stone.challenge.impl;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stone.challenge.model.Person;
import com.stone.challenge.service.ShoppingListService;

@Component
public class ShoppingListImpl implements ShoppingListInterface {

	@Autowired
	private ShoppingListService service;

	@Override
	public List<Person> findAll() throws IOException {

		return service.findAll();
	}

	@Override
	public Person findById(Integer id) throws IOException {
		return service.findById(id);
	}

	@Override
	public Person findByEmail(String email) throws IOException {
		return service.findByEmail(email);
	}

	@Override
	public Map<String, String> getBalancePayablePerPerson(String email) throws IOException {
		
		return service.getBalancePayablePerPerson(email);
	}

}
