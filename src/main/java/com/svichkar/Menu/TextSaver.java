package com.svichkar.Menu;

import com.svichkar.DataFromComPort;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;

public class TextSaver implements ActionListener {

    private final DataFromComPort dataFromComPort;
    private int linePosition;

    TextSaver() {
        dataFromComPort = DataFromComPort.getInstance();
    }

    private static String dataDirectory;

    public void actionPerformed(ActionEvent ae) {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setAcceptAllFileFilterUsed(true);
        fileChooser.setMultiSelectionEnabled(false);
        if (dataDirectory != null) {
            fileChooser.setCurrentDirectory(new File(dataDirectory));
        }
        FileNameExtensionFilter fileExtension = new FileNameExtensionFilter("Txt file (*.txt)", "txt");
        fileChooser.addChoosableFileFilter(fileExtension);
        fileChooser.setFileFilter(fileExtension);
        if (fileChooser.showDialog(null, "Save") == JFileChooser.APPROVE_OPTION) {
            String filePath = fileChooser.getSelectedFile().getPath();
            dataDirectory = fileChooser.getCurrentDirectory().getAbsolutePath(); //save previous path
            writeDataFile(filePath);
        }
    }

    private void writeDataFile(String filePath) {
        // current date
        Date now = new Date();
        DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        String Date = formatter.format(now);

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath + ".txt"))) {

            bufferedWriter.write(Date + "\r\n" + "\r\n");

            bufferedWriter.write("TIME STEP: ");
            bufferedWriter.write("64 = " + 1 + "s\r\n");

            bufferedWriter.write("VOLTAGE RANGE:\r\n");
            for (int i = 0; i < 8; i++) {
                bufferedWriter.write("CH" + (i + 1) + "= " + dataFromComPort.getVoltageScrolling()[i] + "V\r\n");
            }

            bufferedWriter.write("\r\n" + "   N     CH1     CH2     CH3     CH4     CH5     CH6     CH7     CH8\r\n" + "\r\n");
            for (int[] lineBytes : dataFromComPort.getMainData()) {
                StringBuilder stringBuilder = new StringBuilder();
                Formatter format = new Formatter(stringBuilder);
                format.format("%4d", linePosition + 1);

                for (int j = 0; j < 8; j++) {
                    format.format("%8.1f", (lineBytes[j] * dataFromComPort.getVoltageScrolling()[j] / 255.0));
                }
                bufferedWriter.write(stringBuilder.toString() + "\r\n");
                linePosition++;
            }

        } catch (IOException e) {
            System.out.println("File not created " + e.getLocalizedMessage());
        }
    }
}
