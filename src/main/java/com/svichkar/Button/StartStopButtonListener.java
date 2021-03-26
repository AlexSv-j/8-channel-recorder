package com.svichkar.Button;

import com.svichkar.ComPort.CreateComPort;
import com.svichkar.DataFromComPort;
import com.svichkar.Drawing.AllCurveData;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartStopButtonListener extends StartStopButton implements ActionListener {
    private final DataFromComPort dataFromComPort = DataFromComPort.getInstance();
    private final StartStopButton startStopButton;
    private final AllCurveData allCurveData = AllCurveData.getInstance();

    public StartStopButtonListener(CreateComPort createComPort, TimeButton timeButton, StartStopButton startStopButton) {
        super(createComPort, timeButton);
        this.startStopButton = startStopButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (startStopButton.getJToggleButton().get(0).isSelected() &&
                !startStopButton.getJToggleButton().get(1).isSelected()) {//run button
            cleanAllData();
            timeButton.getJToggleButton().forEach(s -> s.setEnabled(!s.isEnabled()));
            startStopButton.getJToggleButton().get(1).setEnabled(!startStopButton.getJToggleButton().get(1).isEnabled());
            createComPort.addCommandToQueue("B"); // start command
        } else if (!startStopButton.getJToggleButton().get(0).isSelected() &&
                startStopButton.getJToggleButton().get(1).isSelected()) { // single button
            cleanAllData();
            timeButton.getJToggleButton().forEach(s -> s.setEnabled(!s.isEnabled()));
            startStopButton.getJToggleButton().get(0).setEnabled(!startStopButton.getJToggleButton().get(0).isEnabled());
            createComPort.addCommandToQueue("C"); // start command
        } else if (!startStopButton.getJToggleButton().get(0).isSelected() &&
                !startStopButton.getJToggleButton().get(1).isSelected()) { //stop command
            timeButton.getJToggleButton().forEach(s -> s.setEnabled(!s.isEnabled()));
            startStopButton.getJToggleButton().forEach(s -> s.setEnabled(true));
            createComPort.addCommandToQueue("y"); //stop command
        }

    }

    void cleanAllData() {
        allCurveData.makeEmptyCurveListXPosition();
        dataFromComPort.clearMainListData();
    }
}
