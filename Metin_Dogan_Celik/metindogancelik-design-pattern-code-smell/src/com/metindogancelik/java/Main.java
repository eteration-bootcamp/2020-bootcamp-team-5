package com.metindogancelik.java;

import com.metindogancelik.java.codesmell.ChangePreventers;
import com.metindogancelik.java.designpattern.Egg;
import com.metindogancelik.java.designpattern.Tomato;
import com.metindogancelik.java.designpattern.TomatoAdapter;

public class Main {

    public static void main(String[] args) {
        // Change Preventers Example
        ChangePreventers changePreventers = new ChangePreventers();

        changePreventers.runBefore();
        changePreventers.runAfter();

        // Adapter Example

        System.out.println("\n\n*********\n\n");

        Egg egg = new Egg();

        egg.temperature();
        egg.cook();

        Tomato tomato = new Tomato();
        TomatoAdapter tomatoAdapter = new TomatoAdapter(tomato);

        tomato.slice();
        tomatoAdapter.temperature();
        tomatoAdapter.cook();
    }

}
