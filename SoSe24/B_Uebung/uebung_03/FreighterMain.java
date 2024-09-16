public class FreighterMain {
    public static void main(String[] args) {
        Freighter myFreighter = new Freighter(50000);
        FreightContainer c1 = new FreightContainer();
        c1.setCargoWeight(13000);
        FreightContainer c2 = new FreightContainer(13000);
        FreightContainer c3 = new FreightContainer(13000);
        if (myFreighter.addContainer(c1)) {
            System.out.println("Added c1 successfully");
        } else {
            System.out.println("Failed to add c1");
        }
        if (myFreighter.addContainer(c2)) {
            System.out.println("Added c2 successfully");
        } else {
            System.out.println("Failed to add c2");
        }
        if (myFreighter.addContainer(c3)) {
            System.out.println("Added c3 successfully");
        } else {
            System.out.println("Failed to add c3");
        }
        myFreighter.removeContainer(1);
        System.out.println("Removed the second container successfully");
        if (myFreighter.addContainer(c3)) {
            System.out.println("Added c3 successfully");
        } else {
            System.out.println("Failed to add c3");
        }
    }
}
