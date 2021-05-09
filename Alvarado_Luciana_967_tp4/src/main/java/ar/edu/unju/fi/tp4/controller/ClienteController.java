/**
 * 
 */
package ar.edu.unju.fi.tp4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp4.model.Cliente;
import ar.edu.unju.fi.tp4.service.IClienteService;



/**
 * @author Luciana
 *
 */
@Controller
public class ClienteController {
	
	@Autowired
	private Cliente cliente;
	@Autowired
	@Qualifier("clienteUtilService")
	private IClienteService clienteService;
	
	@GetMapping("/cliente/nuevo")
	public String getNuevoClientePage(Model model) {
		model.addAttribute("cliente",cliente);
		return("nuevocliente");
	}
	
	@PostMapping("/cliente/guardar")
	public ModelAndView GuardarCliente(@ModelAttribute("cliente") Cliente cliente) {//viene de la vista
		ModelAndView model = new ModelAndView("clientes");//se pone la pagina html q se va a ver   //a donde la enviamos
		clienteService.agregarCliente(cliente);           //los atributos de la vista del objeto cliente se aplica la logica del metodo agregarCliente a travexz de la capa service               
		model.addObject("clientesd", clienteService.obtenerClientes());      //se obtiene el resultado
	    return model;
	}
	@GetMapping("/cliente/listado")
	public ModelAndView getClientesPage() {//viene de la vista
		ModelAndView model = new ModelAndView("clientes");//se pone la pagina html q se va a ver   //a donde la enviamos
		if(clienteService.obtenerClientes() == null) {
			clienteService.generarTablaClientes();
		}
		model.addObject("clientesd", clienteService.obtenerClientes());      //se obtiene el resultado
	    return model;
	}

}
