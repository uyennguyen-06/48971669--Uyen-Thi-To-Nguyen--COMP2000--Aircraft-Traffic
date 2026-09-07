import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class AirportJPanel extends JPanel {
    public AirportJPanel(){
        setSize(new Dimension(900, 900));
        setBackground(Color.decode("#af96d6"));
    }

    @Override 
    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);

        Graphics2D g = (Graphics2D) graphics;

        g.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON
        );

        drawRunways(g);
        drawTaxiways(g);
        drawGates(g);
        drawTerminals(g);
        drawAirportPath(g);
    }

    private void drawRunways(Graphics2D g){
        g.setColor(Color.BLACK);
        g.drawRect(20,20,800,100);
        g.drawString("Runway", 400, 50);

        g.setStroke(new BasicStroke(
            1, BasicStroke.CAP_BUTT, 
            BasicStroke.JOIN_BEVEL, 
            0, new float[]{9}, 
            0
        ));

        g.drawLine(20, 70, 820, 70);
        g.setStroke(new BasicStroke(1));

        /*g.drawRect(20,120, 60, 50);
        g.drawRect(260,120, 60, 50);
        g.drawRect(530,120, 60, 50);
        g.drawRect(760,120, 60, 50);*/
    }

    private void drawTaxiways(Graphics2D g){
        g.setColor(Color.BLACK);
        g.drawRect(20, 170, 800, 100);
        g.drawString("Taxiway", 400, 200);
    }

    private void drawGates(Graphics2D g){
        g.setColor(Color.BLACK);
        g.drawRect(20, 600, 60, 30);
        g.drawRect(200, 600, 60, 30);
        g.drawRect(390, 600, 60, 30);
        g.drawRect(580, 600, 60, 30);
        g.drawRect(760, 600, 60, 30);
    }

    private void drawTerminals(Graphics2D g){
        g.setColor(Color.BLACK);
        g.drawRect(20, 640, 800, 30);
        g.drawString("Terminal", 400, 660);
    }

    private void drawAirportPath(Graphics2D g){
        g.setColor(Color.BLACK);
        g.drawRect(20,120, 60, 50);
        g.drawRect(260,120, 60, 50);
        g.drawRect(530,120, 60, 50);
        g.drawRect(760,120, 60, 50);

        g.drawRect(20, 270, 60, 80);
        g.drawRect(400, 270, 60, 80);
        g.drawRect(760, 270, 60, 80);

    }

}