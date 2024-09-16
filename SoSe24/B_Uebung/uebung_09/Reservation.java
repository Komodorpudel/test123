import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Reservation {
    private int tableNumber;
    private LocalDateTime start;
    private LocalDateTime end;

    public Reservation(int tableNumber, LocalDateTime start, LocalDateTime end) throws ReservationException {
        setTableNumber(tableNumber);
        setStart(start);
        setEnd(end);
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    private boolean checkStartEnd() {
        if (start == null || end == null)
            return true;
        return start.isBefore(end);
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) throws ReservationException {
        if (!checkStartEnd())
            throw new ReservationException("Start must be before end");
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) throws ReservationException {
        if (!checkStartEnd())
            throw new ReservationException("Start must be before end");
        this.end = end;
    }

    public boolean collidesWith(Reservation reservation) {
        if (this.getTableNumber() == reservation.getTableNumber()) {
            LocalDateTime start = reservation.getStart();
            LocalDateTime end = reservation.getEnd();
            return this.getStart().isBefore(end) && start.isBefore(this.getEnd());
        }
        return false;
    }

    @Override
    public String toString() {
        return "Table " + getTableNumber() +
                ", from " + getStart().format(DateTimeFormatter.ofPattern("EEEE, d. LLLL , k:m")) +
                " to " + getEnd().format(DateTimeFormatter.ofPattern("EEEE, d. LLLL, k:m"));
    }
}
