package com.svichkar.Drawing;

import com.svichkar.DataFromComPort;

import javax.swing.*;
import java.awt.*;

class CurveChannel2 extends JPanel {

    private final DataFromComPort dataFromComPort = DataFromComPort.getInstance();
    private final Font font = new Font("Tahoma", Font.BOLD, 14);
    private final AllCurveData allCurveData = AllCurveData.getInstance();

    @Override
    public void paintComponent(Graphics g2) {
        Graphics2D gr = (Graphics2D) g2;

        gr.setColor(Color.green);
        gr.drawPolyline(allCurveData.getXMassive(),
                allCurveData.getCurveMassive().get(1),
                allCurveData.getCurvePointCurveMassive());
        gr.setFont(font);
        gr.drawString(String.valueOf(dataFromComPort.getVoltageScrolling()[1]), 40, 10);
    }
}
