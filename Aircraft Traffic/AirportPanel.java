import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class AirportPanel extends JPanel {
    public AirportPanel(){
        setSize(new Dimension(800, 600));
        setBackground(Color.lightGray);
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
    }

    private void drawRunways(Graphics2D g){
        g.setColor(Color.BLACK);
        g.drawRect(20,20,700,120);
    }

    private void drawTaxiways(Graphics2D g){
        
    }

    private void drawGates(Graphics2D g){
        
    }

    private void drawTerminals(Graphics2D g){
        
    }

}