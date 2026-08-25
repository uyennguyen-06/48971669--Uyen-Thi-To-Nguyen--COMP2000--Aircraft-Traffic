public abstract class AirportPath{
    private String pathID;
    private double lengthInMeters;
    
    public AirportPath (String pathID, double lengthInMeters){
        this. pathID = pathID;
        this.lengthInMeters = lengthInMeters;
    }

    public String getPathID(){
        return pathID;
    }

    public abstract boolean canAcceptPlane(Plane currentPlane);
}