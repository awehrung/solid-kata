package com.codurance.lsp;

public class FillingStation {
    public void refuel(PetrolCar car) {
        car.fillUpWithFuel();
    }

    public void charge(ElectricCar car) {
        car.chargeBattery();
    }
}
