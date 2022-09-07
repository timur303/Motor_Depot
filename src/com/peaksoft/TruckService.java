package com.peaksoft;

public interface TruckService {
    void changeDriver( TruckPark truckPark, Drivers[] drivers);
    void startDriving(String truck, String driver);
    void startRepair(String truck);
}
