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
            Route cargoRoute = airport.findRoute(
                airport.getGateNode1(),
                airport.getRunwayExit()
            );

            if (cargoRoute != null) {
                cargoPlane.setRoute(cargoRoute);
            }
            airport.addPlane(cargoPlane);

            CargoPlane passengerPlane = new CargoPlane("CP002", "Qantas Freight",  "Boarding", 900.0, 18000.0, 18000.0, 14000.0, 700);
            Route passengerRoute = airport.findRoute(
                airport.getGateNode2(),
                airport.getRunwayExit()
            );

            if (passengerRoute != null) {
                passengerPlane.setRoute(passengerRoute);
            }
            airport.addPlane(passengerPlane);
        });
    }
}