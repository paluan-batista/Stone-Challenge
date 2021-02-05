package com.stone.challenge.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.stone.challenge.calculators.Calculators;
import com.stone.challenge.model.Person;

@Service
public class ShoppingListService {

	private static final String PATH_FILE = "src/main/resources/ShoppingList.json";

	@Autowired
	private Calculators calculators;

	Gson gson = new Gson();

	public List<Person> findAll() throws IOException {
		List<Person> persons = gson.fromJson(calculators.readFile(PATH_FILE), new TypeToken<List<Person>>() {
		}.getType());

		if (persons.isEmpty()) {
			throw new NoSuchElementException();
		}
		return persons;
	}

	public Person findById(Integer id) throws IOException, AttributeNotFoundException {

		List<Person> persons = findAll();

		Person findPersonById = persons.stream().filter(x -> id.equals(x.getId())).findAny()
				.orElseThrow(() -> new AttributeNotFoundException("Couldn't load index set with ID <" + id + ">"));

		return findPersonById;

	}

	public Person findByEmail(String email) throws IOException, AttributeNotFoundException {

		List<Person> persons = findAll();

		Person findPersonByEmail = persons.stream().filter(x -> email.equals(x.getEmail())).findAny().orElseThrow(
				() -> new AttributeNotFoundException("Couldn't load index set with Email <" + email + ">"));

		return findPersonByEmail;

	}

	public Map<String, String> getBalancePayablePerPerson(String email) throws IOException, AttributeNotFoundException {

		Person person = findByEmail(email);

		Integer numberOfItems = calculators.getNumberOfItems(person);
		Map<String, String> result = new HashMap<String, String>(numberOfItems);
		result.put(person.getEmail(), "R$ " + String.valueOf(calculators.getTotalAmountPayable(person)));
		return result;

	}

}
