package com.company;


import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame jf1=new JFrame();

        mainFrame mf1=new mainFrame();
        jf1.setVisible(true);
        jf1.add(mf1);
        mf1.setVisible(true);

    }
}


