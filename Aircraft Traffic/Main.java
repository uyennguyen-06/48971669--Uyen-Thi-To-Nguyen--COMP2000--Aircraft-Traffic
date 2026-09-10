import javax.swing.*;


public class Main{
    public static void main (String[] args){
        System.out.println("Program started!");
       
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Airport Simulation");

            frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
            );

            Airport airport = new Airport();
            AirportJPanel panel = new AirportJPanel(airport);
            frame.add(panel);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setVisible(true);
            

            CargoPlane cargoPlane = new CargoPlane("CP001", "Qantas Freight",  "Boarding", 900.0, 18000.0, 18000.0, 14000.0, 700);
            cargoPlane.setRoute(airport.getRouteGate1());
            airport.addPlane(cargoPlane);

            /*CargoPlane passengerPlane = new CargoPlane("CP002", "Qantas Freight",  "Boarding", 900.0, 18000.0, 18000.0, 14000.0, 700);
            passengerPlane.setRoute(airport.getRouteGate2());
            airport.addPlane(passengerPlane);*/
        });
    }
}