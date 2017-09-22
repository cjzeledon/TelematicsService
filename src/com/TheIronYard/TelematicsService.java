package com.TheIronYard;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
DONE - Write a TelematicsService class and implement the following method
DONE - void report(VehicleInfo vehicleInfo)
Question: Why choose to label the "void report" method as static and not the class?
    Answer: Since the void report is a child of the TelematicsService which makes it a part of the class, it can be
    labeled as static.
*/
public class TelematicsService {

   static void report(VehicleInfo autoInfo) {
       System.out.println("All good! Thumbs up!");
        /*
        DONE - Write the autoInfo to a file as json
        DONE - using the VIN as the name of the file and a "json" extension
        DONE - (e.g. "234235435.json"). The file will overwrite any existing files for the same VIN.

        Since "File" is a class which has several methods to choose from, we can use it to create a new object. That
        object is assigned to the "f" variable. The "f" variable will get the number vin that is created (VehicleInfo)
        was set in the Main.java. Once it receives that VIN, it will concatenate with .json --- ta da, a file is created!
        */
       File f = new File(autoInfo.getVin() + ".json");
       ArrayList<VehicleInfo> vehicleInfos;
       try {
           // Write to a new file
           // Creates a new object that is assigned to the variable "fw"
           FileWriter fw = new FileWriter(f);

           // Convert our autoInfo to json (convert object to json)
           ObjectMapper mapper = new ObjectMapper();

           // I thought this method wasn't needed because the the file is already set to be a json and could be
           // easily written into? Do we really need to create a string to add information into the file?
           String json = mapper.writeValueAsString(autoInfo);

           // Write the information into the json file
           fw.write(json);
           fw.close();

           /*

           GOAL:
           Build an arrayList of VehicleInfo objects
           we'll get our vehicle info info from all the json files
           in the current directory

           NOTE TO SELF:
           Standard Java arrays are of a fixed length. After arrays are created, they cannot grow or shrink,
           which means that you must know in advance how many elements an array will hold. How the code usually looks:
               class ArrayDemo {
                    public static void main(String[] args) {

                    // declares an array of integers
                        int[] anArray;

                    // allocates memory for 10 integers
                        anArray = new int[10];

                    // initialize first element
                        anArray[0] = 100;
                    // initialize second element
                        anArray[1] = 200;
                    // and so forth
                    }

           Array lists are created with an initial size. When this size is exceeded, the collection is automatically
           enlarged. When objects are removed, the array may be shrunk.
                - we specify the type in angular braces. Now ArrayList is forced to have only specified type
                  of objects in it. If you try to add another type of object, it gives compile time error.
                - What does the code look like:
                          // create an array list
                          ArrayList al = new ArrayList();
                          System.out.println("Initial size of al: " + al.size());

                          // add elements to the array list
                          al.add("C");
                          al.add("A");
                          al.add("E");
                          al.add("B");
                          al.add("D");
                          al.add("F");
                          al.add(1, "A2");
                          System.out.println("Size of al after additions: " + al.size());

                          // display the array list
                          System.out.println("Contents of al: " + al);

                          // Remove elements from the array list
                          al.remove("F");
                          al.remove(2);
                          System.out.println("Size of al after deletions: " + al.size());
                          System.out.println("Contents of al: " + al);
                           }
                        }
                - Why is the type being specified as VehicleInfo? Should it be a string, integer, double, etc?
                    - Is it because it is drawing in the field types from the class itself?
           */
           vehicleInfos = new ArrayList<>();

           //read from all json files
           File file = new File(".");
           for (File currentFile : file.listFiles()) {
               if (currentFile.getName().endsWith(".json")) {
                   //get json from the file
                   String fileJson = getDataFromFile(currentFile);

                   // Get the json from the file
                   //convert that json to a VehicleInfo Object
//                   ObjectMapper om = new ObjectMapper();
                   VehicleInfo vi = mapper.readValue(fileJson, VehicleInfo.class);

                   //what do we do with vi?
                   // put it inside of an arraylist
                   vehicleInfos.add(vi);

                   // Now you have a File object named "f".
                   // You can use this to create a new instance of Scanner
                   // Again, what the heck is "new instance"? What does it mean, in literal term?
               }
           }

           // when we get to this point, we should have a populated arraylist of VehicleInfo
           // use those values to calc the avgs and what not

           System.out.println(vehicleInfos.size());

           double avgVin = 0;
           double avgMilesTraveled = 0;
           double avgLastOilChange = 0;
           double avgEngineSize = 0;

           for (int i = 0; i < vehicleInfos.size(); i++){
               avgVin += vehicleInfos.get(i).getVin() / vehicleInfos.size();
               avgMilesTraveled += vehicleInfos.get(i).getMilesTraveled() / vehicleInfos.size();
               avgLastOilChange += vehicleInfos.get(i).getLastOilChange() / vehicleInfos.size();
               avgEngineSize += vehicleInfos.get(i).getEngineSize() / vehicleInfos.size();
           }

           System.out.println("Average VIN:" + avgVin);
           System.out.println("Average Miles Traveled: " + avgMilesTraveled);
           System.out.println("Average Last Oil Change: " + avgLastOilChange);
           System.out.println("Average Engine Size: " + avgEngineSize);

       } catch (IOException e) {
           e.printStackTrace();
       }
   }

   static void writeDataToFile(){

   }

   private static String getDataFromFile(File f) throws FileNotFoundException {
         Scanner fileScanner = new Scanner(f);

       String results = "";
         while (fileScanner.hasNext()) {
            results = fileScanner.nextLine();
         }

       // TODO: maybe write a "writeDataToFile" method????

       return results;
   }
}


// When you have a variable or method underlined in red, you can click on that name and hit buttons ( Option + Enter)
// and you will see your list of options to try and fix those errors
