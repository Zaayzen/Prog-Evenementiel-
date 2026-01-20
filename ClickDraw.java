import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ClickDraw {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            var f = new JFrame("ClickDraw");
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            var p = new ClickDrawPanel();
            f.setContentPane(p);
            f.pack();

            f.setVisible(true);
        });
    }
}

class ClickDrawPanel extends JPanel {

    private static final int cellSize = 100;

    private int px;
    private int py;

    ClickDrawPanel() {
        super(null);
        setPreferredSize(new Dimension(cellSize*5, cellSize*5));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setPos(e.getX(), e.getY());
            }
        });
    }

    void setPos(int x, int y) {
        this.px = (x / cellSize) * cellSize;
        this.py = (y / cellSize) * cellSize;
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.clearRect(0,0,this.getWidth(),this.getWidth());

        g2.setStroke(new BasicStroke(5));
        g2.setColor(Color.BLACK);
        for (int y = cellSize/2; y < this.getHeight(); y += cellSize) {
            for (int x = cellSize/2; x < this.getWidth(); x += cellSize) {
                g2.drawLine(x,y,x,y);
            }            
        }

        g2.setStroke(new BasicStroke(10));
        g2.setColor(Color.RED);
        g2.drawOval(px,py,cellSize,cellSize);
        g2.setColor(Color.BLUE);
        g2.drawLine(px,py,px+cellSize,py+cellSize);
        g2.drawLine(px,py+cellSize,px+cellSize,py);
    }
}