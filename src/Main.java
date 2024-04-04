import Controller.EspecialidadController;
import Database.ConfigDB;

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
                                    EspecialidadController.update();
                                    break;
                                case 2:
                                    EspecialidadController.insert();
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
                                    break;
                                case 2:
                                    break;
                                case 3:
                                    break;
                                case 4:
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
                                4. Listar Cita
                                5. Salir 
                                
                                Elige la opcion que mas te conviene.
                                """));
                            switch (option2){
                                case 1:
                                    break;
                                case 2:
                                    break;
                                case 3:
                                    break;
                                case 4:
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
                                4. Listar paciente
                                5. Salir 
                                
                                Elige la opcion que mas te conviene.
                                """));
                            switch (option2){
                                case 1:
                                    break;
                                case 2:
                                    break;
                                case 3:
                                    break;
                                case 4:
                                    break;
                            }
                        }while (option2 != 5);
                        break;
                }
        }while (option1 != 5);

    }
}