package com.svichkar.Drawing;

import com.svichkar.DataFromComPort;

import javax.swing.*;
import java.awt.*;

class CurveChannel4 extends JPanel {

    private final DataFromComPort dataFromComPort = DataFromComPort.getInstance();
    private final Font font = new Font("Tahoma", Font.BOLD, 14);
    private final AllCurveData allCurveData = AllCurveData.getInstance();

    @Override
    public void paintComponent(Graphics g4) {
        Graphics2D gr = (Graphics2D) g4;

        gr.setColor(Color.red);
        gr.drawPolyline(allCurveData.getXMassive(),
                allCurveData.getCurveMassive().get(3),
                allCurveData.getCurvePointCurveMassive());
        gr.setFont(font);
        gr.drawString(String.valueOf(dataFromComPort.getVoltageScrolling()[3]), 104, 10);
    }
}
