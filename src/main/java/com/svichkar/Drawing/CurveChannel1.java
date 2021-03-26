package com.svichkar.Drawing;

import com.svichkar.DataFromComPort;

import javax.swing.*;
import java.awt.*;

public class CurveChannel1 extends JPanel {

    private final DataFromComPort dataFromComPort = DataFromComPort.getInstance();
    private final Font font = new Font("Tahoma", Font.BOLD, 14);
    private final AllCurveData allCurveData = AllCurveData.getInstance();

    @Override
    public void paintComponent(Graphics g1) {
        Graphics2D gr = (Graphics2D) g1;

        gr.setColor(Color.yellow);
        gr.drawPolyline(allCurveData.getXMassive(),
                allCurveData.getCurveMassive().get(0),
                allCurveData.getCurvePointCurveMassive());
        gr.setFont(font);
        gr.drawString(String.valueOf(dataFromComPort.getVoltageScrolling()[0]), 8, 10);
    }
}
