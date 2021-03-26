package com.svichkar.ComPort;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ExecutorService;

public class WaitComPortNumberListener implements Runnable, IWaitComPortNumberListener {
    private volatile boolean allPortsChecked;
    private volatile boolean portIsFound;
    private final CreateComPort createComPort;
    private final JLabel portNumber;
    private final ExecutorService waitComPort;

    public WaitComPortNumberListener(CreateComPort createComPort, JLabel portNumber, ExecutorService waitComPort) {
        this.createComPort = createComPort;
        this.portNumber = portNumber;
        this.waitComPort = waitComPort;
    }

    @Override
    public void run() {

        createComPort.setWaitComPortNumber(this);

        while (!allPortsChecked) Thread.onSpinWait();
        if (portIsFound) {
            portNumber.setText(createComPort.getComPortName());
            portNumber.setForeground(Color.GREEN);
        } else {
            portNumber.setText("Port not found");
            portNumber.setForeground(Color.RED);
        }
        portNumber.repaint();
        waitComPort.shutdownNow();
    }

    @Override
    public void allPortsIsChecked() {
        allPortsChecked = true;
    }

    @Override
    public void comPortIsFound() {
        portIsFound = true;
    }
}
