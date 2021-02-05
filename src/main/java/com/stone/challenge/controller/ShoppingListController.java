package com.stone.challenge.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stone.challenge.impl.ShoppingListImpl;
import com.stone.challenge.model.Person;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*")
@Api(value = "Stone Challenge  - Shopping ListS")
@RequestMapping("/api/")
public class ShoppingListController {

	@Autowired
	private ShoppingListImpl shoppingListImpl;

	@ApiOperation(value = "Return all data from dataset.")
	@GetMapping(value = "/all")
	public List<Person> findAll() throws IOException {
		return shoppingListImpl.findAll();
	}

	@ApiOperation(value = "Return one Person by id.")
	@GetMapping(value = "/id/{id}")
	public Person findById(@PathVariable(name = "id") Integer id) throws IOException, AttributeNotFoundException {
		return shoppingListImpl.findById(id);
	}

	@ApiOperation(value = "Return one Person by email.")
	@GetMapping(value = "/email/{email}")
	public Person findByName(@PathVariable(name = "email") String email) throws IOException, AttributeNotFoundException {
		return shoppingListImpl.findByEmail(email);
	}

	@ApiOperation(value = "Returns the person and the amount they must pay for their shopping list.")
	@GetMapping(value = "/amount/payable/email/{email}")
	public Map<String, String> getBalancePayablePerPerson(@PathVariable(name = "email") String email)
			throws IOException, AttributeNotFoundException {
		return shoppingListImpl.getBalancePayablePerPerson(email);
	}

}
