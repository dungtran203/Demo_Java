package com.foly.assignment.service;

import com.foly.assignment.entity.Item;

import java.util.Collection;

public interface ShoppingCartService {

    void remove(Integer id);

    Item update(Integer id, int qty);

    void clear();

    Collection<Item> getItems();

    int getCount();

    double getAmount();
}
