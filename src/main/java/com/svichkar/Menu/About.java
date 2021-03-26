package com.svichkar.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class About implements ActionListener {

    private static final String author = "Alex Svichkar";
    private static final String version = "2.0";
    private static final String e_mail = "AlexTwoBoard@gmail.com";
    private final JFrame mainJFrame;

    public About(JFrame mainJFrame) {
        this.mainJFrame = mainJFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        JDialog dialog = new JDialog(mainJFrame, "Author", true);
        dialog.setBounds(screenSize.width / 2 - 125, screenSize.height / 2 - 150, 250, 180);
        dialog.setLayout(new GridLayout(5, 0, 5, 12));

        dialog.add(new JLabel());
        dialog.add(new JLabel("Author: " + author, SwingConstants.CENTER));
        dialog.add(new JLabel("Version: " + version, SwingConstants.CENTER));
        dialog.add(new JLabel("E-mail: " + e_mail, SwingConstants.CENTER));

        dialog.setVisible(true);
    }
}
