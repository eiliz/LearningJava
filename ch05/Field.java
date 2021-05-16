package ch05;

import javax.swing.*;
import java.awt.*;

public class Field extends JComponent {
    public static final float GRAVITY = 9.8f; // feet/s/s
    public static final int STEP = 40; // duration of an animation frame in ms
    public static final int APPLE_SIZE_IN_PIXELS = 30;
    public static final int TREE_WIDTH_IN_PIXELS = 60;
    public static final int TREE_HEIGHT_IN_PIXELS = 2 * TREE_WIDTH_IN_PIXELS;
    public static final int PHYSICIST_SIZE_IN_PIXELS = 75;
    public static final int MAX_TREES = 12;

    Color fieldColor = Color.GRAY;

    Apple a1 = new Apple();
    Apple a2 = new Apple();
    Tree tree = new Tree();
    Physicist physicist;

    public void setupApples() {
        a1.diameter = 3.0f;
        a1.mass = 5.0f;
        a1.x = 20;
        a1.y = 40;

        a2.diameter = 8.0f;
        a2.mass = 10.0f;
        a2.x = 25;
        a2.y = 40;
    }

    public void setupTree() {
        tree.setPosition(500, 200);
    }

    public void setPlayer(Physicist p) {
        physicist = p;
    }

    public void paintComponent(Graphics g) {
        g.setColor(fieldColor);
        g.fillRect(0, 0, getWidth(), getHeight());
        tree.draw(g);
        physicist.draw(g);
        a1.draw(g);
        a2.draw(g);
    }

    public void detectCollisions() {
        if (a1.isTouching(a2)) {
            System.out.println("Collision detected!");
        } else {
            System.out.println("Apples are not touching.");
        }
    }
}
