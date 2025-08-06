import java.util.Scanner;
import java.time.Year;
class Vehicle{
String brand;
String model;
int year;
double basePrice;

Vehicle(String brand,String model,int year,double basePrice){
this.brand=brand;
this.model=model;
this.year=year;
this.basePrice=basePrice;}

int getAge(){
int currentYear = Year.now().getValue();
return currentYear-year;
}

double calculateResaleValue(){
 return basePrice*Math.pow(0.85,getAge());
}

 void displayInfo(){
 System.out.println("Brand:"+brand);
 System.out.println("Model:"+model);
 System.out.println("Year:"+year);
 System.out.println("BasePrice:INR"+basePrice);
}
}

class Car extends Vehicle{
 int numberOfDoors;

 Car(String brand,String model,int year,double basePrice,int numberOfDoors){
  super(brand,model,year,basePrice);
  this.numberOfDoors=numberOfDoors;
}


double calculateInsurance() {
        return 5000 + 1000 * numberOfDoors;
    }

    double calculateMaintenanceCost() {
        return 3000 + 500 * numberOfDoors;
    }

    
    void displayInfo() {
        super.displayInfo();
        System.out.println("Number of Doors: " + numberOfDoors);
        System.out.println("Insurance: INR" + calculateInsurance());
        System.out.println("Maintenance Cost: INR" + calculateMaintenanceCost());
        System.out.println("Resale Value: INR" + calculateResaleValue());
        System.out.println("\n");
    }
}


class Motorcycle extends Vehicle {
    boolean hasSidecar;

    Motorcycle(String brand, String model, int year, double basePrice, boolean hasSidecar) {
        super(brand, model, year, basePrice);
        this.hasSidecar = hasSidecar;
    }

    double calculateInsurance() {
        return hasSidecar ? 2500 + 1500 : 2500;
    }

double calculateMaintenanceCost() {
        return hasSidecar ? 2000 + 1000 : 2000;
    }

    
    void displayInfo() {
        super.displayInfo();
        System.out.println("Has Sidecar: " + (hasSidecar ? "Yes" : "No"));
        System.out.println("Insurance: INR" + calculateInsurance());
        System.out.println("Maintenance Cost: INR" + calculateMaintenanceCost());
        System.out.println("Resale Value: INR" + calculateResaleValue());
        System.out.println("\n");
    }
}


 class  VehicleManagementSystem {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Innova", 2020, 1500000, 4);
        Motorcycle bike = new Motorcycle("Royal Enfield", "Classic 350", 2019, 180000, true);

        System.out.println("....Car Info ....");
        car.displayInfo();

        System.out.println(".... Motorcycle Info ....");
        bike.displayInfo();
        }
}

