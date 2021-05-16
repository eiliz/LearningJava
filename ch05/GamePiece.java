package ch05;

import java.awt.*;

/**
 * Interface to hold common ellements for our apples, trees and physicists:
 *  - methods for positioning on a field
 *  - methods for drawing
 *  - methods for detecting a collision with other game pieces
 */

public interface GamePiece {
    /**
     * Sets the position of the piece on the playing field.
     * (0, 0) is the upper left per standard Java drawing methods.
     *
     * @param x the horizontal position on the field
     * @param y the vertical position on the field
     */
    void setPosition(int x, int y);

    /**
     * Gets the current horizontal position of the piece on the field.
     *
     * @return current X position of the piece
     */
    int getPositionX();

    /**
     * Gets the current vertical position of the piece on the field.
     *
     * @return current Y position of the piece
     */
    int getPositionY();

    /**
     * Gets the bounding box of the piece.
     *
     * @return a Rectangle encompassing the visual elements of the piece
     */
    Rectangle getBoundingBox();

    /**
     * Draws the piece inside the given graphics context.
     * Do not assume anything about the state of the context.
     *
     * @param g a Graphics context
     */
    void draw(Graphics g);

    /**
     * Detect a collision iwht another piece on the field.
     * By definition, a piece does not touch itself - it won't collide with
     * itself.
     *
     * @param otherPiece another GamePiece object
     * @return are the pieces colliding?
     */
    boolean isTouching(GamePiece otherPiece);
}