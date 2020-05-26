/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectobanca;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Alberto
 */
public class ProyectoBanca {
    
    static Scanner sc = new Scanner(System.in);
    static ArrayList <Cliente> cuentasClientes = new ArrayList<>();
    static Gestor Alberto = new Gestor();
    static int numerocuenta;
        
    public static void main(String[] args) {
        
        cuentasClientes.add(new Cliente("Alberto","Limon","mostoles","123A",888,18,1900,5));
        cuentasClientes.add(new Cliente("Alberto","Limon","mostoles","123A",888,22,500,6));
        cuentasClientes.add(new Cliente("Carlos","Alvarez","mostoles","456B",999,19,1000,3));
        cuentasClientes.add(new Cliente("Alvaro","Lopez","mostoles","789C",777,20,2500,10));
        
        
        int opcion;
        do{
            menu();
              System.out.println("Selecciona una opción");
                opcion=sc.nextInt();
            
            switch(opcion){
                case 0:
                    System.out.println("Has salido");
                    break;
                case 1:
                    mostrarCuentas();
                    break;
                case 2:
                    crearCuenta();
                    break;
                case 3:
                    menuOperaciones();
                    break;
                case 4:
                    menuModificarDatos();
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }
                
                
                
        }while(opcion!=0);
    }
    //MENÚ PRINCIPAL
    /**
     * Metodo menu: aquí hago un pequeño menú para la aplicación
     */
    public static void menu(){
        System.out.println("----------------------");
        System.out.println("Aplicación del banco");
        System.out.println("1.Mostrar cuentas");
        System.out.println("2.Crear cuenta");
        System.out.println("3.Realizar operaciones");
        System.out.println("4.Modificar datos");
        System.out.println("0.Salir del banco");
        System.out.println("----------------------");
    }
    
    /**
     * Método mostrarCuentas: una vez estemos dentro del menú, una de las opciones es mostrarCuentas y llama a este método.
     */
    public static void mostrarCuentas(){
            for (int i = 0; i < cuentasClientes.size(); i++) {
                System.out.println(cuentasClientes.get(i));
            }
        }
    
    
    /**
     * Método menuOperaciones: muestra un menú para realizar operaciones de consultar saldo, retirar saldo o ingresar saldo
     * Le llamamso cuando se elige en el menú anterior la opción 3.
     */
    public static void menuOperaciones(){
        System.out.println("1.Ingresar dinero");
        System.out.println("2.Retirar dinero");
        System.out.println("3.Consultar saldo");
        System.out.println("0.Salir");
        System.out.println("Selecciona una opción");
        int opcion=sc.nextInt();
        
        switch(opcion){
            case 1:
                ingresarSaldo();
                break;
            case 2:
                retirarSaldo();
                break;
            case 3:
                consultarSaldo();
                break;
            case 0:
                System.out.println("Has salido");
                break;
            default:
                System.out.println("Opción incorrecta");
        }
    }
    
    /**
     * Método comprobarNumeroCuenta: comprueba que el número de cuenta que introducimos sea correcto y pertenezca a alguna cuenta
     */
    public static void comprobarNumeroCuenta(){
       
        System.out.println("Dime el número de cuenta");
        numerocuenta=sc.nextInt();
        int contador = 0;
        while (contador!=1) {
            for (int i = 0; i < cuentasClientes.size(); i++) {
                if (numerocuenta == cuentasClientes.get(i).getNumeroCuenta()) {
                    contador++;
                }
            }
            if (contador == 1) {
                System.out.println("Cuenta encontrada");
                break;
            } else {
                System.out.println(" Ese número de cuenta no existe, por favor, introduzca uno nuevo.");
                numerocuenta = sc.nextInt();
            }
        }
    }
    
    /**
     * Método crearCuenta: le pedimos al usuario los valores necesarios para crear una cuenta, le damos 0 de saldo inicial,
     * y comprueba que el número de cuenta que le introducimos no lo tenga otra cuenta ya, en cuyo caso, volvemos a introducirlo.
     */
    public static void crearCuenta(){
        System.out.println("Introduce el nombre de la nueva cuenta");
        String nombre=sc.next();
        System.out.println("Introduce sus apellidos");
        String apellido=sc.next();
        System.out.println("Introduce su dirección");
        String direccion=sc.next();
        System.out.println("Introduce su nif");
        String nif=sc.next();
        System.out.println("Introduce su telefono");
        int telefono=sc.nextInt();
        System.out.println("Dime su edad");
        int edad=sc.nextInt();
        for (int i = 0; i < cuentasClientes.size(); i++) {
            if(numerocuenta == cuentasClientes.get(i).getNumeroCuenta()){
                System.out.println("Este número ya lo tiene otra cuenta, introduzca otro nuevo:");
                numerocuenta=sc.nextInt();
                break;
            }else{
                cuentasClientes.get(i).setNumeroCuenta(numerocuenta);
                cuentasClientes.add(new Cliente(nombre,apellido,direccion,nif,telefono,edad,0,numerocuenta));
                System.out.println("Su cuenta ha sido creada correctamente.");
                break;
            }
        }
    }
    
    /**
     * Método ingresarSaldo: llama al método de comprobarNumeroCuenta, introducimos bien el numero de cuenta, le introducimos
     * el dinero a ingresar. Dentro del for, llamamos al método ingresarSaldo, le metemos esa cantidad de dinero, y actualizamos
     * el saldo de esa cuenta.
     */
    public static void ingresarSaldo(){
        comprobarNumeroCuenta();
        System.out.println("Introduce la cantidad de dinero que quieres ingresar");
        double cantidad=sc.nextDouble();
        
          for (int i = 0; i < cuentasClientes.size(); i++) {
            if(numerocuenta == cuentasClientes.get(i).getNumeroCuenta()){
                cuentasClientes.get(i).ingresarSaldo(cantidad);
                System.out.println("Se ha ingresado el dinero en la cuenta");
                break;
            
            }
        }
    }
    
