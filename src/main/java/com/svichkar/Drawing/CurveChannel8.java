package com.svichkar.Drawing;

import com.svichkar.DataFromComPort;

import javax.swing.*;
import java.awt.*;

class CurveChannel8 extends JPanel {

    private final DataFromComPort dataFromComPort = DataFromComPort.getInstance();
    private final Font font = new Font("Tahoma", Font.BOLD, 14);
    private final AllCurveData allCurveData = AllCurveData.getInstance();

    @Override
    public void paintComponent(Graphics g8) {
        Graphics2D gr = (Graphics2D) g8;

        gr.setColor(Color.cyan);
        gr.drawPolyline(allCurveData.getXMassive(),
                allCurveData.getCurveMassive().get(7),
                allCurveData.getCurvePointCurveMassive());
        gr.setFont(font);
        gr.drawString(String.valueOf(dataFromComPort.getVoltageScrolling()[7]), 232, 10);
    }
}
