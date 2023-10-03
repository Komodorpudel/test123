package B_Uebung.uebung12_NS.A57_neu;

// import java.io.IOException;
import java.io.PrintWriter;

public class PersistenceText {

    PrintWriter writer;

    public void save(LaptopContainer laptopContainer) throws PersistenceException {

        if (writer == null) {
            throw new PersistenceException("Error occured when writing to a file");
        }



        // try {
            writer.println("BEGIN");

            for (Laptop l : laptopContainer) {

                writer.println("NEW");
                writer.println(l.getId());
                writer.println(l.getOperatingSystem());
                writer.println(l.getRam());
                writer.println("Installed Programms");

                for (String p : l.getInstalledPrograms()){
                    writer.println(p);
                }

            }

            writer.println("END");
        // }
        
        /* catch(IOException e) {
            throw new PersistenceException("Error occured when writing to a file");
         } */


    }
    
}
