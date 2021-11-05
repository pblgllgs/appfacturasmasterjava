package com.pblgllgs.appfacturas.models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Factura {

    private int folio;
    private String descripcion;
    private Date fecha;
    private Cliente cliente;
    private ItemFactura[] items;
    public static final int MAX_ITEMS =12;
    private static int ultimoFolio;

    public Factura(String descripcion, Cliente cliente) {
        this.descripcion = descripcion;
        this.cliente = cliente;
        this.items = new ItemFactura[MAX_ITEMS];
        this.folio= ++ultimoFolio;
        this.fecha = new Date();
    }

    private int indiceItems;

    public ItemFactura[] getItems() {
        return items;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getFolio() {
        return folio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void addItemFactura(ItemFactura itemFactura){
        if(indiceItems <MAX_ITEMS){
            this.items[indiceItems++] = itemFactura;
        }
    }

    public float calcularTotal(){
        float total = 0.0f;
        for (ItemFactura item:this.items) {
            if(item == null){
                continue;
            }
            total += item.calcularImporte();
        }
        return total;
    }

    public String generarDetalle(){
        StringBuilder stringBuilder = new StringBuilder("Factura N°: ");
        stringBuilder.append(folio)
                .append("\nCliente: ")
                .append(this.cliente.getNombre())
                .append("\t NIF: ")
                .append(this.cliente.getNif())
                .append("\nDescripción: ")
                .append(this.descripcion)
                .append("\n");
        SimpleDateFormat df = new SimpleDateFormat("dd 'de' MMMM, yyyy");
        stringBuilder.append("Fecha emición: ")
                .append(df.format(this.fecha))
                .append("\n")
                .append("\n#\tNombre\t$\tCant.\tTotal\n");

        for (ItemFactura item: items) {
            if(item == null){
                continue;
            }
            stringBuilder.append(item.getProducto().getCodigo())
                    .append("\t")
                    .append(item.getProducto().getNombre())
                    .append("\t")
                    .append(item.getProducto().getPrecio())
                    .append("\t")
                    .append(item.getCantidad())
                    .append("\t")
                    .append(item.calcularImporte())
                    .append("\n");

        }

        stringBuilder.append("\nGran total: ")
                .append(calcularTotal());

        return stringBuilder.toString();
    }
}
