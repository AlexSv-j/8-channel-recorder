package com.svichkar.Drawing;

import javax.swing.*;
import java.awt.*;

public class DrawingArea extends JPanel {

    @Override
    public void paintComponent(Graphics g) {

        Graphics2D gr = (Graphics2D) g;
        gr.setColor(new Color(0, 0, 0));
        gr.fillRect(0, 0, 660, 300);
        BasicStroke border = new BasicStroke(2);
        gr.setStroke(border);
        gr.setColor(new Color(0, 0, 255));
        gr.drawRect(10, 27, 640, 256);

        BasicStroke lines = new BasicStroke(1);
        gr.setStroke(lines);

        for (int i = 42; i <= 618; i += 32) {
            gr.drawLine(i, 27, i, 283);
        }

        for (int i = 59; i <= 251; i += 32) {
            gr.drawLine(10, i, 650, i);
        }
    }
}
