package br.com.alura.jdbc.model;

import java.util.ArrayList;
import java.util.List;

public class Category {
	private Integer id;
	private String name;
	private List<Product> products = new ArrayList<Product>();

	public Category(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Integer getId() {
		return id;
	}

	public void add(Product product) {
		products.add(product);
	}

	public List<Product> getProducts() {
		return products;
	}
}
