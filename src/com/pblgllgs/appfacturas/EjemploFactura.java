package com.pblgllgs.appfacturas;

import com.pblgllgs.appfacturas.models.Cliente;
import com.pblgllgs.appfacturas.models.Factura;
import com.pblgllgs.appfacturas.models.ItemFactura;
import com.pblgllgs.appfacturas.models.Producto;

import java.util.Scanner;

public class EjemploFactura {
    public static void main(String[] args) {

        Cliente cliente = new Cliente();
        cliente.setNif("5555-5");
        cliente.setNombre("Andres");

        Scanner scanner = new Scanner(System.in);
        System.out.println("ingrese la descripción de la factura");
        String desc = scanner.nextLine();
        Factura factura = new Factura(desc,cliente);

        Producto producto;
        String nombre;
        float precio;
        int cantidad;
        System.out.println();

        for (int i = 0;i<1;i++){
            producto = new Producto();
            System.out.print("ingresa el nombre del producto N°"+ producto.getCodigo()+": ");
            nombre = scanner.nextLine();
            producto.setNombre(nombre);
            System.out.print("ingresa el precio del producto: ");
            precio = scanner.nextFloat();
            producto.setPrecio(precio);
            System.out.print("ingresa la cantidad: ");
            cantidad = scanner.nextInt();
            ItemFactura item = new ItemFactura(cantidad,producto);
            factura.addItemFactura(item);
            System.out.println();
            scanner.nextLine();
        }

        System.out.println(factura.generarDetalle());

    }
}
