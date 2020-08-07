package FactoryPattern;

public abstract class Computer {

    public abstract String getRAM();
    public abstract String getHDD();
    public abstract String getCPU();
    public abstract String getGPU();

    public String toString(){
        return "Computer's specs are " + "RAM is = " + this.getRAM() + ", HDD is = " + this.getHDD() + ", CPU is = " + this.getCPU() + ", GPU is = " + this.getCPU();
    }
}