/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package diego.tiendaderopa;

/**
 *
 * @author diego
 */
public class Camisa extends Producto {
    private String talla;

    public Camisa(String nombre, double precio, String talla) {
        super(nombre, precio);
        this.talla = talla;
    }

    public String getDescripcion() {
        return nombre + " (Talla: " + talla + ")";
    }

    public double getPrecio() {
        return precio; 
    }
}

