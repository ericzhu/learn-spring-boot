package com.booster.ecom.service.spring;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booster.ecom.model.entity.Category;
import com.booster.ecom.model.entity.Item;
import com.booster.ecom.repository.db.CategoryRepository;
import com.booster.ecom.repository.db.ItemRepository;
import com.booster.ecom.service.CatalogService;

@Service
@Transactional
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    private ItemRepository     itemRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Long addCategory(Category category) {
        return categoryRepository.save(category).getId();
    }

    @Override
    public List<Category> listCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategory(Long categoryId) {
        return categoryRepository.getOne(categoryId);
    }

    @Override
    public void deleteCategory(Long categoryId) {
        categoryRepository.delete(categoryId);
    }

    @Override
    public void updateCategory(Category category) {
        Category persistentCategory = getCategory(category.getId());
        persistentCategory.setName(category.getName());
        persistentCategory.setDescription(category.getDescription());
    }

    @Override
    public Long addItem(Item item) {
        return itemRepository.save(item).getId();
    }

    @Override
    public List<Item> listItems() {
        return itemRepository.findAll();
    }

    @Override
    public List<Item> listItemsByKeyword(String keyword) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Item> listItemsByCategory(Long categoryId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Item> listSelectedItems() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Item getItem(Long itemId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteItem(Long itemId) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateItem(Item item) {
        // TODO Auto-generated method stub

    }

}
