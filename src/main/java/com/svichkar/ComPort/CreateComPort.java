package com.svichkar.ComPort;

import com.svichkar.Button.StartStopButton;
import jssc.SerialPort;
import jssc.SerialPortException;
import jssc.SerialPortList;

import java.util.Optional;
import java.util.Queue;
import java.util.concurrent.*;

import static jssc.SerialPort.*;

public class CreateComPort implements Runnable, IComPortListener {

    protected volatile boolean comPortIsFound = false;
    private final Queue<String> writeSymbol = new ConcurrentLinkedQueue<>();
    private SerialPort serialPort;
    private Thread thread;
    private IWaitComPortNumberListener waitComPortNumberListener;
    private ExecutorService executorSendKeyToPort;
    private StartStopButton startStopButton;

    @Override
    public void run() {
        thread = Thread.currentThread();
        String[] comPortsMassive = findAllCopPort();
        if (comPortsMassive.length != 0) {
            sendKeyToComPorts(comPortsMassive);
            if (serialPort != null) {
                writeSickle();
            }
        }
    }

    private String[] findAllCopPort() {
        return SerialPortList.getPortNames();

    }

    private void sendKeyToComPorts(String[] portNames) {
        executorSendKeyToPort = Executors.newSingleThreadExecutor();
        for (String portName : portNames) {
            findComPort(portName).ifPresent(port -> serialPort = port);
            if (comPortIsFound) {
                break;
            }
        }
        executorSendKeyToPort.shutdownNow();
        waitComPortNumberListener.allPortsIsChecked();
    }

    private Optional<SerialPort> findComPort(String portName) {
        SerialPort localSerialPort = new SerialPort(portName);
        try {
            if (localSerialPort.openPort() && setPortParams(localSerialPort)) {
                localSerialPort.purgePort(SerialPort.PURGE_RXCLEAR | PURGE_TXCLEAR);
                localSerialPort.setEventsMask(MASK_RXCHAR);
                localSerialPort.addEventListener(new ComPortListener(localSerialPort, this, startStopButton));

                sendRequest(localSerialPort);
                if (comPortIsFound) {
                    waitComPortNumberListener.comPortIsFound();
                    return Optional.of(localSerialPort);
                }
            }

            if (localSerialPort.isOpened()) {
                localSerialPort.removeEventListener();
                localSerialPort.closePort();
            }
        } catch (SerialPortException e) {
            System.out.println("Port " + portName + " opened with exception. " + e.getLocalizedMessage());
        }
        return Optional.empty();
    }

    private void sendRequest(SerialPort localSerialPort) {
        Future<Boolean> booleanFuture =
                executorSendKeyToPort.submit((Callable<Boolean>) new SendRequestToComPort(this, localSerialPort));
        try {
            booleanFuture.get(300, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException " + e.getLocalizedMessage());
        } catch (ExecutionException e) {
            System.out.println("Something wrong: " + e.getLocalizedMessage());
        } catch (TimeoutException e) {
            System.out.println("Exception timeout wait of writing to port " + e.getLocalizedMessage());
            booleanFuture.cancel(true);
        }
    }

    private boolean setPortParams(SerialPort serialPort) throws SerialPortException {
        return serialPort.setParams(BAUDRATE_57600, DATABITS_8, STOPBITS_1, PARITY_NONE);
    }

    public void changeSickleInputFlag() {
        comPortIsFound = true;
    }

    public void addCommandToQueue(String command) {
        if (comPortIsFound) {
            writeSymbol.offer(command);
        }
    }

    private void writeSickle() {
        while (!thread.isInterrupted()) {
            while (!writeSymbol.isEmpty()) {
                writeCommandToComPort(writeSymbol.poll());
            }
        }
    }

    private void writeCommandToComPort(String command) {
        try {
            if (command != null) {
                serialPort.writeString(command);
            }
        } catch (
                SerialPortException e) {
            System.out.println("Command to port " + serialPort.getPortName() + " write with exception. " + e.getLocalizedMessage());
        }
    }

    public String getComPortName() {
        return serialPort.getPortName();
    }

    public void setWaitComPortNumber(IWaitComPortNumberListener waitComPortNumberListener) {
        this.waitComPortNumberListener = waitComPortNumberListener;
    }

    public void setStartStopButton(StartStopButton startStopButton) {
        this.startStopButton = startStopButton;
    }
}
