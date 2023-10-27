/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package diego.tiendaderopa;

/**
 *
 * @author diego
 */
public class Pantalon extends Producto {
    private int talla;

    public Pantalon(String nombre, double precio, int talla) {
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
