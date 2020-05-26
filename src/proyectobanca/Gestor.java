/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectobanca;

import java.util.Scanner;

/**
 *
 * @author Alberto
 */
public class Gestor implements ClaseIntermedia{
    
    
    static Scanner sc = new Scanner(System.in);
    
    /**
     * Método modificarNombre: le introducimos un objeto. Dentro, nos pide un nuevo nombre y actualizamos el nombre antiguo
     * de esa cuenta por este nuevo nombre.
     * @param c 
     */
    @Override
    public void modificarNombre(Cliente c) {
        System.out.println("Dime un nuevo nombre");
        String newnombre=sc.nextLine();
        c.setNombre(newnombre);
    }
    
    /**
     * Método modificarApellido: le introducimos un objeto. Dentro, nos pide un nuevo apellido y actualizamos el apellido antiguo
     * de esa cuenta por este nuevo apellido.
     * @param c 
     */
    @Override
    public void modificarApellido(Cliente c) {
        System.out.println("Dime un nuevo apellido");
        String newapellido=sc.nextLine();
        c.setApellido(newapellido);
    }
    
    /**
     * Método modificarDireccion: le introducimos un objeto. Dentro, nos pide una nueva dirección y actualizamos la dirección
     * antigua de esa cuenta por esta nueva dirección.
     * @param c 
     */
    @Override
    public void modificarDireccion(Cliente c) {
        System.out.println("Dime una nueva dirección");
        String newdireccion=sc.nextLine();
        c.setDireccion(newdireccion);
    }

    /**
     * Método modificarTelefono: le introducimos un objeto. Dentro, nos pide un nuevo teléfono y actualizamos el teléfono
     * antiguo de esa cuenta por este nuevo teléfono.
     * @param c 
     */    
    @Override
    public void modificarTelefono(Cliente c) {
        System.out.println("Dime un nuevo teléfono");
        int newtelefono=sc.nextInt();
        c.setTelefono(newtelefono);
    }
}
