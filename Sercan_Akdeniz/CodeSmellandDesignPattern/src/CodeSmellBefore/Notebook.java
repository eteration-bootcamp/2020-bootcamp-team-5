package CodeSmellBefore;

//DUPLICATED CODE BEFORE INHERITANCE
public class Notebook {

    private String ram;
    private String hdd;
    private String cpu;
    private String gpu;

    public Notebook(String ram, String hdd, String cpu, String gpu) {
        this.ram = ram;
        this.hdd = hdd;
        this.cpu = cpu;
        this.gpu = gpu;
    }

    @Override
    public String toString() {
        return "Notebook's Specs => {" +
                "ram='" + ram + '\'' +
                ", hdd='" + hdd + '\'' +
                ", cpu='" + cpu + '\'' +
                ", gpu='" + gpu + '\'' +
                '}';
    }

    public void boot() {
        System.out.println("Your Notebook is running. " + this.toString());
    }
}
