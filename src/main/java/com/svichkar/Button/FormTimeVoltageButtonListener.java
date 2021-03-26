package com.svichkar.Button;

import com.svichkar.ComPort.CreateComPort;
import com.svichkar.DataFromComPort;
import com.svichkar.Drawing.Drawing;

public abstract class FormTimeVoltageButtonListener {
    final CreateComPort createComPort;
    final DataFromComPort dataFromComPort = DataFromComPort.getInstance();
    final Drawing drawing = Drawing.getInstance();

    public FormTimeVoltageButtonListener(CreateComPort createComPort) {
        this.createComPort = createComPort;
    }

    abstract void timeListener(String command, String stringTimeLimit, int timeLimit);

    abstract void voltageListener(String command, int position, int voltageLimit);
}
