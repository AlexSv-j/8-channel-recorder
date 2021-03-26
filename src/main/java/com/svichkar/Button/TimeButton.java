package com.svichkar.Button;

import com.svichkar.ComPort.CreateComPort;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TimeButton {

    private final CreateComPort createComPort;
    //  private final Drawing drawing = Drawing.getInstance();
    private final List<JToggleButton> timeButtons = new ArrayList<>();
    private final ButtonBuilder buttonBuilder = new ButtonBuilder();

    public TimeButton(CreateComPort createComPort) {
        this.createComPort = createComPort;
    }

    // time limits switching area
    public JPanel switchTimeButtonArea() {

        JPanel switchTimeButton = new JPanel();
        switchTimeButton.setLayout(new GridLayout(1, 1));
        switchTimeButton.setBorder(new TitledBorder("Sec/Div"));
        switchTimeButton.setSize(new Dimension(100, 250));
        switchTimeButton.setLocation(680, 20);
        switchTimeButton(switchTimeButton);
        return switchTimeButton;
    }

    // time limits switching buttons
    public void switchTimeButton(JPanel TimeDiv) {

        ButtonGroup timeGroup = new ButtonGroup();

        JPanel switchTime = new JPanel();
        switchTime.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 5));
        switchTime.setLayout(new GridLayout(4, 1, 10, 15));

        JToggleButton time05SDiv = buttonBuilder.getButton("0.5", true, timeGroup);
        timeButtons.add(time05SDiv);
        time05SDiv.addActionListener((event) -> new TimeVoltageButtonsListener(createComPort).timeListener("g", "0.5", 1));
        switchTime.add(time05SDiv);

        JToggleButton time1SDiv = buttonBuilder.getButton("1", false, timeGroup);
        timeButtons.add(time1SDiv);
        time1SDiv.addActionListener((event) -> new TimeVoltageButtonsListener(createComPort).timeListener("h", "1", 2));
        switchTime.add(time1SDiv);

        JToggleButton time2SDiv = buttonBuilder.getButton("2", false, timeGroup);
        timeButtons.add(time2SDiv);
        time2SDiv.addActionListener((event) -> new TimeVoltageButtonsListener(createComPort).timeListener("i", "2", 4));
        switchTime.add(time2SDiv);

        JToggleButton time5SDiv = buttonBuilder.getButton("5", false, timeGroup);
        timeButtons.add(time5SDiv);
        time5SDiv.addActionListener((event) -> new TimeVoltageButtonsListener(createComPort).timeListener("j", "5", 10));
        switchTime.add(time5SDiv);

        TimeDiv.add(switchTime);
    }

    public List<JToggleButton> getJToggleButton() {
        return timeButtons;
    }
}
