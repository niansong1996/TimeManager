package com.company;


import javax.swing.*;

public class TimeManager {

    public static void main(String[] args) {
        JFrame mainFrame =new JFrame();
        mainFrame.setSize(500, 300);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        MainPanel mainPanel =new MainPanel();
        
        mainFrame.getContentPane().add(mainPanel);
        
        mainFrame.setVisible(true);

    }
}


