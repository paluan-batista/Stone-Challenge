package com.stone.challenge.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.stone.challenge.calculators.Calculators;
import com.stone.challenge.model.Person;

@Service
public class ShoppingListService {

	private static final String PATH_FILE = "src/main/resources/ShoppingList.json";
	
	private static final Gson GSON = new Gson();

	
	private Calculators calculators;

	public ShoppingListService(Calculators calculators) {
		this.calculators = calculators;
	}
	

	public List<Person> findAll() throws IOException {
		List<Person> persons = GSON.fromJson(calculators.readFile(PATH_FILE), new TypeToken<List<Person>>() {
		}.getType());

		if (persons.isEmpty()) {
			throw new NoSuchElementException();
		}
		return persons;
	}

	public Person findById(Integer id) throws IOException {

		List<Person> persons = findAll();

		Person findPersonById = persons.stream().filter(x -> id.equals(x.getId())).findAny()
				.orElseThrow(NoSuchElementException::new);

		return findPersonById;

	}

	public Person findByEmail(String email) throws IOException {

		List<Person> persons = findAll();

		Person findPersonByEmail = persons.stream().filter(x -> email.equals(x.getEmail())).findAny()
				.orElseThrow(NoSuchElementException::new);

		return findPersonByEmail;

	}

	public Map<String, String> getBalancePayablePerPerson(String email) throws IOException {

		Person person = findByEmail(email);

		Integer numberOfItems = calculators.getNumberOfItems(person);
		Map<String, String> result = new HashMap<String, String>(numberOfItems);
		result.put(person.getEmail(), "R$ " + String.valueOf(calculators.getTotalAmountPayable(person)));
		return result;

	}

}
