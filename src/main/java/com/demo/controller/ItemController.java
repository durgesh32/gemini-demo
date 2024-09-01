package com.demo.controller;

import com.demo.model.Item;
import com.demo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/items")
public class ItemController {

	private final ItemService itemService;

	@Autowired
	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}

	@PostMapping
	public ResponseEntity<Item> createItem(@RequestBody Item item) {
		Item savedItem = itemService.saveItem(item);
		return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
	}
}

