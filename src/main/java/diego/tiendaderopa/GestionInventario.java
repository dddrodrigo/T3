/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package diego.tiendaderopa;

/**
 *
 * @author diego
 */
public interface GestionInventario {
    void agregarProducto(Vendible producto);
    void mostrarProductos();
    void eliminarProducto(String nombre);
}
