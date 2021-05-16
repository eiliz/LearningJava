package ch05;

import org.w3c.dom.css.Rect;

import java.awt.*;

/**
 * Apple
 * <p>
 * This class sums up everything about the apples used by the physicists.
 */
public class Apple implements GamePiece {
    float mass;
    float diameter = 1.0f;
    int x, y;
    int size;

    public static final int SMALL = 0;
    public static final int MEDIUM = 1;
    public static final int LARGE = 2;

    // Some helpers for optimizing the draw() method that can be called many, many times
    int centerX, centerY;
    int scaledLength;

    // Boundary helper for optimizing collision detection with physicists and trees
    Rectangle boundingBox;

    // If we bumped into something, keep a reference to that thing around for cleanup and removal
    GamePiece collided;

    public Apple() {
        this(MEDIUM);
    }

    public Apple(int size) {
        setSize(size);
    }

    /**
     * Sets the size (and dependent properties) of the apple based on the
     * supplied value which must be one of the size constants.
     *
     * @param size one of SMALL, MEDIUM, or LARGE, other values are bounded
     *             to SMALL or LARGE
     */
    void setSize(int size) {
        if (size < SMALL) {
            size = SMALL;
        }

        if (size > LARGE) {
            size = LARGE;
        }

        this.size = size;

        switch (size) {
            case SMALL -> {
                diameter = 0.9f;
                mass = 0.5f;
            }
            case MEDIUM -> {
                diameter = 1.0f;
                mass = 1.0f;
            }
            case LARGE -> {
                diameter = 1.1f;
                mass = 1.8f;
            }
        }

        // fillOval() used below draws an oval bounded by a box, so figure out the length of the sides.
        // Since we want a circle, we simply make our box a square so we only need one length.
        scaledLength = (int) (diameter * Field.APPLE_SIZE_IN_PIXELS + 0.5);
        boundingBox = new Rectangle(x, y, scaledLength, scaledLength);
    }

    public double getDiameter() {
        return diameter;
    }

    @Override
    public void setPosition(int x, int y) {
        // Our position is based on the center of the apple, but it will be drawn from the
        // upper left corner, so figure out the distance of that gap
        int offset = (int) (diameter * Field.APPLE_SIZE_IN_PIXELS / 2);

        this.centerX = x;
        this.centerY = y;
        this.x = x - offset;
        this.y = y - offset;
        boundingBox = new Rectangle(this.x, this.y, scaledLength, scaledLength);
    }

    @Override
    public int getPositionX() {
        return centerX;
    }

    @Override
    public int getPositionY() {
        return centerY;
    }

    @Override
    public Rectangle getBoundingBox() {
        return boundingBox;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(x, y, scaledLength, scaledLength);
    }

    /**
     * Determine whether or not this apple is touching another piece.
     */
    public boolean isTouching(GamePiece otherPiece) {
        double xDiff = centerX - otherPiece.getPositionX();
        double yDiff = centerY - otherPiece.getPositionY();
        double distance = Math.sqrt(xDiff * xDiff + yDiff * yDiff);

        // For now, we can only really collide with other apples.
        // Just cheat a little and assume the other piece is in fact
        // an apple, and an apple with the same diameter. We'll fix
        // this as we fill out the other game pieces in later chapters.
        return distance < diameter;
    }

    public static String[] getAppleSizes() {
        // Return names for our constants
        // The index of the name should match the value of the constant
        return new String[]{"SMALL", "MEDIUM", "LARGE"};
    }

    public void printDetails() {
        System.out.println(" mass: " + mass);
        String[] niceNames = getAppleSizes();

        if (diameter < 5.0f) {
            System.out.println(niceNames[SMALL]);
        } else if (diameter < 10.0f) {
            System.out.println(niceNames[MEDIUM]);
        } else {
            System.out.println(niceNames[LARGE]);
        }

        System.out.println("  position: (" + x + ", " + y + ")");
    }
}