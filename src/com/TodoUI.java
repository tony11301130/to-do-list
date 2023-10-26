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
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        frame.add(panel);

        DefaultListModel<String> todoListModel = new DefaultListModel<>();
        JList<String> todoList = new JList<>(todoListModel);

        JTextField newItemField = new JTextField(20);
        JButton addButton = new JButton("Add");
        JButton deleteButton = new JButton("Delete Selected");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newItem = newItemField.getText();
                if (!newItem.isEmpty()) {
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

        panel.add(newItemField);
        panel.add(addButton);
        panel.add(todoList);
        panel.add(deleteButton);

        frame.setVisible(true);
    }
}
