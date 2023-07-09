package com.foly.assignment.service.impl;

import com.foly.assignment.entity.Item;
import com.foly.assignment.service.ShoppingCartService;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@SessionScope
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    Map<Integer, Item> map = new HashMap<>();

    @Override
    public void remove(Integer id) {
        map.remove(id);
    }

    @Override
    public Item update(Integer id, int qty) {
        Item item = map.get(id);
        item.setQty(qty);
        return item;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Collection<Item> getItems() {
        return map.values();
    }

    @Override
    public int getCount() {
        return map.values().stream().mapToInt(item -> item.getQty()).sum();
    }



    @Override
    public double getAmount() {
        return map.values().stream().mapToDouble(item -> item.getPrice()*item.getQty()).sum();
    }
}
