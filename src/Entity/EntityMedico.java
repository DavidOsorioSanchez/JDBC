package Entity;

public class EntityMedico {

    //    Médico

    private int ID_Medico;
    private String NameMedic;
    private String LastNameMedic;
    private int fk_ID_Especialidad;

    private EntityEspecializacion especial;

    public EntityMedico() {
    }

    public EntityMedico(String nameMedic, String lastNameMedic, int fk_ID_Especialidad, EntityEspecializacion especial) {
        NameMedic = nameMedic;
        LastNameMedic = lastNameMedic;
        this.fk_ID_Especialidad = fk_ID_Especialidad;
        this.especial = especial;
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

    public int getFk_ID_Especialidad() {
        return fk_ID_Especialidad;
    }

    public void setFk_ID_Especialidad(int fk_ID_Especialidad) {
        this.fk_ID_Especialidad = fk_ID_Especialidad;
    }

    public EntityEspecializacion getEspecial() {
        return especial;
    }

    public void setEspecial(EntityEspecializacion especial) {
        this.especial = especial;
    }

    @Override
    public String toString() {
        return "EntityMedico{" +
                "ID_Medico=" + ID_Medico +
                ", NameMedic='" + NameMedic + '\'' +
                ", LastNameMedic='" + LastNameMedic + '\'' +
                ", fk_ID_Especialidad=" + fk_ID_Especialidad +
                ", especial=" + especial +
                '}';
    }
}
