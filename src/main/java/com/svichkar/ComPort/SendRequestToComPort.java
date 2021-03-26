package com.svichkar.ComPort;

import jssc.SerialPort;
import jssc.SerialPortException;

import java.util.concurrent.Callable;

public class SendRequestToComPort extends CreateComPort implements Callable<Boolean> {
    private final SerialPort localSerialPort;
    private final CreateComPort createComPort;


    SendRequestToComPort(CreateComPort createComPort, SerialPort localSerialPort) {
        this.localSerialPort = localSerialPort;
        this.createComPort = createComPort;
    }

    @Override
    public Boolean call() {
        try {
            localSerialPort.writeString("ATI1");
            Thread.sleep(200);
            if (createComPort.comPortIsFound) {
                return true;
            }
        } catch (SerialPortException e) {
            System.out.println("Write to port " + localSerialPort.getPortName() + " with exception. " + e.getLocalizedMessage());
        } catch (InterruptedException e) {
            System.out.println(localSerialPort.getPortName() + " Interrupted exception " + Thread.currentThread().getName() + e.getLocalizedMessage());
        }
        return false;
    }
}
