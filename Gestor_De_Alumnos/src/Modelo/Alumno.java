/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Johana
 */
public class Alumno {
    
    private int id;
    private String nomYApe;
    private int edad;
    private String sexo;
    private Sexo sexEnum;

    public Alumno() {
    }
    
    
    public Alumno(int id, String nombre, int edad, String sexo){

        this.id = id;
        this.nomYApe = nombre;
        this.edad = edad;
        
        if(sexo.equalsIgnoreCase(sexEnum.Femenino.name())){
        
            this.sexo = sexo;
        }else if(sexo.equalsIgnoreCase(sexEnum.Masculino.name())){
        
            this.sexo = sexo;
        }else{
        
            this.sexo = null;
        }
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomYApe() {
        return nomYApe;
    }

    public void setNomYApe(String nomYApe) {
        this.nomYApe = nomYApe;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {

        this.sexo = sexo;
    }
    
    public void mostrarInformacion(){
    
        System.out.println("Id : "+id+", Nombre: "+nomYApe+", Edad: "+edad+", Genero: "+sexo);
    }
    
}
