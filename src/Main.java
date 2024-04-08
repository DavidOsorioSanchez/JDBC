import Controller.CitaController;
import Controller.EspecialidadController;
import Controller.MedicoController;
import Controller.PacienteController;
import Database.ConfigDB;
import Model.ModelMedico;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        int option1 = 0, option2 = 0;

        do {
            option1 = Integer.parseInt(JOptionPane.showInputDialog(null, """
                    1. Administrar Especializacion
                    2. Administrar Medicos
                    3. Administrar Citas
                    4. Administrar Pacientes
                    5. Salir
                    
                    Eligue la opcion que mas te conviene.
                    """));
                switch (option1){
                    case 1:
                        do {
                            option2 = Integer.parseInt(JOptionPane.showInputDialog(null, """
                                1. Añadir informacion a especializacion
                                2. Modificar especializacion
                                3. Borrar especializacion
                                4. Listar Especializacion
                                5. Salir 
                                
                                Elige la opcion que mas te conviene.
                                """));
                            switch (option2){
                                case 1:
                                    EspecialidadController.insert();
                                    break;
                                case 2:
                                    EspecialidadController.update();
                                    break;
                                case 3:
                                    EspecialidadController.borrar();
                                    break;
                                case 4:
                                    EspecialidadController.listar();
                                    break;

                            }
                        }while (option2 != 5);

                        break;
                    case 2:
                        do {
                            option2 = Integer.parseInt(JOptionPane.showInputDialog(null, """
                                1. Añadir informacion a medico
                                2. Modificar medico
                                3. Borrar medico
                                4. Listar medico
                                5. Salir 
                                
                                Elige la opcion que mas te conviene.
                                """));
                            switch (option2){
                                case 1:
                                    MedicoController.insert();
                                    break;
                                case 2:
                                    MedicoController.update();
                                    break;
                                case 3:
                                    MedicoController.borrar();
                                    break;
                                case 4:
                                    MedicoController.listar();
                                    break;
                            }
                        }while (option2 != 5);
                        break;
                    case 3:
                        do {
                            option2 = Integer.parseInt(JOptionPane.showInputDialog(null, """
                                1. Añadir informacion a Cita
                                2. Modificar Cita
                                3. Borrar Cita
                                4. Listar una cita por fecha
                                5. Salir
                                
                                Elige la opcion que mas te conviene.
                                """));
                            switch (option2){
                                case 1:
                                    CitaController.insert();
                                    break;
                                case 2:
                                    CitaController.update();
                                    break;
                                case 3:
                                    CitaController.borrar();
                                    break;
                                case 4:
                                    CitaController.listar();
                                    break;
                            }
                        }while (option2 != 5);
                        break;
                    case 4:
                        do {
                            option2 = Integer.parseInt(JOptionPane.showInputDialog(null, """
                                1. Añadir informacion a paciente
                                2. Modificar paciente
                                3. Borrar paciente
                                4. Listar un paciente documentod
                                5. Salir 
                                
                                Elige la opcion que mas te conviene.
                                """));
                            switch (option2){
                                case 1:
                                    PacienteController.insert();
                                    break;
                                case 2:
                                    PacienteController.update();
                                    break;
                                case 3:
                                    PacienteController.borrar();
                                    break;
                                case 4:
                                    PacienteController.listar();
                                    break;
                            }
                        }while (option2 != 5);
                        break;
                }
        }while (option1 != 5);

    }
}