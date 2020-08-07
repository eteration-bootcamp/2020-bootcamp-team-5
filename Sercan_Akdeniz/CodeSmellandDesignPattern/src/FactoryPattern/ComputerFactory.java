package FactoryPattern;

public class ComputerFactory {

    public static Computer getComputer(String type, String ram, String hdd, String cpu, String gpu){
        if("Desktop".equalsIgnoreCase(type)) return new Desktop(ram, hdd, cpu, gpu);
        if("Notebook".equalsIgnoreCase(type)) return new Notebook(ram, hdd, cpu, gpu);
        return null;
    }
}