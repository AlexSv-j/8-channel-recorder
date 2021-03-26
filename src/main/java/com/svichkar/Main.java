package com.svichkar;

import com.svichkar.Button.StartStopButton;
import com.svichkar.Button.TimeButton;
import com.svichkar.Button.VoltageButton;
import com.svichkar.ComPort.CreateComPort;
import com.svichkar.Drawing.Drawing;
import com.svichkar.Menu.MenuLine;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        new Main().application();
    }

    void application() {

        CreateComPort createComPort = new CreateComPort();

        JFrame mainJFrame = makeJFrame();
        JPanel mainJPanel = makeJPanel();
        mainJFrame.add(mainJPanel);

        Drawing drawing = Drawing.getInstance();
        drawing.setJPanel(mainJPanel);
        TimeButton timeButton = new TimeButton(createComPort);

        mainJPanel.add(new MenuLine().menuBar(mainJFrame));//turn on the top menu
        mainJPanel.add(drawing.addAll());
        mainJPanel.add(new VoltageButton(createComPort).switchVoltageButtonArea());
        mainJPanel.add(timeButton.switchTimeButtonArea());
        mainJPanel.add(new StartStopButton(createComPort, timeButton).turnOnOff());
        mainJPanel.add(new ConnectionInfo(createComPort).connection());
        mainJFrame.setContentPane(mainJPanel);

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(createComPort);
    }

    private JFrame makeJFrame() {
        //find out the screen resolution
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        JFrame mainJFrame = new JFrame("Recorder 8ch");
        mainJFrame.setBounds(screenSize.width / 2 - 400,
                screenSize.height / 2 - 300, 800, 600);
        mainJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainJFrame.setIconImage(new ImageIcon("src/main/java/com/svichkar/icon.png").getImage());
        mainJFrame.setVisible(true);

        return mainJFrame;
    }

    private JPanel makeJPanel() {
        JPanel mainJPanel = new JPanel();
        mainJPanel.setLayout(null);
        mainJPanel.setBounds(0, 0, 800, 600);
        return mainJPanel;
    }
}
