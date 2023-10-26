package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TodoItem {
    private String description;
    private String dueDate;
    private boolean isDone;

    public TodoItem(String description, String dueDate) {
        this.description = description;
        this.dueDate = dueDate;
        this.isDone = false;
    }

    public String getDescription() {
        return description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public boolean isDone() {
        return isDone;
    }

    public void markAsDone() {
        isDone = true;
    }

    @Override
    public String toString() {
        return "Description: " + description + " | Due Date: " + dueDate + " | Done: " + isDone;
    }
}

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

public class Todoapp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TodoList todoList = new TodoList();

        while (true) {
            System.out.println("Choose an operation:");
            System.out.println("1. Add a to-do item");
            System.out.println("2. View to-do items");
            System.out.println("3. Mark an item as done");
            System.out.println("4. Remove an item");
            System.out.println("5. Quit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter due date: ");
                    String dueDate = scanner.nextLine();
                    TodoItem newItem = new TodoItem(description, dueDate);
                    todoList.addItem(newItem);
                    break;
                case 2:
                    System.out.println("To-Do Items:");
                    todoList.displayItems();
                    break;
                case 3:
                    System.out.print("Enter the index of the item to mark as done: ");
                    int index = scanner.nextInt();
                    if (index >= 0 && index < todoList.items.size()) {
                        todoList.items.get(index).markAsDone();
                        System.out.println("Item marked as done.");
                    } else {
                        System.out.println("Invalid item index.");
                    }
                    break;
                case 4:
                    System.out.print("Enter the index of the item to remove: ");
                    int removeIndex = scanner.nextInt();
                    todoList.removeItem(removeIndex);
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try againsssssssssssssssssssssssssssssssssssssssssssssssssssss.");
            }
        }
    }
}
