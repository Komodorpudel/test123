import java.time.LocalDateTime;

public class ReservationMain  {

    public static void main(String[] args){
        ReservationContainer con = ReservationContainer.getInstance();
        ReservationChangeListener listener = new ReservationChangeListener();
        con.addPropertyChangeListener(listener);
        try {
            con.linkReservation(new Reservation(1, LocalDateTime.MIN, LocalDateTime.MAX));
            con.linkReservation(new Reservation(2, LocalDateTime.now().plusDays(1),
                    LocalDateTime.now().plusDays(1).plusHours(2)));
            Reservation r = new Reservation(2, LocalDateTime.now().plusDays(1).plusHours(1), LocalDateTime.now().plusDays(1).plusHours(3));
            r.addPropertyChangeListener(listener);
            try {
                con.linkReservation(r);
            } catch (ReservationException e) {
                System.out.println(e.getMessage());
                System.out.println(r);
            }
            r.setTableNumber(3);
            con.linkReservation(r);
            con.unlinkReservation(r);
        } catch (ReservationException e) {
            System.err.println(e.getMessage());
        }

    }
}
