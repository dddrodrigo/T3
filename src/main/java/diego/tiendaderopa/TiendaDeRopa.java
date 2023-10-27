/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package diego.tiendaderopa;

/**
 *
 * @author diego
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TiendaDeRopa extends JFrame {
    private ArrayList<Vendible> productos = new ArrayList<>();

    public TiendaDeRopa() {
        setTitle("Tienda de Ropa");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(new FlowLayout());

        JButton agregarCamisaButton = new JButton("Agregar Camisa");
        JButton agregarPantalonButton = new JButton("Agregar Pantalón");
        JButton mostrarProductosButton = new JButton("Mostrar Productos");
        JButton eliminarPrendaButton = new JButton("Eliminar Prenda");

        agregarCamisaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombreCamisa = JOptionPane.showInputDialog("Nombre de la camisa:");
                double precioCamisa = Double.parseDouble(JOptionPane.showInputDialog("Precio de la camisa:"));
                String tallaCamisa = JOptionPane.showInputDialog("Talla de la camisa:");

                Camisa camisa = new Camisa(nombreCamisa, precioCamisa, tallaCamisa);
                agregarProducto(camisa);
                JOptionPane.showMessageDialog(null, "Camisa agregada a la tienda.");
            }
        });

        agregarPantalonButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombrePantalon = JOptionPane.showInputDialog("Nombre del pantalón:");
                double precioPantalon = Double.parseDouble(JOptionPane.showInputDialog("Precio del pantalón:"));
                int tallaPantalon = Integer.parseInt(JOptionPane.showInputDialog("Talla del pantalón:"));

                Pantalon pantalon = new Pantalon(nombrePantalon, precioPantalon, tallaPantalon);
                agregarProducto(pantalon);
                JOptionPane.showMessageDialog(null, "Pantalón agregado a la tienda.");
            }
        });

        mostrarProductosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarProductos();
            }
        });

        eliminarPrendaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminarProducto();
            }
        });

        panel.add(agregarCamisaButton);
        panel.add(agregarPantalonButton);
        panel.add(mostrarProductosButton);
        panel.add(eliminarPrendaButton);
    }

    private void agregarProducto(Vendible producto) {
        productos.add(producto);
    }

    private void mostrarProductos() {
        if (productos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay productos en la tienda.");
        } else {
            StringBuilder mensaje = new StringBuilder("Productos en la tienda:\n");
            for (Vendible producto : productos) {
                mensaje.append(producto.getDescripcion()).append(" - Precio: $").append(producto.getPrecio()).append("\n");
            }
            JOptionPane.showMessageDialog(null, mensaje.toString());
        }
    }

    private void eliminarProducto() {
        if (productos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay productos para eliminar.");
        } else {
            String input = JOptionPane.showInputDialog("Ingrese el nombre de la prenda a eliminar:");
            boolean eliminada = false;
            for (Vendible producto : productos) {
                if (producto instanceof Producto) {
                    Producto prenda = (Producto) producto;
                    if (prenda.getNombre().equalsIgnoreCase(input)) {
                        productos.remove(producto);
                        eliminada = true;
                        break;
                    }
                }
            }

            if (eliminada) {
                JOptionPane.showMessageDialog(null, "Prenda eliminada con éxito.");
            } else {
                JOptionPane.showMessageDialog(null, "La prenda no se encontró en el inventario.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TiendaDeRopa tienda = new TiendaDeRopa();
            tienda.setVisible(true);
        });
    }
}