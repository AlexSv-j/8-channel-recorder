package com.svichkar.Button;

import com.svichkar.ComPort.CreateComPort;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class StartStopButton implements UnselectStarStopButton {

    final CreateComPort createComPort;
    final TimeButton timeButton;
    private final List<JToggleButton> startStopButtons = new ArrayList<>();
    private final ButtonBuilder buttonBuilder = new ButtonBuilder();

    public StartStopButton(CreateComPort createComPort, TimeButton timeButton) {
        this.createComPort = createComPort;
        this.timeButton = timeButton;
    }

    public JPanel turnOnOff() {

        JPanel buttonOnOff = new JPanel();
        buttonOnOff.setBorder(new TitledBorder("Run/Stop"));
        buttonOnOff.setLayout(new GridLayout(1, 1, 10, 20));
        buttonOnOff.setSize(new Dimension(100, 190));
        buttonOnOff.setLocation(680, 270);
        turnOnOffButton(buttonOnOff);
        createComPort.setStartStopButton(this);
        return buttonOnOff;
    }

    void turnOnOffButton(JPanel buttonOnOff) {

        JPanel buttonArea = new JPanel();
        buttonArea.setBorder(BorderFactory.createEmptyBorder(25, 5, 25, 5));
        buttonArea.setLayout(new GridLayout(2, 1, 10, 25));

        JToggleButton runButton = buttonBuilder.getButton("Run", false, Color.black);
        startStopButtons.add(runButton);
        runButton.addActionListener(new StartStopButtonListener(createComPort, timeButton, this));
        buttonArea.add(runButton);

        JToggleButton singleButton = buttonBuilder.getButton("Single", false, Color.black);
        startStopButtons.add(singleButton);
        singleButton.addActionListener(new StartStopButtonListener(createComPort, timeButton, this));
        buttonArea.add(singleButton);
        buttonOnOff.add(buttonArea);
    }

    public List<JToggleButton> getJToggleButton() {
        return startStopButtons;
    }

    public void unselectStartStopButton() {
        timeButton.getJToggleButton().forEach(s -> s.setEnabled(!s.isEnabled()));
        startStopButtons.forEach(s -> {
            s.setEnabled(true);
            s.setSelected(false);
        });
    }
}
