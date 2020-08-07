package CodeSmellBefore;

//DUPLICATED CODE BEFORE INHERITANCE
public class Test {

    public static void main(String[] args) {
        Computer computer = new Computer("4 GB", "500 GB", "2.4 GHz", "2 GB");
        Desktop desktop = new Desktop("8 GB", "1 TB", "2.9 GHz", "4 GB");
        Notebook notebook = new Notebook("16 GB", "2 TB", "3.2 GHz", "8 GB");
        computer.boot();
        desktop.boot();
        notebook.boot();
    }
}
