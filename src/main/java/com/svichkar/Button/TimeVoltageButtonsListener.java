package com.svichkar.Button;

import com.svichkar.ComPort.CreateComPort;

public class TimeVoltageButtonsListener extends FormTimeVoltageButtonListener {

    public TimeVoltageButtonsListener(CreateComPort createComPort) {
        super(createComPort);
    }

    void timeListener(String command, String stringTimeLimit, int timeLimit) {
        createComPort.addCommandToQueue(command);
        dataFromComPort.setTimeScrolling(stringTimeLimit);
        dataFromComPort.setTimeScrollingPointCount(timeLimit);
        drawing.repaintDrawingArea();
    }

    void voltageListener(String command, int position, int voltageLimit) {
        createComPort.addCommandToQueue(command);
        dataFromComPort.setVoltageScrolling(position, voltageLimit);
        drawing.repaintDrawingArea();
    }
}
