import javax.swing.*;
import java.awt.*;

public class Human extends JPanel {
    private static final int HUMAN_COUNT = 5;
    private static final int HUMAN_WIDTH = 50;
    private static final int HUMAN_HEIGHT = 100;

    private static final Color[] HAT_COLORS = {
            Color.RED, Color.BLUE, Color.GREEN, Color.ORANGE, Color.MAGENTA
    };

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int baseX = 50;
        int baseY = 50;
        int offsetX = 80;
        int offsetY = 20;

        for (int i = 0; i < HUMAN_COUNT; i++) {
            drawHuman(g2d, baseX + i * offsetX, baseY + i * offsetY, HAT_COLORS[i]);
        }
    }

    private void drawHuman(Graphics2D g, int x, int y, Color hatColor) {
        g.setColor(Color.PINK);
        g.fillOval(x, y, HUMAN_WIDTH, HUMAN_WIDTH);

        g.setColor(Color.BLUE);
        g.fillRect(x + HUMAN_WIDTH / 4, y + HUMAN_WIDTH, HUMAN_WIDTH / 2, HUMAN_HEIGHT);

        g.setColor(Color.BLUE);
        g.drawLine(x + HUMAN_WIDTH / 4, y + HUMAN_WIDTH + 20, x, y + HUMAN_WIDTH + 50);
        g.drawLine(x + 3 * HUMAN_WIDTH / 4, y + HUMAN_WIDTH + 20, x + HUMAN_WIDTH, y + HUMAN_WIDTH + 50);

        g.setColor(Color.BLUE);
        g.drawLine(x + HUMAN_WIDTH / 4, y + HUMAN_WIDTH + HUMAN_HEIGHT, x + HUMAN_WIDTH / 4, y + HUMAN_WIDTH + HUMAN_HEIGHT + 30);
        g.drawLine(x + 3 * HUMAN_WIDTH / 4, y + HUMAN_WIDTH + HUMAN_HEIGHT, x + 3 * HUMAN_WIDTH / 4, y + HUMAN_WIDTH + HUMAN_HEIGHT + 30);

        g.setColor(hatColor);
        g.translate(x + HUMAN_WIDTH / 2, y);
        g.rotate(Math.toRadians(-20));
        g.fillArc(-HUMAN_WIDTH / 4 - 15, -HUMAN_WIDTH / 2 + 25, HUMAN_WIDTH / 2 + 15, HUMAN_WIDTH / 2, 0, 180);
        g.rotate(Math.toRadians(20));
        g.translate(-(x + HUMAN_WIDTH / 2), -y);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Human Drawing");
        Human drawing = new Human();
        frame.add(drawing);
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
