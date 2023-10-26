package com;

import java.util.List;
import java.util.ArrayList;

class TodoList {
    List<TodoItem> items;

    public TodoList() {
        items = new ArrayList<>();
    }

    public void addItem(TodoItem item) {
        items.add(item);
    }

    public void displayItems() {
        for (int i = 0; i < items.size(); i++) {
            System.out.println("Item " + (i + 1) + ": " + items.get(i));
        }
    }

    public void removeItem(int index) {
        if (index >= 0 && index < items.size()) {
            items.remove(index);
            System.out.println("Item removed.");
        } else {
            System.out.println("Invalid item index.");
        }
    }
}
