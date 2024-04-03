package Entity;

public class EntityEspecializacion {


//    Especialidad

    private int ID_Especialidad;
    private String NameEspeciality;
    private String Description;


    public EntityEspecializacion() {
    }

    public EntityEspecializacion(int ID_Especialidad, String nameEspeciality, String description) {
        this.ID_Especialidad = ID_Especialidad;
        NameEspeciality = nameEspeciality;
        Description = description;
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

    @Override
    public String toString() {
        return "EntityEspecializacion{" +
                "ID_Especialidad=" + ID_Especialidad +
                ", NameEspeciality='" + NameEspeciality + '\'' +
                ", Description='" + Description + '\'' +
                '}';
    }
}
