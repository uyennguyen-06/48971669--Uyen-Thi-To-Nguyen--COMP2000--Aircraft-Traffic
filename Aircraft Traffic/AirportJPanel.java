import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;

public class AirportJPanel extends JPanel {
    private int[] planeX = {30, 210, 400, 590, 770}; 
    private int[] planeY = {550, 550, 550, 550, 550};
    private Point[] route = {
        new Point(100, 350),
        new Point(100, 250),
        new Point(550, 250),
        new Point(550, 150),
        new Point(550, 80)
    };
    private Airport airport;
    private int movingPlane = 0;

    

    public AirportJPanel(Airport airport){
        setSize(new Dimension(900, 900));
        setBackground(Color.decode("#5aa161"));
        this.airport = airport;

        Timer timer = new Timer(30, event -> {
        for (Plane plane : airport.getPlanes()) {
            plane.updateMovement(
                airport.getRunway(),
                airport.getRunwayEntrance(),
                airport.getRunwayExit()
            );
        }

        airport.getPlanes().removeIf(plane -> plane.isFinished());

        repaint();
    });

        timer.start();
    }

    @Override 
    public void paintComponent(Graphics graphics){
        System.out.println("Number of planes: " + airport.getPlanes().size());
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
        drawNodes(g);
        drawFlightBoard(g);
        
        for (Plane plane : airport.getPlanes()) {
            Vector2 position = plane.getPosition();

            if (position != null) {
                int x = position.getXPos();
                int y = position.getYPos();

                drawPlane(g, x, y);
                drawPlaneInformation(g, plane, x, y);
            }
        }
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

    private void drawPlane(Graphics2D g, int x, int y) {
        int diameter = 25;

        // Fill the circle
        g.setColor(Color.WHITE);
        g.fillOval(x, y, diameter, diameter);

        // Draw the outline
        g.setColor(Color.BLACK);
        g.drawOval(x, y, diameter, diameter);
    }

    private void drawNodes(Graphics2D g) {
        int diameter = 10;

        for (Node node : airport.getNodes()) {
            Vector2 position = node.getPosition();

            int x = position.getXPos();
            int y = position.getYPos();

            g.setColor(Color.PINK);
            g.fillOval(
                x - diameter / 2,
                y - diameter / 2,
                diameter,
                diameter
            );

            g.setColor(Color.BLACK);
            //g.drawString(node.getNodeID(), x + 8, y - 8);
        }
    }

    private void drawPlaneInformation(
        Graphics2D g,
        Plane plane,
        int planeX,
        int planeY) {

        int boardX = planeX + 20;
        int boardY = planeY - 45;

        int boardWidth = 190;
        int boardHeight = 105;

        // Transparent white background
        g.setColor(new Color(255, 255, 255, 210));

        // Board outline
        g.setColor(Color.BLACK);

        String planeType;

        if (plane instanceof CargoPlane) {
            planeType = "Cargo Plane";
        } else if (plane instanceof CommercialPlane) {
            planeType = "Commercial Plane";
        } else {
            planeType = "Plane";
        }

        int textX = boardX + 8;
        int textY = boardY + 16;
        int lineSpacing = 15;

        g.drawString(
            planeType + ": " + plane.getPlaneID(),
            textX,
            textY
        );

        g.drawString(
            "Model: " + plane.getModel(),
            textX,
            textY + lineSpacing
        );

        g.drawString(
            "Speed: " + plane.getPlaneSpeed(),
            textX,
            textY + lineSpacing * 2
        );

        g.drawString(
            "Status: " + plane.getStatus(),
            textX,
            textY + lineSpacing * 3
        );

        g.drawString(
            "Current target: "
                + plane.getCurrentTargetName(),
            textX,
            textY + lineSpacing * 4
        );

        g.drawString(
            "Final destination: "
                + plane.getFinalDestinationName(),
            textX,
            textY + lineSpacing * 5
        );
    }

    private void drawFlightBoard(Graphics2D g) {
        int boardWidth = 370;
        int rowHeight = 20;

        List<Plane> boardPlanes = airport.getPlanes()
        .stream()
        .filter(plane -> !plane.isFinished())
        .sorted(
            (plane1, plane2) ->
                plane1.getPlaneID().compareTo(
                    plane2.getPlaneID()
                )
        )
        .toList();

        int numberOfPlanes = boardPlanes.size();

        int boardHeight = Math.max(
            80,
            55 + numberOfPlanes * rowHeight
        );

        // Fixed at top-right corner
        int boardX = getWidth() - boardWidth - 15;
        int boardY = 15;

        // Dark transparent background
        g.setColor(new Color(10, 15, 20, 220));
        g.fillRect(
            boardX,
            boardY,
            boardWidth,
            boardHeight
        );

        // Green outline
        g.setColor(Color.GREEN);
        g.drawRect(
            boardX,
            boardY,
            boardWidth,
            boardHeight
        );

        g.setFont(new Font(
            Font.MONOSPACED,
            Font.BOLD,
            13
        ));

        // Board title
        g.setColor(Color.WHITE);
        g.drawString(
            "FLIGHT BOARD",
            boardX + 10,
            boardY + 18
        );

        // Column locations
        int flightX = boardX + 10;
        int typeX = boardX + 85;
        int statusX = boardX + 200;
        int gateX = boardX + 300;

        // Column headings
        g.setColor(Color.YELLOW);

        g.drawString("FLIGHT", flightX, boardY + 38);
        g.drawString("TYPE", typeX, boardY + 38);
        g.drawString("STATUS", statusX, boardY + 38);
        g.drawString("GATE", gateX, boardY + 38);

        int rowY = boardY + 58;

        for (Plane plane : boardPlanes) {
            String planeType;

            if (plane instanceof CargoPlane) {
                planeType = "CARGO";
            } else if (plane instanceof CommercialPlane) {
                planeType = "COMMERCIAL";
            } else {
                planeType = "PLANE";
            }

            String location = plane.getCurrentNodeName();

            String gate = "-";

            if (location.startsWith("Gate")) {
                gate = location;
            }

            g.setColor(Color.GREEN);

            g.drawString(
                plane.getPlaneID(),
                flightX,
                rowY
            );

            g.drawString(
                planeType,
                typeX,
                rowY
            );

            g.drawString(
                plane.getStatus(),
                statusX,
                rowY
            );

            g.drawString(
                gate,
                gateX,
                rowY
            );

            rowY += rowHeight;
        }
    }

}