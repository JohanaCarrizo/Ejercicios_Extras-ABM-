/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorAlumno;
import Modelo.Alumno;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Johana
 */
public class VistaAlumno {

    private Scanner leer;
    private ControladorAlumno cAlu;
    private static final VistaAlumno view = new VistaAlumno();

    public VistaAlumno() {

        leer = new Scanner(System.in).useDelimiter("\n");
        cAlu = new ControladorAlumno();
    }

    public static VistaAlumno getVista() {

        return view;
    }

    /**
     * MENU DE OPERACIONES POSIBLES
     */
    public void menu() {

        boolean bandera = true;

        do {

            System.out.println("//////////////SISTEMA DE GESTION DE ALUMNOS//////////////");
            System.out.println("1. Crear alumno \n2. Modificar alumno \n3. Eliminar alumno \n4. Buscar alumno \n5. Listar todos los alumnos \n6. Salir del sistema");

            System.out.print("Selecciones la operacion a realizar --> ");
            int op = leer.nextInt();

            switch (op) {

                case 1:
                    
                    agregarAlumno();
                    break;

                case 2:

                    modAlumno();
                    break;

                case 3:
                    
                    eliminarAlumno();
                    break;

                case 4:
                    
                    buscarAlumnoEspecifico();
                    break;

                case 5:
                    
                    listarAlumnos();
                    break;

                case 6:

                    bandera = false;
                    break;

                default:
                    System.out.println("Ingrese una opcion correcta. Selecciones del 1 al 6");
                    break;

            }

        } while (bandera);
    }

    /**
     * METODO PARA EL INGRESO DE DATOS DEL ALUMNO (ALTA)
     */
    public void agregarAlumno() {

        System.out.println("Ingrese los datos del alumno: ");
        System.out.print("Id --> ");
        int id = leer.nextInt();
        System.out.print("Nombre y Apellido --> ");
        String nomYApe = leer.next();
        System.out.print("Edad --> ");
        int edad = leer.nextInt();
        System.out.print("Sexo --> ");
        String sexo = leer.next();

        Alumno alu = new Alumno(id, nomYApe, edad, sexo);

        if (cAlu.altaAlumno(alu)) {

            System.out.println("Alumno guardado con éxito!!");
        } else {

            System.out.println("El alumno que desea guardar ya exite en el sistema.");
        }

    }

    /**
     * METODO DE MODIFICACION DE DATOS DEL ALUMNO (MODIFICACION)
     */
    public void modAlumno() {

        System.out.println("Ingrese el id del alumno a modificar: ");
        int id = leer.nextInt();
        Alumno alu = cAlu.obtenerAlu(id);

        if (alu == null) {

            System.out.println("El alumno no existe");
            return;
        }

        boolean bandera = true;
        while (bandera) {
            System.out.println("//////////////Modificar datos del alumno//////////////");
            System.out.println("1. Modificar el id del alumno \n2. Modificar el nombre y apellido \n3. Modificar edad \n4. Modificar sexo \n5. Finalizar modificacion");
            int op = leer.nextInt();

            menuDeModificacion(op, alu);
            
            bandera = op == 5 ? false : true;
        }
    }

    /**
     * METODO UTILIZADO PARA COMPLEMENTAR EL METODO modAlumno(). MENU DE OPCIONES SEGUN QUE DATO DESEA MODIFICAR
     * @param op
     * @param alu 
     */
    public void menuDeModificacion(int op, Alumno alu) {

        //boolean bandera = true;

       

            switch (op) {

                case 1:
                    System.out.print("Ingrese el nuevo id del alumno --> ");
                    int nuevoId = leer.nextInt();                    
                    alu.setId(nuevoId);
                    break;

                case 2:
                    System.out.print("Ingrese el nuevo nombre y apellido --> ");
                    String nuevoNom = leer.next();
                    alu.setNomYApe(nuevoNom);
                    break;

                case 3:
                    System.out.print("Ingrese la nueva edad --> ");
                    int nuevaEdad = leer.nextInt();
                    alu.setEdad(nuevaEdad);
                    break;

                case 4:
                    System.out.print("Ingrese el nuevo sexo --> ");
                    String nuevoSexo = leer.next();
                    alu.setSexo(nuevoSexo);
                    break;

                case 5:
                    
                    System.out.println("Modificacion exitosa!!");
                    break;
            }
            
        

    }
    
    /**
     * METODO PARA ELIMINAR EL ALUMNO 
     */
    public void eliminarAlumno(){
    
        System.out.println("Ingrese el id del alumno a eliminar: ");
        int idEliminar = leer.nextInt();
        
        Alumno alu = cAlu.bajaAlumno(idEliminar); 
        
        if(alu == null){
            
            System.out.println("Alumno eliminado con éxito");
        
        }        
        
        listarAlumnos();
    }
    
    
    /**
     * METODO PARA BUSCAR UN ALUMNO EN PARTICULAR MEDIANTE SU ID
     */
    public void buscarAlumnoEspecifico(){
    
        System.out.println("Ingrese el id del alumno a buscar: ");
        int idBuscar = leer.nextInt();
        
        Alumno aluEncontrado = cAlu.obtenerAlu(idBuscar);
        
        if(aluEncontrado == null){
            
            System.out.println("No se encontro el alumno.");
        
        }
        aluEncontrado.mostrarInformacion();
    }
    
    
    /**
     * METODO PARA LISTAR TODOS LOS ALUMNO CARGADOS DENTRO DEL SISTEMA
     */
    public void listarAlumnos(){
    
        ArrayList<Alumno> listaAlu = cAlu.listarAlumnosOrdenados();
        
        System.out.println("**********************************");
        System.out.print("Cantidad de alumnos --> "+listaAlu.size()+"\n");
        
        for (Alumno alu : listaAlu) {
            
            alu.mostrarInformacion();
            
        }
        System.out.println("");
    }

}
