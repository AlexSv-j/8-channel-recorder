package com.svichkar;

import com.svichkar.Button.StartStopButton;
import com.svichkar.Button.UnselectStarStopButton;
import com.svichkar.Drawing.AllCurveData;
import com.svichkar.Drawing.Drawing;

import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class DataFromComPortListener implements Runnable {
    private final int[] takeData = {116, 97, 107, 101, 68, 97, 116, 97};
    private final int[] the = {42, 42, 42, 42, 84, 72, 69, 42};//THE
    private final int[] begin = {42, 42, 66, 69, 71, 73, 78, 42};//BEGIN
    private final int[] end = {42, 42, 42, 42, 69, 78, 68, 42};//END
    private int[] allDate = new int[8];
    private final DataFromComPort dataFromComPort = DataFromComPort.getInstance();
    private final AllCurveData allCurveData = AllCurveData.getInstance();
    private boolean startDataFlag = false;
    private final Drawing drawing = Drawing.getInstance();
    private final Queue<int[]> byteFromComPort = new ConcurrentLinkedQueue<>();
    private final AtomicInteger pointNumber = new AtomicInteger(0); // a variable to select which point to display on the graph
    private final UnselectStarStopButton unselectStarStopButton;

    public DataFromComPortListener(StartStopButton startStopButton) {
        this.unselectStarStopButton = startStopButton;
    }

    public void addByteDateToQue(int[] dataToQue) {
        byteFromComPort.offer(dataToQue);
    }

    public void run() {

        while (!Thread.currentThread().isInterrupted()) {
            if (!byteFromComPort.isEmpty()) {
                allDate = byteFromComPort.poll();
                if (Arrays.equals(allDate, takeData)) { //data is coming after this
                    startDataFlag = true;
                } else if (Arrays.equals(allDate, the)) { // finish of one lap voltage measurement
                    drawing.repaintDrawingArea();
                } else if (startDataFlag) {
                    startDataFlag = false;
                    int[] byteObject = new int[allDate.length];
                    for (int i = 0; i < allDate.length; i++) {
                        byteObject[i] = allDate[i];
                    }
                    dataFromComPort.addData(byteObject); //added the data to a common array
                    addByteDataToCurveListDependingTimeScrolling(byteObject); //add data to curve arrays depending on time sweep
                } else if (Arrays.equals(allDate, begin)) { //begin of the first lap
                    allCurveData.makeEmptyCurveListXPosition();
                    drawing.repaintDrawingArea();
                    pointNumber.set(0);
                } else if (Arrays.equals(allDate, end)) {//end of the lap
                    unselectStarStopButton.unselectStartStopButton();
                }
                Arrays.fill(allDate, (byte) 0);
            }
        }
    }

    //the data comes in at a frequency of 64 hertz
    void addByteDataToCurveListDependingTimeScrolling(int[] byteObject) {
        /*
         * select which point is added to the curve chart array
         * value 1,2,4,10
         */
        if (pointNumber.incrementAndGet() % dataFromComPort.getTimeScrollingPointCount() == 0) {
            allCurveData.addByteToCurveMassive(byteObject);
            allCurveData.incrementPointCurveMassive(); // increase the position for writing to the curve array
        }
    }
}
