package B_Uebung.uebung12_NS.A57_neu;

import java.util.ArrayList;
import java.util.Iterator;

public class LaptopContainer implements Iterable<Laptop> {

    ArrayList <Laptop> laptops = new ArrayList<>();



    // iteratormuster
    public Iterator<Laptop> iterator(){

        return laptops.iterator();
    }

}
