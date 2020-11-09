package t1102;

/**
 * @Author: zlatanlong
 * @Date: 2020/11/8 22:41
 */
public class Circle2D {
    private double radius;
    private double x;
    private double y;

    public Circle2D() {
        x = 0;
        y = 0;
        radius = 1;
    }

    public Circle2D(double radius, double x, double y) {
        this.radius = radius;
        this.x = x;
        this.y = y;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double getDiameter() {
        return 2 * radius;
    }

    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    public boolean contains(double x, double y) {
        return Math.abs(x - this.x) < radius && Math.abs(y - this.y) < radius;
    }

    public boolean contains(Circle2D circle2D) {
        return Math.abs(x - circle2D.x) * Math.abs(y - circle2D.y) + circle2D.radius < radius;
    }

    public boolean overlaps(Circle2D circle2D) {
        return Math.abs(x - circle2D.x) * Math.abs(y - circle2D.y)
                + circle2D.radius > radius
                && Math.abs(x - circle2D.x) * Math.abs(y - circle2D.y)
                + circle2D.radius < radius + circle2D.radius;
    }
}
