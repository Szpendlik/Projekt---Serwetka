import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Turtle extends JComponent {
    private int x, y;
    private int angle;
    private Color color;
    private boolean penDown;
    private ArrayList<Line> lines;

    private class Line {
        int x1, y1, x2, y2;
        Color color;

        public Line(int x1, int y1, int x2, int y2, Color color) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.color = color;
        }
    }

    public Turtle(int x, int y) {
        this.x = x;
        this.y = y;
        angle = 90;
        color = Color.BLACK;
        penDown = true;
        lines = new ArrayList<Line>();
    }

    public void forward(int distance) {
        int newX = x + (int) (distance * Math.cos(Math.toRadians(angle)));
        int newY = y + (int) (distance * Math.sin(Math.toRadians(angle)));
        if (penDown) {
            lines.add(new Line(x, y, newX, newY, color));
        }
        x = newX;
        y = newY;
    }

    public void left(int degrees) {
        angle = (angle + degrees) % 360;
    }

    public void right(int degrees) {
        angle = (angle - degrees + 360) % 360;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void goTo(int x, int y) {
        if (penDown) {
            lines.add(new Line(this.x, this.y, x, y, color));
        }
        this.x = x;
        this.y = y;
    }

    public void penUp() {
        penDown = false;
    }

    public void penDown() {
        penDown = true;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Line line : lines) {
            g.setColor(line.color);
            g.drawLine(line.x1, line.y1, line.x2, line.y2);
        }
    }
}