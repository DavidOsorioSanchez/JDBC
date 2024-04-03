package Entity;

public class EntityPaciente {
    //    Paciente

    private int ID_Paciente;
    private String NamePatient;
    private String LastNamePatient;
    private int DateBorn;
    private String DocumentPassword;

    public EntityPaciente() {
    }

    public EntityPaciente(int ID_Paciente, String namePatient, String lastNamePatient, int dateBorn, String documentPassword) {
        this.ID_Paciente = ID_Paciente;
        NamePatient = namePatient;
        LastNamePatient = lastNamePatient;
        DateBorn = dateBorn;
        DocumentPassword = documentPassword;
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

    public int getDateBorn() {
        return DateBorn;
    }

    public void setDateBorn(int dateBorn) {
        DateBorn = dateBorn;
    }

    public String getDocumentPassword() {
        return DocumentPassword;
    }

    public void setDocumentPassword(String documentPassword) {
        DocumentPassword = documentPassword;
    }

    @Override
    public String toString() {
        return "EntityPaciente{" +
                "ID_Paciente=" + ID_Paciente +
                ", NamePatient='" + NamePatient + '\'' +
                ", LastNamePatient='" + LastNamePatient + '\'' +
                ", DateBorn=" + DateBorn +
                ", DocumentPassword='" + DocumentPassword + '\'' +
                '}';
    }
}
