import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ReservationChangeListener implements PropertyChangeListener {
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getSource().getClass().equals(Reservation.class)) {
            System.out.println("Reservation has been changed!");
            System.out.println("Source:\t" + evt.getSource());
            System.out.println("Property name:\t" + evt.getPropertyName());
            System.out.println("Old value:\t" + evt.getOldValue());
            System.out.println("New value:\t" + evt.getNewValue());
        }
    }
}
