package com.booster.ecom.service;

import java.util.List;

import com.booster.ecom.model.entity.Category;
import com.booster.ecom.model.entity.Item;

public interface CatalogService {

    // category related methods
    public Long addCategory(Category category);

    public List<Category> listCategories();

    public Category getCategory(Long categoryId);

    public void deleteCategory(Long categoryId);

    public void updateCategory(Category category);

    // item related methods
    public Long addItem(Item item);

    public List<Item> listItems();

    public List<Item> listItemsByKeyword(String keyword);

    public List<Item> listItemsByCategory(Long categoryId);

    public List<Item> listSelectedItems();

    public Item getItem(Long itemId);

    public void deleteItem(Long itemId);

    public void updateItem(Item item);

}
