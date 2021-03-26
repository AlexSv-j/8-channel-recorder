package com.svichkar.Drawing;

import com.svichkar.DataFromComPort;

import javax.swing.*;
import java.awt.*;

class TimeS_Div extends JPanel {

    private final DataFromComPort dataFromComPort = DataFromComPort.getInstance();
    private final Font font = new Font("Tahoma", Font.BOLD, 14);

    @Override
    public void paintComponent(Graphics g9) {
        Graphics2D gr = (Graphics2D) g9;
        gr.setColor(Color.white);
        gr.setFont(font);
        gr.drawString(dataFromComPort.getTimeScrolling() + " s/Div", 500, 10);
        gr.dispose();
    }
}
