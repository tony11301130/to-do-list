package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TodoUI {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("To-Do List App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        DefaultListModel<TodoItem> todoListModel = new DefaultListModel<>();
        JList<TodoItem> todoList = new JList<>(todoListModel);
        todoList.setCellRenderer(new TodoListCellRenderer());

        JTextField newItemField = new JTextField(20);
        JButton addButton = new JButton("Add");
        JButton deleteButton = new JButton("Delete");
        JButton completeButton = new JButton("Mark as Completed");
        JButton moveUpButton = new JButton(" Up ");
        JButton moveDownButton = new JButton("Down");
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0; 
        panel.add(addButton,gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 0; 
        panel.add(deleteButton,gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 0;         
        panel.add(completeButton,gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 3;
        gbc.gridy = 0;         
        panel.add(moveUpButton,gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 24;
        gbc.gridy = 0;         
        panel.add(moveDownButton,gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 2; 
        panel.add(todoList,gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 3;
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(newItemField,gbc);

        



        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newItemText = newItemField.getText();
                if (!newItemText.isEmpty()) {
                    TodoItem newItem = new TodoItem(newItemText);
                    todoListModel.addElement(newItem);
                    newItemField.setText("");
                }
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = todoList.getSelectedIndex();
                if (selectedIndex >= 0) {
                    todoListModel.remove(selectedIndex);
                }
            }
        });
        completeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = todoList.getSelectedIndex();
                if (selectedIndex >= 0) {
                    TodoItem selectedTodo = todoListModel.get(selectedIndex);
                    selectedTodo.setCompleted(true);
                    todoList.repaint();
                }
            }
        });
        moveUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = todoList.getSelectedIndex();
                if (selectedIndex > 0) {
                    TodoItem selectedTodo = todoListModel.get(selectedIndex);
                    todoListModel.remove(selectedIndex);
                    todoListModel.add(selectedIndex - 1, selectedTodo);
                    todoList.setSelectedIndex(selectedIndex - 1);
                }
            }
        });
        moveDownButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = todoList.getSelectedIndex();
                if (selectedIndex >= 0 && selectedIndex < todoListModel.getSize() - 1) {
                    TodoItem selectedTodo = todoListModel.get(selectedIndex);
                    todoListModel.remove(selectedIndex);
                    todoListModel.add(selectedIndex + 1, selectedTodo);
                    todoList.setSelectedIndex(selectedIndex + 1);
                }
            }
        });

        frame.setSize(800, 300);
        frame.add(panel);
        frame.setVisible(true);

    }

    static class TodoItem {
        private String text;
        private boolean completed;

        public TodoItem(String text) {
            this.text = text;
            this.completed = false;
        }

        public String getText() {
            return text;
        }

        public boolean isCompleted() {
            return completed;
        }

        public void setCompleted(boolean completed) {
            this.completed = completed;
        }

        @Override
        public String toString() {
            return text;
        }
    }

    static class TodoListCellRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (value instanceof TodoItem) {
                TodoItem todoItem = (TodoItem) value;
                if (todoItem.isCompleted()) {
                    c.setForeground(Color.GREEN);
                } else {
                    c.setForeground(Color.BLACK);
                }
            }
            return c;
        }
    }
}
