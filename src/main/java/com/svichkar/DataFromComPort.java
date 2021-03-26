package com.svichkar;

import com.svichkar.Drawing.AllCurveData;

import java.util.LinkedList;
import java.util.List;

public class DataFromComPort {
    private final List<int[]> mainData = new LinkedList<>();
    private static volatile DataFromComPort instance;
    private final int[] voltageScrolling = {15, 15, 15, 30, 30, 30, 30, 30};
    private String timeScrolling = "0.5";
    private int timeScrollingPointCount = 1;

    private DataFromComPort() {
    }

    public static DataFromComPort getInstance() {
        DataFromComPort localInstance = instance;
        if (localInstance == null) {
            synchronized (AllCurveData.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new DataFromComPort();
                }
            }
        }
        return localInstance;
    }

    public int getTimeScrollingPointCount() {
        return timeScrollingPointCount;
    }

    public void setTimeScrollingPointCount(int timeScrollingPointCount) {
        this.timeScrollingPointCount = timeScrollingPointCount;
    }

    public void addData(int[] dataToQueue) {
        mainData.add(dataToQueue);
    }

    public List<int[]> getMainData() {
        return mainData;
    }

    public void setVoltageScrolling(int position, int value) {
        if (position >= 0 & position < 8) {
            voltageScrolling[position] = value;
        }
    }

    public int[] getVoltageScrolling() {
        return voltageScrolling;
    }

    public void setTimeScrolling(String timeScrolling) {
        this.timeScrolling = timeScrolling;
    }

    public String getTimeScrolling() {
        return timeScrolling;
    }

    public void clearMainListData() {
        mainData.clear();
    }
}
