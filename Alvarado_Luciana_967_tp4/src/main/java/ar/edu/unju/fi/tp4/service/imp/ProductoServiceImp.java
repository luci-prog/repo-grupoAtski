/**
 * 
 */
package ar.edu.unju.fi.tp4.service.imp;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp4.model.Producto;
import ar.edu.unju.fi.tp4.service.IProductoService;
import ar.edu.unju.fi.tp4.util.TableProductos;



/**
 * @author Luciana
 *
 */
@Service("productoUtilService")
public class ProductoServiceImp implements IProductoService {

	@Autowired
	private Producto producto;
	
	private List<Producto> productos;
	
	
	
    @Override
	public void generarTablaProductos() {
		this.productos= TableProductos.productos; //se asigna a la variable productos a el productos asiciado a los atributos de la clase Producto
		
	}
	
	/**
	 * Se agrega a la lista los datos de un producto
	 */
	@Override
	public void addProducto(Producto producto) {
		
		if(productos == null) {
			generarTablaProductos();
		}
		
		this.productos.add(producto);//productos es 
	}
	
	
    /**
     * devuelve el ultimo de la lista
     */
	@Override
	public Producto getUltimoProducto() {
		int indiceUltimoProducto = productos.size() - 1;//me devuelve la posicion del ultimo en la lista
		Producto producto = productos.get(indiceUltimoProducto);
		
		return producto;
	}

	//para acceder a empleado lo accedo por la capa de servicio
	//a Producto deveria recuperarlo
	//me permite retornas producto inyectado en el service
	@Override
	public Producto getProducto() {
		
		return this.producto;
	}

}
