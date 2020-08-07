package com.metindogancelik.java.designpattern;

public class Egg implements Cookable{

    @Override
    public void temperature() {
        System.out.println("Temperature is setting for egg...");
    }

    @Override
    public void cook() {
        System.out.println("Egg is cooking...");
    }
}
