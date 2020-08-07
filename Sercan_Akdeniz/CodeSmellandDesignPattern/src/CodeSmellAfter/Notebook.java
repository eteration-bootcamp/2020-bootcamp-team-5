package CodeSmellAfter;

//DUPLICATED CODE AFTER INHERITANCE
public class Notebook extends Computer {

    public Notebook(String ram, String hdd, String cpu, String gpu) {
        super(ram, hdd, cpu, gpu);
    }

    @Override
    public void boot() {
        System.out.println("Your Notebook is running. " + this.toString());
    }
}