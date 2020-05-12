package factoryPattern;

public class FactoryPatternDemo {
	public static void main(String[] args) {
	VehicleFactory vehicleFactory = new VehicleFactory();

    Vehicle vehicle1 = vehicleFactory.getVehicle("VAN");
    vehicle1.drive();
    
    Vehicle vehicle2 = vehicleFactory.getVehicle("CAR");
    vehicle2.drive();
    
    Vehicle vehicle3 = vehicleFactory.getVehicle("BIKE");
    vehicle3.drive();
	}
}
