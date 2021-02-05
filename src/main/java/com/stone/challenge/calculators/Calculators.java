package com.stone.challenge.calculators;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.stone.challenge.model.Person;

@Component
public class Calculators {

	private static final String PRECO = "Preco";
	private static final String QUANTIDADE = "Quantidade";

	public Integer getNumberOfItems(Person person) {

		return person.getItems().size();

	}

	public Integer getTotalAmountPayable(Person person) {

		return Math.multiplyExact(getSum(person, QUANTIDADE), getSum(person, PRECO));
	}

	private Integer getSum(Person person, String type) {

		Integer sum = getPriceOrQuantity(person, type).stream().mapToInt(Integer::intValue).sum();

		return sum;
	}

	public List<Integer> getPriceOrQuantity(Person person, String type) {

		List<Integer> pricesOrQuantity = new ArrayList<Integer>(getNumberOfItems(person));
		switch (type) {
		case PRECO:
			person.getItems().forEach(k -> pricesOrQuantity.add(k.getPreco()));
			break;

		case QUANTIDADE:
			person.getItems().forEach(k -> pricesOrQuantity.add(k.getQuantidade()));
			break;

		}

		return pricesOrQuantity;

	}

	public Reader readFile(String PATH_FILE) throws IOException {

		Reader reader = Files.newBufferedReader(Paths.get(PATH_FILE));

		return reader;

	}

}
