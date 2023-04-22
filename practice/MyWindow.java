package com.practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyWindow extends JFrame {
    private JLabel heading;
    private JLabel clockLable;
    private Font font = new Font("", Font.BOLD, 35);

    MyWindow() {
        super.setTitle("Digital Clock");
        super.setSize(500, 500);
        super.setLocation(300, 50);
        this.CreateGUI();
        this.StartClock();
        super.setVisible(true);

    }

    public void CreateGUI() {
        heading = new JLabel("MY CLOCK");
        heading.setLocation(450, 250);
        clockLable = new JLabel("clock");
        setBackground(Color.gray);
        heading.setFont(font);
        clockLable.setFont(font);
        this.setLayout(new GridLayout(2, 1));
        this.add(heading);
        this.add(clockLable);
    }

    public void StartClock() {
//        Timer timer = new Timer(1000, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                //       String dateTime = new Date().toString();
//                String dateTime = new Date().toLocaleString();
//                clockLable.setText(dateTime);
//            }
//        });
//        timer.start();

        Thread t = new Thread() {
            public void run() {
                try {
                    while (true) {
                        Date d = new Date();
                        SimpleDateFormat sfd = new SimpleDateFormat("hh:mm:ss a");
                        String dateTime = sfd.format(d);
                        clockLable.setText(dateTime);
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        };

        t.start();
   }
}

