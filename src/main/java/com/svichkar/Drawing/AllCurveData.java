package com.svichkar.Drawing;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AllCurveData extends JPanel {
    private static volatile AllCurveData instance;
    private final AtomicInteger curvePoint = new AtomicInteger(0);
    private final List<int[]> curveList = new ArrayList<>();
    private final int[] horizontalLineX = new int[640];
    private final int[] Curve1 = new int[640];
    private final int[] Curve2 = new int[640];
    private final int[] Curve3 = new int[640];
    private final int[] Curve4 = new int[640];
    private final int[] Curve5 = new int[640];
    private final int[] Curve6 = new int[640];
    private final int[] Curve7 = new int[640];
    private final int[] Curve8 = new int[640];

    private AllCurveData() {
        addCurveToListCurve();
    }

    public static AllCurveData getInstance() {
        AllCurveData localInstance = instance;
        if (localInstance == null) {
            synchronized (AllCurveData.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new AllCurveData();
                }
            }
        }
        return localInstance;
    }

    public void addCurveToListCurve() {
        makeLineX();
        curveList.add(Curve1);
        curveList.add(Curve2);
        curveList.add(Curve3);
        curveList.add(Curve4);
        curveList.add(Curve5);
        curveList.add(Curve6);
        curveList.add(Curve7);
        curveList.add(Curve8);
    }

    private void makeLineX() {
        for (int z = 0; z <= 639; z++) {
            horizontalLineX[z] = z;
        }
    }

    public void makeEmptyCurveListXPosition() {
        curvePoint.set(0);
        curveList.forEach(s -> Arrays.fill(s, 0));
    }

    public void addByteToCurveMassive(int[] byteDate) {
        for (int i = 0; i < 8; i++) {
            curveList.get(i)[curvePoint.get()] = 270 - byteDate[i];
        }
    }

    public void incrementPointCurveMassive() {
        curvePoint.incrementAndGet();
    }

    public int getCurvePointCurveMassive() {
        return curvePoint.get();
    }

    public List<int[]> getCurveMassive() {
        return curveList;
    }

    public int[] getXMassive() {
        return horizontalLineX;
    }
}

