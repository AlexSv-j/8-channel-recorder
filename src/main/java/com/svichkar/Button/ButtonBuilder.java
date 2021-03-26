package com.svichkar.Button;

import javax.swing.*;
import java.awt.*;

public class ButtonBuilder {

    public JToggleButton getButton(String text, boolean selected, ButtonGroup buttonGroup) {
        JToggleButton jToggleButton = new JToggleButton(text, selected);
        jToggleButton.setFocusPainted(false);
        buttonGroup.add(jToggleButton);
        return jToggleButton;
    }

    public JToggleButton getButton(String text, boolean selected, Color color) {
        JToggleButton jToggleButton = new JToggleButton(text, selected);
        jToggleButton.setFont(new Font("Arial", Font.BOLD, 14));
        jToggleButton.setFocusPainted(false);
        jToggleButton.setForeground(color);
        return jToggleButton;
    }
}
