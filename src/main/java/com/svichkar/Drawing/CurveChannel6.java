package com.svichkar.Drawing;

import com.svichkar.DataFromComPort;

import javax.swing.*;
import java.awt.*;

class CurveChannel6 extends JPanel {

    private final DataFromComPort dataFromComPort = DataFromComPort.getInstance();
    private final Font font = new Font("Tahoma", Font.BOLD, 14);
    private final AllCurveData allCurveData = AllCurveData.getInstance();

    @Override
    public void paintComponent(Graphics g6) {
        Graphics2D gr = (Graphics2D) g6;

        gr.setColor(Color.orange);
        gr.drawPolyline(allCurveData.getXMassive(),
                allCurveData.getCurveMassive().get(5),
                allCurveData.getCurvePointCurveMassive());
        gr.setFont(font);
        gr.drawString(String.valueOf(dataFromComPort.getVoltageScrolling()[5]), 168, 10);
    }
}
