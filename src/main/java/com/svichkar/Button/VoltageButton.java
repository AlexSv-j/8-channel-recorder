package com.svichkar.Button;

import com.svichkar.ComPort.CreateComPort;
import com.svichkar.Drawing.Drawing;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class VoltageButton {
    private final CreateComPort createComPort;
    private final Drawing drawing = Drawing.getInstance();
    private final ButtonBuilder buttonBuilder = new ButtonBuilder();

    public VoltageButton(CreateComPort createComPort) {
        this.createComPort = createComPort;
    }

    public JPanel switchVoltageButtonArea() {
        JPanel switchVoltageButton = new JPanel();
        switchVoltageButton.setLayout(new GridLayout(1, 8, 20, 5));
        switchVoltageButton.setBorder(new TitledBorder("Voltage range"));
        switchVoltageButton.setLocation(3, 360);
        switchVoltageButton.setSize(new Dimension(675, 200));
        switchVoltageButton.setVisible(true);

        /*
         add 8 voltage limit group
         1 group - 1 channel
         */
        showCH1(switchVoltageButton);
        showCH2(switchVoltageButton);
        showCH3(switchVoltageButton);
        showCH4(switchVoltageButton);
        showCH5(switchVoltageButton);
        showCH6(switchVoltageButton);
        showCH7(switchVoltageButton);
        showCH8(switchVoltageButton);
        return switchVoltageButton;
    }

    //first channel button
    private void showCH1(JPanel switchButton) {

        ButtonGroup groupChannel1 = new ButtonGroup();
        JPanel channel1JPanel = new JPanel();
        channel1JPanel.setLayout(new GridLayout(5, 1, 0, 10));

        JToggleButton channel1button = buttonBuilder.getButton("CH1", true, Color.yellow);
        channel1button.addItemListener((event) -> {
                    drawing.changeVisibleChannel1();
                    drawing.repaintDrawingArea();
                }
        );
        channel1JPanel.add(channel1button);

        JToggleButton buttonCH1_15V = buttonBuilder.getButton("15", true, groupChannel1);
        buttonCH1_15V.addActionListener((event) ->
                new TimeVoltageButtonsListener(createComPort).voltageListener("D", 0, 15));
        channel1JPanel.add(buttonCH1_15V);

        JToggleButton buttonCH1_8V = buttonBuilder.getButton("8", false, groupChannel1);
        buttonCH1_8V.addActionListener((event) ->
                new TimeVoltageButtonsListener(createComPort).voltageListener("E", 0, 8));
        channel1JPanel.add(buttonCH1_8V);

        JToggleButton buttonCH1_3V = buttonBuilder.getButton("3", false, groupChannel1);
        buttonCH1_3V.addActionListener((event) ->
                new TimeVoltageButtonsListener(createComPort).voltageListener("F", 0, 3));
        channel1JPanel.add(buttonCH1_3V);

        switchButton.add(channel1JPanel);
    }

    //second channel button
    public void showCH2(JPanel switchButton) {

        ButtonGroup groupChannel2 = new ButtonGroup();

        JPanel channel2JPanel = new JPanel();
        channel2JPanel.setLayout(new GridLayout(5, 1, 0, 10));

        JToggleButton channel2button = buttonBuilder.getButton("CH2", true, Color.green);
        channel2button.addItemListener((event) -> {
                    drawing.changeVisibleChannel2();
                    drawing.repaintDrawingArea();
                }
        );
        channel2JPanel.add(channel2button);

        JToggleButton buttonCH2_15V = buttonBuilder.getButton("15", true, groupChannel2);
        buttonCH2_15V.addActionListener((event) ->
                new TimeVoltageButtonsListener(createComPort).voltageListener("G", 1, 15));
        channel2JPanel.add(buttonCH2_15V);

        JToggleButton buttonCH2_8V = buttonBuilder.getButton("8", false, groupChannel2);
        buttonCH2_8V.addActionListener((event) ->
                new TimeVoltageButtonsListener(createComPort).voltageListener("H", 1, 8));
        channel2JPanel.add(buttonCH2_8V);

        JToggleButton buttonCH2_3V = buttonBuilder.getButton("3", false, groupChannel2);
        buttonCH2_3V.addActionListener((event) ->
                new TimeVoltageButtonsListener(createComPort).voltageListener("I", 1, 3));
        channel2JPanel.add(buttonCH2_3V);

        switchButton.add(channel2JPanel);
    }

    //third channel button
    public void showCH3(JPanel switchButton) {
        ButtonGroup groupChannel3 = new ButtonGroup();

        JPanel channel3JPanel = new JPanel();
        channel3JPanel.setLayout(new GridLayout(5, 1, 0, 10));

        JToggleButton channel3button = buttonBuilder.getButton("CH3", true, Color.white);
        channel3button.addItemListener((event) -> {
                    drawing.changeVisibleChannel3();
                    drawing.repaintDrawingArea();
                }
        );
        channel3JPanel.add(channel3button);

        JToggleButton buttonCH3_15V = buttonBuilder.getButton("15", true, groupChannel3);
        buttonCH3_15V.addActionListener((event) ->
                new TimeVoltageButtonsListener(createComPort).voltageListener("J", 2, 15));
        channel3JPanel.add(buttonCH3_15V);

        JToggleButton buttonCH3_8V = buttonBuilder.getButton("8", false, groupChannel3);
        buttonCH3_8V.addActionListener((event) ->
                new TimeVoltageButtonsListener(createComPort).voltageListener("K", 2, 8));
        channel3JPanel.add(buttonCH3_8V);

        JToggleButton buttonCH3_3V = buttonBuilder.getButton("3", false, groupChannel3);
        buttonCH3_3V.addActionListener((event) ->
                new TimeVoltageButtonsListener(createComPort).voltageListener("L", 2, 3));
        channel3JPanel.add(buttonCH3_3V);

        switchButton.add(channel3JPanel);
    }

    //fourth channel button
    public void showCH4(JPanel switchButton) {
        ButtonGroup groupChannel4 = new ButtonGroup();

        JPanel channel4JPanel = new JPanel();
        channel4JPanel.setLayout(new GridLayout(5, 1, 0, 10));

        JToggleButton channel4button = buttonBuilder.getButton("CH4", true, Color.red);
        channel4button.addItemListener((event) -> {
                    drawing.changeVisibleChannel4();
                    drawing.repaintDrawingArea();
                }
        );
        channel4JPanel.add(channel4button);

        JToggleButton buttonCH4_30V = buttonBuilder.getButton("30", true, groupChannel4);
        buttonCH4_30V.addActionListener((event) ->
                new TimeVoltageButtonsListener(createComPort).voltageListener("M", 3, 30));
        channel4JPanel.add(buttonCH4_30V);

        JToggleButton buttonCH4_15V = buttonBuilder.getButton("15", false, groupChannel4);
        buttonCH4_15V.addActionListener((event) ->
                new TimeVoltageButtonsListener(createComPort).voltageListener("N", 3, 15));
        channel4JPanel.add(buttonCH4_15V);

        JToggleButton buttonCH4_8V = buttonBuilder.getButton("8", false, groupChannel4);
        buttonCH4_8V.addActionListener((event) ->
                new TimeVoltageButtonsListener(createComPort).voltageListener("O", 3, 8));
        channel4JPanel.add(buttonCH4_8V);

        JToggleButton buttonCH4_3V = buttonBuilder.getButton("3", false, groupChannel4);
        buttonCH4_3V.addActionListener((event) ->
                new TimeVoltageButtonsListener(createComPort).voltageListener("P", 3, 3));
        channel4JPanel.add(buttonCH4_3V);

        switchButton.add(channel4JPanel);
    }

    //fifth channel button
    public void showCH5(JPanel switchButton) {
        ButtonGroup groupChannel5 = new ButtonGroup();

        JPanel channel5JPanel = new JPanel();
        channel5JPanel.setLayout(new GridLayout(5, 1, 0, 10));

        JToggleButton channel5button = buttonBuilder.getButton("CH5", true, Color.gray);
        channel5button.addItemListener((event) -> {
                    drawing.changeVisibleChannel5();
                    drawing.repaintDrawingArea();
                }
        );

        channel5JPanel.add(channel5button);

        JToggleButton buttonCH5_30V = buttonBuilder.getButton("30", true, groupChannel5);
        buttonCH5_30V.addActionListener((event) ->
                new TimeVoltageButtonsListener(createComPort).voltageListener("Q", 4, 30));
        channel5JPanel.add(buttonCH5_30V);

        JToggleButton buttonCH5_15V = buttonBuilder.getButton("15", false, groupChannel5);
        buttonCH5_15V.addActionListener((event) ->
                new TimeVoltageButtonsListener(createComPort).voltageListener("R", 4, 15));
        channel5JPanel.add(buttonCH5_15V);

        JToggleButton buttonCH5_8V = buttonBuilder.getButton("8", false, groupChannel5);
        buttonCH5_8V.addActionListener((event) ->
                new TimeVoltageButtonsListener(createComPort).voltageListener("S", 4, 8));
        channel5JPanel.add(buttonCH5_8V);

        JToggleButton buttonCH5_3V = buttonBuilder.getButton("3", false, groupChannel5);
        buttonCH5_3V.addActionListener((event) ->
                new TimeVoltageButtonsListener(createComPort).voltageListener("T", 4, 3));
        channel5JPanel.add(buttonCH5_3V);

        switchButton.add(channel5JPanel);
    }

    //sixth channel button
    public void showCH6(JPanel switchButton) {
        ButtonGroup groupChannel6 = new ButtonGroup();

        JPanel channel6JPanel = new JPanel();
        channel6JPanel.setLayout(new GridLayout(5, 1, 0, 10));

        JToggleButton channel6button = buttonBuilder.getButton("CH6", true, Color.orange);
        channel6button.addItemListener((event) -> {
                    drawing.changeVisibleChannel6();
                    drawing.repaintDrawingArea();
                }
        );
        channel6JPanel.add(channel6button);

        JToggleButton buttonCH6_30V = buttonBuilder.getButton("30", true, groupChannel6);
        buttonCH6_30V.addActionListener((event) ->
                new TimeVoltageButtonsListener(createComPort).voltageListener("U", 5, 30));
        channel6JPanel.add(buttonCH6_30V);

        JToggleButton buttonCH6_15V = buttonBuilder.getButton("15", false, groupChannel6);
        buttonCH6_15V.addActionListener((event) ->
                new TimeVoltageButtonsListener(createComPort).voltageListener("V", 5, 15));
        channel6JPanel.add(buttonCH6_15V);

        JToggleButton buttonCH6_8V = buttonBuilder.getButton("8", false, groupChannel6);
        buttonCH6_8V.addActionListener((event) ->
                new TimeVoltageButtonsListener(createComPort).voltageListener("W", 5, 8));
        channel6JPanel.add(buttonCH6_8V);

        JToggleButton buttonCH6_3V = buttonBuilder.getButton("3", false, groupChannel6);
        buttonCH6_3V.addActionListener((event) ->
                new TimeVoltageButtonsListener(createComPort).voltageListener("X", 5, 3));
        channel6JPanel.add(buttonCH6_3V);

        switchButton.add(channel6JPanel);
    }

    //seventh channel button
    public void showCH7(JPanel switchButton) {
        ButtonGroup groupChannel7 = new ButtonGroup();

        JPanel channel7JPanel = new JPanel();
        channel7JPanel.setLayout(new GridLayout(5, 1, 0, 10));

        JToggleButton channel7button = buttonBuilder.getButton("CH7", true, Color.magenta);
        channel7button.addItemListener((event) -> {
                    drawing.changeVisibleChannel7();
                    drawing.repaintDrawingArea();
                }
        );
        channel7JPanel.add(channel7button);

        JToggleButton buttonCH7_30V = buttonBuilder.getButton("30", true, groupChannel7);
        buttonCH7_30V.addActionListener((event) ->
                new TimeVoltageButtonsListener(createComPort).voltageListener("Y", 6, 30));
        channel7JPanel.add(buttonCH7_30V);

        JToggleButton buttonCH7_15V = buttonBuilder.getButton("15", false, groupChannel7);
        buttonCH7_15V.addActionListener((event) ->
                new TimeVoltageButtonsListener(createComPort).voltageListener("Z", 6, 15));
        channel7JPanel.add(buttonCH7_15V);

        JToggleButton buttonCH7_8V = buttonBuilder.getButton("8", false, groupChannel7);
        buttonCH7_8V.addActionListener((event) ->
                new TimeVoltageButtonsListener(createComPort).voltageListener("a", 6, 8));
        channel7JPanel.add(buttonCH7_8V);

        JToggleButton buttonCH7_3V = buttonBuilder.getButton("3", false, groupChannel7);
        buttonCH7_3V.addActionListener((event) ->
                new TimeVoltageButtonsListener(createComPort).voltageListener("b", 6, 3));
        channel7JPanel.add(buttonCH7_3V);

        switchButton.add(channel7JPanel);
    }

    //eighth channel button
    public void showCH8(JPanel switchButton) {
        ButtonGroup groupChannel8 = new ButtonGroup();

        JPanel channel8JPanel = new JPanel();
        channel8JPanel.setLayout(new GridLayout(5, 1, 0, 10));

        JToggleButton channel8button = buttonBuilder.getButton("CH8", true, Color.cyan);
        channel8button.addItemListener((event) -> {
                    drawing.changeVisibleChannel8();
                    drawing.repaintDrawingArea();
                }
        );
        channel8JPanel.add(channel8button);

        JToggleButton buttonCH8_30V = buttonBuilder.getButton("30", true, groupChannel8);
        buttonCH8_30V.addActionListener((event) ->
                new TimeVoltageButtonsListener(createComPort).voltageListener("c", 7, 30));
        channel8JPanel.add(buttonCH8_30V);

        JToggleButton buttonCH8_15V = buttonBuilder.getButton("15", false, groupChannel8);
        buttonCH8_15V.addActionListener((event) ->
                new TimeVoltageButtonsListener(createComPort).voltageListener("d", 7, 15));
        channel8JPanel.add(buttonCH8_15V);

        JToggleButton buttonCH8_8V = buttonBuilder.getButton("8", false, groupChannel8);
        buttonCH8_8V.addActionListener((event) ->
                new TimeVoltageButtonsListener(createComPort).voltageListener("e", 7, 8));
        channel8JPanel.add(buttonCH8_8V);

        JToggleButton buttonCH8_3V = buttonBuilder.getButton("3", false, groupChannel8);
        buttonCH8_3V.addActionListener((event) ->
                new TimeVoltageButtonsListener(createComPort).voltageListener("f", 7, 3));
        channel8JPanel.add(buttonCH8_3V);

        switchButton.add(channel8JPanel);
    }
}
