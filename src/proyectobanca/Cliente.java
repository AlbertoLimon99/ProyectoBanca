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
public class Cliente {
    private String nombre;
    private String apellido;
    private String direccion;
    private String nif;
    private int telefono;
    private int edad;
    private int saldo;
    private int numeroCuenta;
    static Scanner sc = new Scanner(System.in);
    
    public Cliente(String nom, String ap, String dir, String nif, int tel, int e, int s, int numC){
        this.nombre=nom;
        this.apellido=ap;
        this.direccion=dir;
        this.nif=nif;
        this.telefono=tel;
        this.edad=e;
        this.saldo=s;
        this.numeroCuenta=numC;
    }
    
    /**
     * Método consultarSaldo: muestra el saldo de una cuenta.
     */
    public void consultarSaldo(){
        System.out.println("El saldo de la cuenta es de: "+this.getSaldo()+" euros.");
    }
    
    /**
     * Método retirarSaldo: le introducimos una cantidad de dinero que vamos a retirar. Si esta cantidad es mayor que el saldo
     * de la cuenta, nos da error. Si es menor, se le quita ese cantidad al saldo de la cuenta.
     * @param cantidad 
     */
    public void retirarSaldo(double cantidad){
        if(cantidad>this.saldo){
            System.out.println("Operación fallido, no hay suficiente dinero en la cuenta");
        }else{
        this.saldo-=cantidad;
            System.out.println("Operación válida. El saldo final de la cuenta es de "+this.saldo+" euros.");
        }
    }
    
    /**
     * Método ingresarSaldo: le introducimos una cantidad de dinero que vamos a ingresar. 
     * Después, se lo sumamos al saldo de la cuenta,
     * @param cantidad 
     */
    public void ingresarSaldo(double cantidad){
        this.saldo+=cantidad;
        System.out.println("El saldo actual de la cuenta es de "+this.saldo);
    }
    
    public void saldoMedio(){
        
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the nif
     */
    public String getNif() {
        return nif;
    }

    /**
     * @param nif the nif to set
     */
    public void setNif(String nif) {
        this.nif = nif;
    }

    /**
     * @return the telefono
     */
    public int getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }
       /**
     * @return the saldo
     */
    public int getSaldo() {
        return saldo;
    }
    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    /**
     * @return the numeroCuenta
     */
    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    /**
     * @param numeroCuenta the numeroCuenta to set
     */
    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + ", nif=" + nif + ", telefono=" + telefono + ", edad=" + edad + ", saldo=" + saldo + ", numeroCuenta=" + numeroCuenta + '}';
    }
    
}
