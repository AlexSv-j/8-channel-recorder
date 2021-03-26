package com.svichkar.ComPort;

import com.svichkar.Button.StartStopButton;
import com.svichkar.DataFromComPortListener;
import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

import java.util.Arrays;

public class ComPortListener implements SerialPortEventListener {

    private final SerialPort serialPort;
    private final IComPortListener iComPortListener;
    private boolean connectFlag = false;
    private int[] keyOK = {40, 42, 42, 42, 42, 111, 107, 41}; // 00000ok0
    private final int countReadByte = 8;
    private int[] comPortData;
    private DataFromComPortListener dataProcessing;
    private StartStopButton startStopButton;

    public ComPortListener(SerialPort serialPort, CreateComPort iComPortListener, StartStopButton startStopButton) {
        this.serialPort = serialPort;
        this.iComPortListener = iComPortListener;
        this.startStopButton = startStopButton;
    }

    @Override
    public void serialEvent(SerialPortEvent event) {
        if (event.isRXCHAR() && event.getEventValue() >= 8) {
            comPortData = readFromPort();
            if (connectFlag && comPortData != null) {
                dataProcessing.addByteDateToQue(comPortData);
            } else if (!connectFlag && comPortData != null) {
                if (Arrays.equals(comPortData, keyOK)) {
                    iComPortListener.changeSickleInputFlag();
                    connectFlag = true;
                    dataProcessing = new DataFromComPortListener(startStopButton);
                    new Thread(dataProcessing).start();
                }
            }
        }
    }

    private int[] readFromPort() {
        try {
            return serialPort.readIntArray(countReadByte);
        } catch (SerialPortException e) {
            System.out.println("Read string data with exception " + e.getLocalizedMessage());
        }
        return null;
    }
}
