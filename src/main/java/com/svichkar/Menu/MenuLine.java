package com.svichkar.Menu;

import javax.swing.*;
import java.awt.*;

public class MenuLine {

    public JMenuBar menuBar(JFrame mainJFrame) {
        JMenuBar menuBar = new JMenuBar();
        menuBar.setLocation(0, 0);
        menuBar.setSize(new Dimension(800, 20));
        menuBar.setVisible(true);

        JMenu fileMenu = new JMenu("File"); //first menu-window

        JMenuItem saveImg = new JMenuItem("Save image");
        saveImg.addActionListener(new ImageSaver());

        JMenuItem saveTextData = new JMenuItem("Save data");
        saveTextData.addActionListener(new TextSaver());

        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(e -> System.exit(0));

        fileMenu.add(saveImg);
        fileMenu.add(saveTextData);
        fileMenu.add(exit);
        menuBar.add(fileMenu);

        JMenu help = new JMenu("Help"); //second menu-window
        JMenuItem about = new JMenuItem("About");
        about.addActionListener(new About(mainJFrame));
        help.add(about);
        menuBar.add(help);

        return menuBar;
    }
}
