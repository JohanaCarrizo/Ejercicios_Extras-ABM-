/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Alumno;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author Johana
 */
public class ControladorAlumno {
    
    private Map<Integer, Alumno> repositorioAlu;
    
    public ControladorAlumno(){
    
        repositorioAlu = new TreeMap<>();
    }
    
    
    /**
     * Busca con el id si existe el alumno
     * @return 
     */
    public boolean buscarId(int id){
    
        return repositorioAlu.containsKey(id) ? true : false;
    }
    
    /**
     * Alta de Alumno
     * @return 
     */
    public boolean altaAlumno(Alumno alu){
    
        if(buscarId(alu.getId())){
            
            return false;
        
        }else{
        
            repositorioAlu.put(alu.getId(), alu);
            return true;
        }
        
    }
    
    /**
     * Baja de Alumno
     * @return 
     */
    
    public Alumno bajaAlumno(int id){
         
        repositorioAlu.remove(id);
        return null;
    }
    
    /**
     * 
     * Modificacion de Alumno
     * @return 
     */
    
    public void modificarAlumno(int id, Alumno alu){
            
        repositorioAlu.remove(id);
        repositorioAlu.put(alu.getId(), alu);
       
    }
    
    /**
     * Obtener informacion de un Alumno en especifico
     * @return 
     */
    
    public Alumno obtenerAlu(int idAlu){
    
        return buscarId(idAlu) ? repositorioAlu.get(idAlu) : null ;
    }
    
    /**
     * Devuelve la lista de Alumnos dado de alta
     * @return 
     */
    
    public ArrayList<Alumno> listarAlumnosOrdenados(){
    
        ArrayList<Alumno> listaAlu = new ArrayList<>();
        
        Set<Integer> setKey = repositorioAlu.keySet();
        
        for (Integer id : setKey) {
            
            listaAlu.add(repositorioAlu.get(id));
            
        }
        return listaAlu;
    }
    
}
