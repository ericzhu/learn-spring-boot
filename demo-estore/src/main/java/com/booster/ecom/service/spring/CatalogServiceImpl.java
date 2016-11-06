package com.booster.ecom.service.spring;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booster.ecom.model.entity.Category;
import com.booster.ecom.model.entity.Item;
import com.booster.ecom.repository.db.ItemRepository;
import com.booster.ecom.service.CatalogService;

@Service
@Transactional
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Long addCategory(Category category) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Category> listCategories() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Category getCategory(Long categoryId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteCategory(Long categoryId) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateCategory(Category category) {
        // TODO Auto-generated method stub

    }

    @Override
    public Long addItem(Item item) {
        return itemRepository.save(item).getId();
    }

    @Override
    public List<Item> listItems() {
        // TODO Auto-generated method stub
        return null;
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
