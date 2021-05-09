/**
 * 
 */
package ar.edu.unju.fi.tp4.service;

import ar.edu.unju.fi.tp4.model.Producto;

/**
 * @author Luciana
 *
 */
public interface IProductoService {
	
	public void generarTablaProductos();
	public Producto getProducto();
	public void addProducto(Producto producto);
	public Producto getUltimoProducto();

}
