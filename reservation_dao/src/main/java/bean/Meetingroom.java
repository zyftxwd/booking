package bean;

public class Meetingroom {
    private int id;
    private  String roomnumber;
    private  String reservationStatus;

    public String getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(String reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    @Override
    public String toString() {
        return "Meetingroom{" +
                "id=" + id +
                ", roomnumber='" + roomnumber + '\'' +
                ", reservationStatus='" + reservationStatus + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomnumber() {
        return roomnumber;
    }

    public void setRoomnumber(String roomnumber) {
        this.roomnumber = roomnumber;
    }
}
