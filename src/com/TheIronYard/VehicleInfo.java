package com.TheIronYard;

public class VehicleInfo {
    private int vin;
    private double milesTraveled;
    private double consumptionGas;
    private double lastOilChange;
    private double engineSize;

    public int getVin() {
        return vin;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    public double getMilesTraveled() {
        return milesTraveled;
    }

    public void setMilesTraveled(double odometerMiles) {
        this.milesTraveled = odometerMiles;
    }

    public double getConsumptionGas() {
        return consumptionGas;
    }

    public void setConsumptionGas(double consumptionGas) {
        this.consumptionGas = consumptionGas;
    }

    public double getLastOilChange() {
        return lastOilChange;
    }

    public void setLastOilChange(double odometerReading) {
        this.lastOilChange = odometerReading;
    }

    public double getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(double engineSize) {
        this.engineSize = engineSize;
    }
}


//    Telematics data is the information about a vehicle that is sent on an interval (e.g. every x minutes or hours
//    or miles) or when certain events happen (e.g. warning light).
//
//        Write a VehicleInfo class that has the following information:
//
//        DONE - VIN (Vehicle Identification Number) - int
//        DONE - odometer (miles traveled) - double
//        DONE - consumption (gallons of gas consumed) - double
//        DONE - odometer reading for last oil change - double
//        DONE - engine size in liters (e.g. 2.0, 4.5) - double
//        DONE - The VehicleInfo class should be a JavaBean which means it has an empty constructor and get/set methods
