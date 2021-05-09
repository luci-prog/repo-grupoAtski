/**
 * 
 */
package ar.edu.unju.fi.tp4.service;

import java.util.List;

import ar.edu.unju.fi.tp4.model.Cliente;


/**
 * @author Luciana
 *
 */
public interface IClienteService {
	
	public void generarTablaClientes();
	public void agregarCliente(Cliente cliente);
	public List<Cliente> obtenerClientes();

}
