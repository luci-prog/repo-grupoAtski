/**
 * 
 */
package ar.edu.unju.fi.tp4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Luciana
 *
 */
@Controller
public class IndexController {
	
	@GetMapping("/index")
	public String getNuevoClientePage() {
		return("principal");
	}

}
