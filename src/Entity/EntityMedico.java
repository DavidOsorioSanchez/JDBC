package Entity;

public class EntityMedico {

    //    Médico

    private int ID_Medico;
    private String NameMedic;
    private String LastNameMedic;

    public EntityMedico() {
    }

    public EntityMedico( String nameMedic, String lastNameMedic) {
        NameMedic = nameMedic;
        LastNameMedic = lastNameMedic;
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

    @Override
    public String toString() {
        return "EntityMedico{" +
                "ID_Medico=" + ID_Medico +
                ", NameMedic='" + NameMedic + '\'' +
                ", LastNameMedic='" + LastNameMedic + '\'' +
                '}';
    }
}
