package com.peaksoft;

public class TruckPark {
    private  int id;
    private  String name;
    private String drivers;
    private States states;
    public static TruckPark carPark(int id, String name, String drivers, States states){
        TruckPark park = new TruckPark();
        park.id = id;
        park.name = name;
        park.drivers = drivers;
        park.states = states;
        return park;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public States getStates() {
        return states;
    }

    public void setStates(States states) {
        this.states = states;
    }

    public String getDrivers() {
        return drivers;
    }

    public void setDrivers(String drivers) {
        this.drivers = drivers;
    }


    @Override
    public String toString() {
        return  " " + id +
                "| " + name +
                "  | " + drivers +
                "       | " + states ;
    }


}
