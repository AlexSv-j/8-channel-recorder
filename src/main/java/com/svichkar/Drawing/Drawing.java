package com.svichkar.Drawing;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class Drawing {

    private JPanel drawingArea;
    private JPanel mainJPanel;
    private JPanel curve1;
    private JPanel curve2;
    private JPanel curve3;
    private JPanel curve4;
    private JPanel curve5;
    private JPanel curve6;
    private JPanel curve7;
    private JPanel curve8;
    private static volatile Drawing instance;

    private Drawing() {
    }

    public static Drawing getInstance() {
        Drawing localInstance = instance;
        if (localInstance == null) {
            synchronized (AllCurveData.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Drawing();
                }
            }
        }
        return localInstance;
    }

    public void setJPanel(JPanel mainJPanel) {
        this.mainJPanel = mainJPanel;
    }

    public JPanel addAll() {
        JPanel drawingJPanel = new JPanel();
        drawingJPanel.setBorder(new TitledBorder("Curve"));
        drawingJPanel.setLayout(null);
        drawingJPanel.setBounds(3, 20, 675, 340);
        drawingJPanel.setVisible(true);

        drawingArea = new DrawingArea();
        drawingArea.setLayout(null);
        drawingArea.setBounds(7, 19, 670, 310);
        drawingArea.setVisible(true);

        curveArea();
        drawingJPanel.add(drawingArea);
        return drawingJPanel;
    }

    public void repaintDrawingArea() {
        //drawingArea.updateUI();
        mainJPanel.repaint();
        curve1.repaint();
        curve2.repaint();
        curve3.repaint();
        curve4.repaint();
        curve5.repaint();
        curve6.repaint();
        curve7.repaint();
        curve8.repaint();
    }

    public JPanel getDrawingArea() {
        return drawingArea;
    }

    private void curveArea() {

        curve1 = new CurveChannel1();
        curve1.setLayout(null);
        curve1.setLocation(10, 12);
        curve1.setSize(new Dimension(640, 271));
        curve1.setVisible(true);
        drawingArea.add(curve1);

        curve2 = new CurveChannel2();
        curve2.setLayout(null);
        curve2.setLocation(10, 12);
        curve2.setSize(new Dimension(640, 271));
        curve2.setVisible(true);
        drawingArea.add(curve2);

        curve3 = new CurveChannel3();
        curve3.setLayout(null);
        curve3.setLocation(10, 12);
        curve3.setSize(new Dimension(640, 271));
        curve3.setVisible(true);
        drawingArea.add(curve3);

        curve4 = new CurveChannel4();
        curve4.setLayout(null);
        curve4.setLocation(10, 12);
        curve4.setSize(new Dimension(640, 271));
        curve4.setVisible(true);
        drawingArea.add(curve4);

        curve5 = new CurveChannel5();
        curve5.setLayout(null);
        curve5.setLocation(10, 12);
        curve5.setSize(new Dimension(640, 271));
        curve5.setVisible(true);
        drawingArea.add(curve5);

        curve6 = new CurveChannel6();
        curve6.setLayout(null);
        curve6.setLocation(10, 12);
        curve6.setSize(new Dimension(640, 271));
        curve6.setVisible(true);
        drawingArea.add(curve6);

        curve7 = new CurveChannel7();
        curve7.setLayout(null);
        curve7.setLocation(10, 12);
        curve7.setSize(new Dimension(640, 271));
        curve7.setVisible(true);
        drawingArea.add(curve7);

        curve8 = new CurveChannel8();
        curve8.setLayout(null);
        curve8.setLocation(10, 12);
        curve8.setSize(new Dimension(640, 271));
        curve8.setVisible(true);
        drawingArea.add(curve8);

        JPanel curve9 = new TimeS_Div();
        curve9.setLayout(null);
        curve9.setLocation(10, 12);
        curve9.setSize(new Dimension(640, 271));
        curve9.setVisible(true);
        drawingArea.add(curve9);
    }

    public void changeVisibleChannel1() {
        curve1.setVisible(!curve1.isVisible());
    }

    public void changeVisibleChannel2() {
        curve2.setVisible(!curve2.isVisible());
    }

    public void changeVisibleChannel3() {
        curve3.setVisible(!curve3.isVisible());
    }

    public void changeVisibleChannel4() {
        curve4.setVisible(!curve4.isVisible());
    }

    public void changeVisibleChannel5() {
        curve5.setVisible(!curve5.isVisible());
    }

    public void changeVisibleChannel6() {
        curve6.setVisible(!curve6.isVisible());
    }

    public void changeVisibleChannel7() {
        curve7.setVisible(!curve7.isVisible());
    }

    public void changeVisibleChannel8() {
        curve8.setVisible(!curve8.isVisible());
    }
}
