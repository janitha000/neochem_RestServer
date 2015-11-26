package org.janitha.neochem.services;

import java.util.ArrayList;
import java.util.List;

import org.janitha.neochem.database.DatabaseClass;
import org.janitha.neochem.model.Item;

public class ItemService {
	DatabaseClass db = new DatabaseClass();

	public List<Item> getItems() {
		return db.getAll();

	}

	public Item getItem(long id) {
		
		return db.getItem(id);
	}

	public String addItem(Item item) {
		return db.addItem(item);
	}

	public Item updateItem( Item item) {
		db.updateItem(item);
		return item;

	}

	public void removeItem(long id) {
		db.deleteItem(id);
	}

}
