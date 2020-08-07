package FactoryPattern;

public class Notebook extends Computer {

    private String ram;
    private String hdd;
    private String cpu;
    private String gpu;

    public Notebook(String ram, String hdd, String cpu, String gpu){
        this.ram = ram;
        this.hdd = hdd;
        this.cpu = cpu;
        this.gpu = gpu;
    }

    @Override
    public String getRAM() {
        return this.ram;
    }

    @Override
    public String getHDD() {
        return this.hdd;
    }

    @Override
    public String getCPU() {
        return this.cpu;
    }

    @Override
    public String getGPU() {
        return gpu;
    }

    @Override
    public String toString(){
        return "Your Notebook's specs are " + "RAM is = " + this.getRAM() + ", HDD is = " + this.getHDD() + ", CPU is = " + this.getCPU() + ", GPU is = " + this.getGPU();
    }
}