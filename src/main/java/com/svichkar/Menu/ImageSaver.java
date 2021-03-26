package com.svichkar.Menu;

import com.svichkar.Drawing.Drawing;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageSaver implements ActionListener {

    private static String imageDirectory = null;
    private final Drawing drawing;

    public ImageSaver() {
        this.drawing = Drawing.getInstance();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JFileChooser fileName = new JFileChooser();
        fileName.setAcceptAllFileFilterUsed(true); // filter is on
        fileName.setMultiSelectionEnabled(false); // possibility to choose some files

        if (imageDirectory != null) {
            fileName.setCurrentDirectory(new File(imageDirectory));
        }
        //add bmp filter
        FileNameExtensionFilter fileExtension = new FileNameExtensionFilter("Bitmap file (.bmp)", "bmp");
        fileName.addChoosableFileFilter(fileExtension);
        fileName.setFileFilter(fileExtension);

        if (fileName.showDialog(null, "Save") == JFileChooser.APPROVE_OPTION) {
            String filePath = fileName.getSelectedFile().getPath();
            imageDirectory = fileName.getCurrentDirectory().getAbsolutePath(); //save path
            getSaveSnapShot(getJPanelFromDrawing(), filePath);
        }
    }

    JPanel getJPanelFromDrawing() {
        return drawing.getDrawingArea();
    }

    public static void getSaveSnapShot(Component component, String filePath) {
        BufferedImage image = new BufferedImage(component.getWidth(), component.getHeight(), BufferedImage.TYPE_INT_RGB);
        component.paint(image.getGraphics());
        try {
            ImageIO.write(image, "bmp", new File(filePath + ".bmp"));
        } catch (IOException exception) {
            System.out.println("Error write image " + exception.getLocalizedMessage());
        }
    }
}
