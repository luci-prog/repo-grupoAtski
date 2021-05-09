/**
 * 
 */
package ar.edu.unju.fi.tp4.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp4.model.Producto;
import ar.edu.unju.fi.tp4.service.IProductoService;


/**
 * @author Luciana
 *
 */
@Controller
public class ProductoController {
	//CREAR UNA INSATNCIA DE LA INTERFACE
	@Autowired
	@Qualifier("productoUtilService")
	private IProductoService iProductoService;
	
	private static final Log LOGGER= LogFactory.getLog(ProductoController.class);
	
	
	//Accedemos A LA PAGINA DE HTML NUEVO
	/**
	 * accedemos al formulario de productos
	 * @param model
	 * @return
	 */
	@GetMapping("/producto")
	public String getProductoFormPage(Model model) {
		LOGGER.info("METHOD: getProductoFormPage()");
		model.addAttribute("producto",iProductoService.getProducto());
		LOGGER.info("RESULT:visualiza la pagina nuevo.html");
		return "nuevo";
	}
	
	//th:action no me funciono xq?
	//@ModelAttribute("producto") es el identificador para html en th:object="${producto}"
	@PostMapping("/producto/guardar")
	public String getProductoResultPage(@ModelAttribute("producto")Producto unProducto) {
		LOGGER.info("METHOD: getProductoResultPage()..Params: unProducto"+unProducto);
		
		iProductoService.addProducto(unProducto);
		LOGGER.info("RESULT:visualiza la pagina resultado.html si se agrego con exito ");
		return "resultado";
	}
	
	
	@GetMapping("/producto/ultimo")
	public ModelAndView getUltimoProductoPage() {
		LOGGER.info("METHOD:getUltimoProductoPage() ");
		ModelAndView model= new ModelAndView("ultimoproducto");//que es lo q hace?
		LOGGER.info("RESULT:se registro la pagina ultimoproducto.html en el param model  ");
		model.addObject("producto", iProductoService.getUltimoProducto());
		LOGGER.info("RESULT:se invoco a trvez de la interfaz el method getUltimoProducto() ");
		LOGGER.info("RESULT: Lo que es captado en model se visualiza en ultimoproducto.html");
		return model ;
	}

}
