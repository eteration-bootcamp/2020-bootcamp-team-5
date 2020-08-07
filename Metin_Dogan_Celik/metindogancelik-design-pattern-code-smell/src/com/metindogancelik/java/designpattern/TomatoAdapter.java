package com.metindogancelik.java.designpattern;

public class TomatoAdapter implements Cookable {

    Tomato tomato;

    public TomatoAdapter(Tomato tomato) {
        this.tomato = tomato;
    }

    @Override
    public void temperature() {
        System.out.println("Temperature is setting for tomato...");
    }

    @Override
    public void cook() {
        System.out.println("Tomato is cooking...");
    }
}
