package com.stone.challenge.utils;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.stone.challenge.model.Person;

@Component
public class Utils {

	public Integer getNumberOfItems(Person person) {
		return person.getItems().size();

	}

	public Integer getTotalAmountPayable(Person person) {

		return Math.multiplyExact(getTotalQuantity(person), getSumPrices(person));
	}

	private Integer getSumPrices(Person person) {
		List<Integer> prices = new ArrayList<Integer>(getNumberOfItems(person));

		person.getItems().forEach(k -> prices.add(k.getPreco()));

		Integer sumPrices = prices.stream().mapToInt(Integer::intValue).sum();

		return sumPrices;
	}

	private Integer getTotalQuantity(Person person) {
		List<Integer> totalQuantity = new ArrayList<Integer>(getNumberOfItems(person));

		person.getItems().forEach(k -> totalQuantity.add(k.getQuantidade()));

		Integer sumTotalQuantity = totalQuantity.stream().mapToInt(Integer::intValue).sum();

		return sumTotalQuantity;

	}

	public Reader readFile(String PATH_FILE) throws IOException {

		Reader reader = Files.newBufferedReader(Paths.get(PATH_FILE));

		return reader;

	}

}
