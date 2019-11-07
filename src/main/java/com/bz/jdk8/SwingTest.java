package com.bz.jdk8;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SwingTest {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("My JFrame");
        JButton jButton = new JButton("My Button");

        jButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("普通形式");
            }
        });

        jButton.addActionListener(event -> System.out.println("Lambda 表达式形式"));


        jFrame.add(jButton);
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
