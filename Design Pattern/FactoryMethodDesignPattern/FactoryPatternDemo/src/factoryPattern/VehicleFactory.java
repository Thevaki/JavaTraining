package factoryPattern;

public class VehicleFactory {
	
	public Vehicle getVehicle(String vehicle){
	      if(vehicle == null){
	         return null;
	      }		
	      if(vehicle.equalsIgnoreCase("CAR")){
	         return new Car();
	         
	      } else if(vehicle.equalsIgnoreCase("VAN")){
	         return new Van();
	         
	      } else if(vehicle.equalsIgnoreCase("BIKE")){
	         return new Bike();
	      }
	      
	      return null;
	   }

}
