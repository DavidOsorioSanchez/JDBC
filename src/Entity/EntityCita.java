package Entity;

public class EntityCita {
    //    cita
    private int ID_Cita;
    private int Date;
    private int Hour;
    private String Motive;

    public EntityCita() {
    }

    public EntityCita(int ID_Cita, int date, int hour, String motive) {
        this.ID_Cita = ID_Cita;
        Date = date;
        Hour = hour;
        Motive = motive;
    }

    public int getID_Cita() {
        return ID_Cita;
    }

    public void setID_Cita(int ID_Cita) {
        this.ID_Cita = ID_Cita;
    }

    public int getDate() {
        return Date;
    }

    public void setDate(int date) {
        Date = date;
    }

    public int getHour() {
        return Hour;
    }

    public void setHour(int hour) {
        Hour = hour;
    }

    public String getMotive() {
        return Motive;
    }

    public void setMotive(String motive) {
        Motive = motive;
    }

    @Override
    public String toString() {
        return "EntityCita{" +
                "ID_Cita=" + ID_Cita +
                ", Date=" + Date +
                ", Hour=" + Hour +
                ", Motive='" + Motive + '\'' +
                '}';
    }
}
