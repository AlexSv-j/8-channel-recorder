package com.svichkar;

import com.svichkar.ComPort.CreateComPort;
import com.svichkar.ComPort.WaitComPortNumberListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConnectionInfo {
    private final CreateComPort createComPort;

    public ConnectionInfo(CreateComPort createComPort) {
        this.createComPort = createComPort;
    }

    JPanel connection() {
        JPanel connectionArea = new JPanel();
        connectionArea.setBorder(new TitledBorder("Connection:"));
        connectionArea.setLayout(new GridLayout(1, 1));
        connectionArea.setLocation(680, 460);
        connectionArea.setSize(new Dimension(100, 100));
        connectionArea.setVisible(true);
        infoConnectionArea(connectionArea);
        return connectionArea;
    }

    void infoConnectionArea(JPanel connectionArea) {
        JLabel infoArea = new JLabel();
        infoArea.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));
        infoArea.setLayout(new GridLayout(2, 1));
        infoArea.setVisible(true);

        JLabel connectString = new JLabel("Connect to:", SwingConstants.CENTER);
        connectString.setVisible(true);
        infoArea.add(connectString);

        JLabel portNumber = new JLabel("connecting ...", SwingConstants.CENTER);
        portNumber.setVisible(true);
        infoArea.add(portNumber);

        connectionArea.add(infoArea);

        ExecutorService waitComPort = Executors.newCachedThreadPool();
        waitComPort.submit(new WaitComPortNumberListener(createComPort, portNumber, waitComPort));
    }
}
