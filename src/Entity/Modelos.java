package Entity;

public class Modelos {

//    cita
    private int ID_Cita;
    private int Date;
    private int Hour;
    private String Motive;

//    Especialidad

    private int ID_Especialidad;
    private String NameEspeciality;
    private String Description;

//    Médico

    private int ID_Medico;
    private String NameMedic;
    private String LastNameMedic;

//    Paciente

    private int ID_Paciente;
    private String NamePatient;
    private String LastNamePatient;
    private String DocumentPassword;


    public Modelos() {
        this.ID_Cita = ID_Cita;
        Date = date;
        Hour = hour;
        Motive = motive;
        this.ID_Especialidad = ID_Especialidad;
        NameEspeciality = nameEspeciality;
        Description = description;
        this.ID_Medico = ID_Medico;
        NameMedic = nameMedic;
        LastNameMedic = lastNameMedic;
        this.ID_Paciente = ID_Paciente;
        NamePatient = namePatient;
        LastNamePatient = lastNamePatient;
        DocumentPassword = documentPassword;
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

    public int getID_Especialidad() {
        return ID_Especialidad;
    }

    public void setID_Especialidad(int ID_Especialidad) {
        this.ID_Especialidad = ID_Especialidad;
    }

    public String getNameEspeciality() {
        return NameEspeciality;
    }

    public void setNameEspeciality(String nameEspeciality) {
        NameEspeciality = nameEspeciality;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getID_Medico() {
        return ID_Medico;
    }

    public void setID_Medico(int ID_Medico) {
        this.ID_Medico = ID_Medico;
    }

    public String getNameMedic() {
        return NameMedic;
    }

    public void setNameMedic(String nameMedic) {
        NameMedic = nameMedic;
    }

    public String getLastNameMedic() {
        return LastNameMedic;
    }

    public void setLastNameMedic(String lastNameMedic) {
        LastNameMedic = lastNameMedic;
    }

    public int getID_Paciente() {
        return ID_Paciente;
    }

    public void setID_Paciente(int ID_Paciente) {
        this.ID_Paciente = ID_Paciente;
    }

    public String getNamePatient() {
        return NamePatient;
    }

    public void setNamePatient(String namePatient) {
        NamePatient = namePatient;
    }

    public String getLastNamePatient() {
        return LastNamePatient;
    }

    public void setLastNamePatient(String lastNamePatient) {
        LastNamePatient = lastNamePatient;
    }

    public String getDocumentPassword() {
        return DocumentPassword;
    }

    public void setDocumentPassword(String documentPassword) {
        DocumentPassword = documentPassword;
    }

    @Override
    public String toString() {
        return "Modelos{" +
                "ID_Cita=" + ID_Cita +
                ", Date=" + Date +
                ", Hour=" + Hour +
                ", Motive='" + Motive + '\'' +
                ", ID_Especialidad=" + ID_Especialidad +
                ", NameEspeciality='" + NameEspeciality + '\'' +
                ", Description='" + Description + '\'' +
                ", ID_Medico=" + ID_Medico +
                ", NameMedic='" + NameMedic + '\'' +
                ", LastNameMedic='" + LastNameMedic + '\'' +
                ", ID_Paciente=" + ID_Paciente +
                ", NamePatient='" + NamePatient + '\'' +
                ", LastNamePatient='" + LastNamePatient + '\'' +
                ", DocumentPassword='" + DocumentPassword + '\'' +
                '}';
    }
}