    /**
     * Método retirarSaldo: llama al método de comprobarNumeroCuenta, introducimos bien el numero de cuenta, le introducimos
     * el dinero que queremos retirar. Dentro del for, llamamos al método retirarSaldo, le metemos esa cantidad de dinero,
     * y actualizamos el saldo de esa cuenta.
     */
    public static void retirarSaldo(){
        comprobarNumeroCuenta();
        System.out.println("Introduce la cantidad de dinero que quieres retirar");
        double cantidad=sc.nextDouble();
        
            for (int i = 0; i < cuentasClientes.size(); i++) {
            if(numerocuenta == cuentasClientes.get(i).getNumeroCuenta()){
                cuentasClientes.get(i).retirarSaldo(cantidad);
                System.out.println("Se ha retirado el dinero de la cuenta");
                break;
            
            }
        }
        
    }
    
    /**
     * Método consultarSaldo: llama al método de comprobarNumeroCuenta, introducimos bien el numero de cuenta y dentro del for
     * llamará al método consultarSaldo, que nos mostrará el saldo de la cuenta elegido.
     */
    public static void consultarSaldo(){
        comprobarNumeroCuenta();
        
        for (int i = 0; i < cuentasClientes.size(); i++) {
            if(numerocuenta == cuentasClientes.get(i).getNumeroCuenta()){
                cuentasClientes.get(i).consultarSaldo();
                break;
            }
            
        }
    }
    
    /**
     * Método menuModificarDatos: cuando en el menú principal seleccionamos la opción 4, llamamos a este menú para ver los
     * datos que podemos modificar.
     */
    public static void menuModificarDatos(){
        System.out.println("1.Modificar nombre");
        System.out.println("2.Modificar apellido");
        System.out.println("3.Modificar dirección");
        System.out.println("4.Modificar teléfono");
        System.out.println("Selecciona una opcion");
        int opcion=sc.nextInt();
        
        switch(opcion){
            case 0:
                System.out.println("Has salido");
                break;
            case 1:
                modificarNombre();
                break;
            case 2:
                modificarApellido();
                break;
            case 3:
                modificarDireccion();
                break;
            case 4:
                modificarTelefono();
                break;
            default:
                System.out.println("Opción inválida");
        }
    }
    
    /**
     * Método modificarNombre: llamamos al método de combrobar numero de cuenta, introducimos el número de cuenta correctamente
     * y dentro del for llamamos al gestor que hemos definido como static, en mi caso ALberto, y este va a llamar a modificarNombre.
     * Le modifica el nombre y nos muestra mensaje de que lo ha realizado
     */
    public static void modificarNombre(){
        comprobarNumeroCuenta();
        for (int i = 0; i < cuentasClientes.size(); i++) {
            if(numerocuenta == cuentasClientes.get(i).getNumeroCuenta()){
                Alberto.modificarNombre(cuentasClientes.get(i));
                System.out.println("Nombre modificado correctamente");
                break;
            }
            
        }
    }
    
    /**
     * Método modificarApellido: llamamos al método de combrobar numero de cuenta, introducimos el número de cuenta correctamente
     * y dentro del for llamamos al gestor que hemos definido como static, en mi caso ALberto, y este va a llamar a modificarApellido.
     * Le modifica el apellido y nos muestra mensaje de que lo ha realizado
     */
    public static void modificarApellido(){
        comprobarNumeroCuenta();
         for (int i = 0; i < cuentasClientes.size(); i++) {
            if(numerocuenta == cuentasClientes.get(i).getNumeroCuenta()){
                Alberto.modificarApellido(cuentasClientes.get(i));
                System.out.println("Apellido modificado correctamente");
                break;
            }
            
        }

    }
    
    /**
     * Método modificarDireccion: llamamos al método de combrobar numero de cuenta, introducimos el número de cuenta correctamente
     * y dentro del for llamamos al gestor que hemos definido como static, en mi caso ALberto, y este va a llamar a modificarDireccion.
     * Le modifica la dirección y nos muestra mensaje de que lo ha realizado
     */
    public static void modificarDireccion(){
        comprobarNumeroCuenta();
         for (int i = 0; i < cuentasClientes.size(); i++) {
            if(numerocuenta == cuentasClientes.get(i).getNumeroCuenta()){
                Alberto.modificarDireccion(cuentasClientes.get(i));
                System.out.println("Dirección modificado correctamente");
                break; 
            }
        }
    }
    
    /**
     * Método modificarTelefono: llamamos al método de combrobar numero de cuenta, introducimos el número de cuenta correctamente
     * y dentro del for llamamos al gestor que hemos definido como static, en mi caso ALberto, y este va a llamar a modificarTelefono.
     * Le modifica el teléfono y nos muestra mensaje de que lo ha realizado
     */
    public static void modificarTelefono(){
        comprobarNumeroCuenta();
         for (int i = 0; i < cuentasClientes.size(); i++) {
            if(numerocuenta == cuentasClientes.get(i).getNumeroCuenta()){
                Alberto.modificarTelefono(cuentasClientes.get(i));
                System.out.println("Teléfono modificado correctamente");
                break;
            }
        }
    }
    
     
}
