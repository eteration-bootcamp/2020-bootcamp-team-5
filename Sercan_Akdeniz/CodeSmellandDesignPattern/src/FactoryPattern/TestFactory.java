package FactoryPattern;

public class TestFactory {

    public static void main(String[] args) {

        Computer notebook = ComputerFactory.getComputer("notebook","4 GB","500 GB","2.4 GHz", "2 GB");
        Computer desktop = ComputerFactory.getComputer("desktop","8 GB","1 TB","2.9 GHz", "4 GB");

        System.out.println("Factory Notebook => " + notebook);
        System.out.println("Factory Desktop => " + desktop);
    }
}