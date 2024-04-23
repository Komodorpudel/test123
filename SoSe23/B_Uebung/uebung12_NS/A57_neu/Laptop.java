package SoSe23.B_Uebung.uebung12_NS.A57_neu;

import java.util.ArrayList;

public class Laptop {

    private Integer id;
    private OperatingSystem operatingSystem;
    private Integer ram;
    private ArrayList<String> installedProgramms;

    // Konstruktor
    public Laptop(Integer id, OperatingSystem operatingSystem, Integer ram, ArrayList<String> installedProgramms) throws IllegalLaptopException {

    }

    public Integer getId() {

        return this.id;
    }

    public OperatingSystem getOperatingSystem() {
        return this.operatingSystem;
    }

    public Integer getRam() {

        return this.ram;
    }

    public ArrayList<String> getInstalledPrograms() {

        return this.installedProgramms;
    }

}
