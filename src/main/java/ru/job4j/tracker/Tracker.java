package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tracker {
    private final ArrayList<Item> items = new ArrayList<>();
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        size++;
        return item;
    }

    public int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rsl = index > -1;
        if (rsl) {
            item.setId(id);
            items.set(index, item);
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index > -1;
        if (rsl) {
            items.remove(index);
            size--;
        }
        return rsl;
    }

    public List<Item> findAll() {
        return items;
    }

    public List<Item> findByName(String key) {
        ArrayList<Item> rsl = new ArrayList<>();
        for (int index = 0; index < size; index++) {
            Item item = items.get(index);
            if (item.getName().equals(key)) {
                rsl.add(item);
            }
        }
        return rsl;
    }
}