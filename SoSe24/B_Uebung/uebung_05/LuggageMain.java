import java.util.ArrayList;
import java.util.Random;

public class LuggageMain {
    public static void main(String[] args) {
        LuggageContainer con = new LuggageContainer();
        int caughtExceptions = 0;
        for (String id: new String[]{"CD34", "AB12", "ABC12", "AB123", "AB1", "A12", ""}) {
            for (String owner: new String[]{"", "Jane Doe", "Max Mustermann"}) {
                for (double weight: new double[]{2.0, 0.0, -1}) {
                    try {
                        con.addLuggage(new Luggage(id, owner, weight));
                    } catch (IllegalArgumentException e) {
                        caughtExceptions++;
                    }
                }
            }
        }
        if (caughtExceptions != 59) {
            System.out.println("Some check-functions are not complete, there should be 59 caught exceptions, but there were only " + caughtExceptions);
        } else {
            double totalWeight = con.stream().mapToDouble(Luggage::getWeight).sum();
            System.out.println("Total weight of checked in luggage: " + totalWeight);
            int itemsForJaneDoe = (int) con.stream().filter(l -> l.getOwner().equals("Jane Doe")).count();
            System.out.println("Total number of luggage items checked in by Jane Doe: " + itemsForJaneDoe);
            System.out.println("removing each luggage item with 50% chance...");
            Random rng = new Random();
            ArrayList<Luggage> lostLuggage = new ArrayList<>();
            con.forEach(l -> {
                if (rng.nextBoolean()) {
                    lostLuggage.add(l);
                }
            });
            lostLuggage.forEach(con::removeLuggage);
            itemsForJaneDoe = (int) con.stream().filter(l -> l.getOwner().equals("Jane Doe")).count();
            System.out.println("Remaining number of luggage items checked in by Jane Doe: " + itemsForJaneDoe);
        }

    }
}
