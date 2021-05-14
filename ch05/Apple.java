package ch05;

public class Apple {
    static final float EARTH_ACCEL = 9.8f;
    float mass;
    float diameter = 1.0f;
    int x, y;

    public void printDetails() {
        System.out.println("  mass: " + mass);
        System.out.println("  diameter: " + diameter);
        System.out.println("  position: (" + x + ", " + y + ")");
    }

    boolean isTouching(Apple other) {
        double distanceX = x - other.x;
        double distanceY = y - other.y;
        double distance =
                Math.sqrt(distanceX * distanceX + distanceY * distanceY);

        return distance < (diameter / 2 + other.diameter / 2);
    }
}