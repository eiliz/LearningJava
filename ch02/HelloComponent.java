package ch02;

import javax.swing.*;
import java.awt.*;

public class HelloComponent extends JComponent {
    String theMessage;
    int messageX = 12, messageY = 95;

    public HelloComponent(String message) {
        theMessage = message;
    }

    public void paintComponent(Graphics g) {
        g.drawString(theMessage, messageX, messageY);
    }
}