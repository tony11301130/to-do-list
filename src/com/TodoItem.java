package com;

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