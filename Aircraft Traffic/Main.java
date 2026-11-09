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
            

        CargoPlane cargoPlane = new CargoPlane(
            "CP001",
            "Qantas Freight",
            "Boarding",
            900.0,
            18000.0,
            18000.0,
            14000.0,
            700
        );

        Route cargoRoute = airport.findRandomDepartureRoute(
            airport.getGateNode1(),
            airport.getRunwayExit()
        );

        if (cargoRoute != null) {
            cargoPlane.setRoute(cargoRoute);
        }
        airport.addPlane(cargoPlane);

        CargoPlane cargoPlane2 = new CargoPlane(
            "CP002",
            "Boeing 747 Swisse",
            "Boarding",
            700.0,
            20000.0,
            40000.0,
            25000.0,
            500
        );

        Route cargoRoute2 = airport.findRandomDepartureRoute(
            airport.getGateNode2(),
            airport.getRunwayExit()
        );

        if (cargoRoute2 != null) {
            cargoPlane2.setRoute(cargoRoute2);
        }
        airport.addPlane(cargoPlane2);

        CargoPlane cargoPlane3 = new CargoPlane(
            "CP003",
            "Boeing 535 Ward",
            "Boarding",
            800.0,
            18000.0,
            15000.0,
            20000.0,
            400
        );

        Route cargoRoute3 = airport.findRandomDepartureRoute(
            airport.getGateNode5(),
            airport.getRunwayExit()
        );

        if (cargoRoute3 != null) {
            cargoPlane3.setRoute(cargoRoute3);
        }
        airport.addPlane(cargoPlane3);
        
        CommercialPlane passengerPlane = new CommercialPlane(
            "CM001",
            "Boeing 737",
            800.0,
            "Boarding",
            18000.0,
            100,
            100,
            50
        );
        Route passengerRoute = airport.findRandomDepartureRoute(
            airport.getGateNode3(),
            airport.getRunwayExit()
        );

        if (passengerRoute != null) {
            passengerPlane.setRoute(passengerRoute);
        }
        airport.addPlane(passengerPlane);

        CommercialPlane passengerPlane2 = new CommercialPlane(
            "CM002",
            "Boeing 757",
            800.0,
            "Boarding",
            20000.0,
            150,
            150,
            60
        );
        Route passengerRoute2 = airport.findRandomDepartureRoute(
            airport.getGateNode4(),
            airport.getRunwayExit()
        );

        if (passengerRoute2 != null) {
            passengerPlane2.setRoute(passengerRoute2);
        }
        airport.addPlane(passengerPlane2);

        });
    }
}