package dao;

import modelo.Cliente;
import modelo.ClienteEspacial;
import modelo.Ingrediente;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


public class DaoClientes {

    public boolean addCliente(Cliente cliente) {
        return BD.clientes.put(cliente.getDni(), cliente) == null;
    }

    public boolean deleteCLiente(Cliente cliente) {
        return BD.clientes.remove(cliente.getDni()) == null;
    }

    public boolean existeCliente(Cliente c) {
        return BD.clientes.containsValue(c);
    }

    public boolean setNombreCliente(Cliente cliente, String nombre) {
        BD.clientes.get(cliente.getDni()).setNombre(nombre);
        return BD.clientes.get(cliente.getDni()) != null;
    }

    public String getNombreCliente(Cliente c) {
        return BD.clientes.get(c.getDni()).getNombre();
    }

    public List<Cliente> getClientList() {
        return BD.clientes.values().stream().
                map(Cliente::clonar).
                collect(Collectors.toUnmodifiableList());
    }

    public boolean anadirAlergeno(Ingrediente alergeno, Cliente cliente) {
        return BD.clientes.get(cliente.getDni()).getAlergenos().add(alergeno);
    }

    public boolean setDescuento(int porcentajeDescuento) {
        BD.clientes.values().forEach(cliente -> {
            if (cliente instanceof ClienteEspacial) {
                ((ClienteEspacial) cliente).setPorcentajeDescuento(porcentajeDescuento);
            }
        });
        return true;
    }

    public int getDescuento() {
        AtomicInteger descuento = new AtomicInteger(0);
        BD.clientes.values().forEach(cliente -> {
            if (cliente instanceof ClienteEspacial) {
                descuento.set(((ClienteEspacial) cliente).getPorcentajeDescuento());
            }
        });
        return descuento.get();
    }

}
