package com.pblgllgs.appfacturas;

import com.pblgllgs.appfacturas.models.*;

import java.util.Scanner;

public class EjemploFactura {
    public static void main(String[] args) {

        Cliente cliente = new Cliente();
        cliente.setNif("5555-5");
        cliente.setNombre("Andres");

        Scanner scanner = new Scanner(System.in);
        System.out.println("ingrese la descripción de la factura");
        Factura factura = new Factura(scanner.nextLine(),cliente);

        Producto producto;

        System.out.println();

        for (int i = 0;i<1;i++){
            producto = new Producto();
            System.out.print("ingresa el nombre del producto N°"+ producto.getCodigo()+": ");
            producto.setNombre(scanner.nextLine());
            System.out.print("ingresa el precio del producto: ");
            producto.setPrecio(scanner.nextFloat());
            System.out.print("ingresa la cantidad: ");
            factura.addItemFactura(new ItemFactura(scanner.nextInt(),producto));
            System.out.println();
            scanner.nextLine();
        }

        System.out.println(factura);

    }
}
