package com.peaksoft;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Main {
        public static final GsonBuilder BUILDER = new GsonBuilder();
        public static final Gson gson =BUILDER.setPrettyPrinting().create();
        public static  final Path WRITE_TRUCK = Paths.get("./tracpark.json");
        public static  final Path WRITE_DRIVERS = Paths.get("./drivers.json");

    public static void main(String[] args) {

        Drivers [] drivers = {
                Drivers.drivers(1,"Janybek", " "),
                Drivers.drivers(2,"Kalybek", " "),
                Drivers.drivers(3,"Asan   ", " ")
        };


        TruckPark[] truckParks = {
                TruckPark.carPark(1, "Volvo"," " ,States.REMOTE),
                TruckPark.carPark(2, "MAN", " ", States.BASE),
                TruckPark.carPark(3, "DAF-X", " ", States.BASE)
        };



        System.out.println(" info about tracks");
        System.out.println(" ______________________________");
        System.out.println(" #| Truck | Driver | State ");
        System.out.println(" ______________________________");

        TruckPark [] truck1 = gson.fromJson(readFile1(WRITE_TRUCK), TruckPark[].class);
        for (TruckPark truck: truck1){
            System.out.println(truck.toString());
        }

        System.out.println();
        System.out.println(" info about drivers");
        System.out.println(" ______________________________");
        System.out.println(" #| Truck | Driver | State ");
        System.out.println(" ______________________________");


        System.out.println("if you want to send the path click on 1\n"
                +"if you want to send for repair click on 2\n"
                +"if you want to select a driver click on 3");

        writeFile1(gson.toJson(truckParks),WRITE_TRUCK);
        writeFile1(gson.toJson(drivers),WRITE_DRIVERS);


        Drivers [] drivers1 = gson.fromJson(readFile1(WRITE_DRIVERS),Drivers[].class);
        for (Drivers driver: drivers1){
            System.out.println(driver.toString());
        }

        while (true){
            try {
                TruckServiceImpl serviceImpl = new TruckServiceImpl();
                Scanner scanner = new Scanner(System.in);
                System.out.println("select auto or press 0 ");
                int truck =scanner.nextInt();
                serviceImpl.truckMethod(truckParks,truck,drivers);
                if(truck==0){
                    break;
                }
                for (TruckPark truckPark1:truckParks){
                    if (truckPark1.getId()==truck){
                        System.out.println("N:  " +truckPark1.getId());
                        System.out.println("Truck :  " +truckPark1.getName());
                        System.out.println("Drivers :  " +truckPark1.getDrivers().equals(" "));
                        System.out.println("Truck status:  " +truckPark1.getStates());
                    }
                }

            }catch (RuntimeException e){
                System.out.println(e.getMessage());
            }
        }
    }

        private static void writeFile1(String object,Path path){
        try{
            Files.writeString(Paths.get(String.valueOf(path)),object,
                    StandardOpenOption.CREATE,StandardOpenOption.WRITE);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        }

        public static String readFile1(Path path){
        StringBuilder builder = new StringBuilder();
        try(FileReader reader = new FileReader(String.valueOf(path))){
            int a;
            while ((a=reader.read()) != -1) {
                builder.append((char) a);
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }return builder.toString();
        }


}
