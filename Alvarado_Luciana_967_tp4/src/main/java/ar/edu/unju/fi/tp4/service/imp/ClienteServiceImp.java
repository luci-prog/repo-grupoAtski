/**
 * 
 */
package ar.edu.unju.fi.tp4.service.imp;

import java.time.LocalDate;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp4.model.Cliente;
import ar.edu.unju.fi.tp4.service.IClienteService;
import ar.edu.unju.fi.tp4.util.TableClientes;


/**
 * @author Luciana
 *
 */
@Service("clienteUtilService")
public class ClienteServiceImp implements IClienteService{

	private static final Log LOGGER= LogFactory.getLog(ClienteServiceImp.class);
	
	private List<Cliente> clientes;
	
	@Override
	public void generarTablaClientes() {
		this.clientes= TableClientes.registro; //se asigna a la variable clientes el registro asiciado a los atributos de la clase cliente
		clientes.add(new Cliente("dni",37890234,"aldo tara","34_er@gmail.com","tara",LocalDate.of(2000,3, 8),388,2347789,LocalDate.of(2019,6,4)));
	}
	
	@Override
	public void agregarCliente(Cliente cliente) {
		if(clientes == null) {
			generarTablaClientes();
		}
		//LOGGER.info("METHOD: agregarCliente() se verifico q la lista clientes no esta vacia";
		clientes.add(cliente);
	}
	

	@Override
	public List<Cliente> obtenerClientes() {
		return this.clientes;
	}

	
	

}
