package com.TheIronYard;
public class Main {

    public static void main(String[] args) {
        // write your code here
        // Getting telematic input from the user (via command line)
//        Scanner int input = new Scanner(System.in);

        // make a new VehicleInfo object
        VehicleInfo vh = new VehicleInfo();

//        System.out.println("Give me the VIN:");
//        vh.setVin(input);
//        vh.setMilesTraveled(input);
//        vh.setLastOilChange(input);
//        vh.setEngineSize(input);

        /*
        Thanks to the VehicleInfo object, you can "set" the vin field
        Inside the parenthesis, you store the numbers
        WARNING: If you try to add a letter or series of letters, it will be rejected
        WHY: Because the setVin is a type double, not a string
        */

//        vh.setVin(4735566); // Identification numbers for cars
//        vh.setMilesTraveled(1200); // how many miles you have on your car totalled
//        vh.setConsumptionGas(70); // how many gallons is consumed before the next fuel
//        vh.setLastOilChange(7800); // odometer shows X amount of miles since last oil change
//        vh.setEngineSize(3.5);


//        private int vin;
//        private double odometerMiles;
//        private double consumption;
//        private double lastOilChange;
//        private double engineSize;

        /*
        for each field in Vehicle Info,
        use the scanner to read in values, and populate the object
        If there is a dot notation that starts with the "class" name,
        you can identify that it is a class when the first letter is capitalized
        */
        TelematicsService.report(vh);


    }
}

/*
        ****** Assignment ********

        Telematics data is the information about a vehicle that is sent on an interval (e.g. every x minutes or
        hours or miles) or when certain events happen (e.g. warning light).

        DONE - Write a VehicleInfo class that has the following information:

        DONE - VIN (Vehicle Identification Number) - int
        DONE - odometer (miles traveled) - double
        DONE - consumption (gallons of gas consumed) - double
        DONE - odometer reading for last oil change - double
        DONE - engine size in liters (e.g. 2.0, 4.5) - double

        TODO: ???? - The VehicleInfo class should be a JavaBean which means it has an empty constructor and get/set methods for all the variables.

        DONE - Write a TelematicsService class and implement the following method void report(VehicleInfo vehicleInfo)

        TODO: In the main() method of Main get the information for the VehicleInfo from the command line (i.e. Scanner).

        TODO: ???? - Do not write code for error handling the input, just the green path (i.e. type in the correct stuff).

        DONE - Once all the info for a VehicleInfo has been entered and a VehicleInfo object has been created the
        report(vehicleInfo) method in the TelematicsService should be called. This method should:

        DONE - Write the VehicleInfo to a file as json using the VIN as the name of the file and a "json" extension
        (e.g. "234235435.json"). The file will overwrite any existing files for the same VIN.

        DONE - Find all the files that end with ".json" and convert back to a VehicleInfo object.

        ???? - Update a dashboard.html (only show 1 place after the decimal for values that are doubles).
        The dashboard.html should look something like this (with the '#' replaced with a number)


        ****** NOTES ******
    */