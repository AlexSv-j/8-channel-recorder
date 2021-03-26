package com.svichkar.Drawing;

import com.svichkar.DataFromComPort;

import javax.swing.*;
import java.awt.*;

class CurveChannel3 extends JPanel {

    private final DataFromComPort dataFromComPort = DataFromComPort.getInstance();
    private final Font font = new Font("Tahoma", Font.BOLD, 14);
    private final AllCurveData allCurveData = AllCurveData.getInstance();

    @Override
    public void paintComponent(Graphics g3) {
        Graphics2D gr = (Graphics2D) g3;

        gr.setColor(Color.white);
        gr.drawPolyline(allCurveData.getXMassive(),
                allCurveData.getCurveMassive().get(2),
                allCurveData.getCurvePointCurveMassive());
        gr.setFont(font);
        gr.drawString(String.valueOf(dataFromComPort.getVoltageScrolling()[2]), 72, 10);
    }
}
