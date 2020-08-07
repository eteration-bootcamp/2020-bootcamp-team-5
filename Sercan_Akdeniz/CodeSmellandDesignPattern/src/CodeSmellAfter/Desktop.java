package CodeSmellAfter;

//DUPLICATED CODE AFTER INHERITANCE
public class Desktop extends Computer {

    public Desktop(String ram, String hdd, String cpu, String gpu) {
        super(ram, hdd, cpu, gpu);
    }

    @Override
    public void boot() {
        System.out.println("Your Desktop is running. " + this.toString());
    }
}