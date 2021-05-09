/**
 * 
 */
package ar.edu.unju.fi.tp4.model;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

/**
 * @author Luciana
 *
 */
@Component("alumnoObj")
public class Cliente {

	private String tipoDocumento;
	private int nroDocumento;
	private String nombreApellido;
	private String email;
	private String password;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaNacimiento;
	//edad(int) se debe calcular en base a la fecha actual y la fecha de nacimiento
	private int codigoAreaTelefono;
	private int nroTelefono;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaUltimaCompra; 
	
	
	//CONSTRUCTOR SIN/CON PARAMETROS
	public Cliente() {
	}

	/**
	 * @param tipoDocumento Puede tomar alguno de estos valores: DNI, Pasaporte
	 * @param nroDocumento
	 * @param nombreApellido
	 * @param email correo electronico del cliente
	 * @param password contraseña
	 * @param fechaNacimiento 
	 * @param codigoAreaTelefono
	 * @param nroTelefono
	 * @param fechaUltimaCompra  representa la fecha de la última
	 *  compra que realizó el cliente, se ingresa desde el formulario
	 */
	public Cliente(String tipoDocumento, int nroDocumento, String nombreApellido, String email, String password,
			LocalDate fechaNacimiento, int codigoAreaTelefono, int nroTelefono, LocalDate fechaUltimaCompra) {
		super();
		this.tipoDocumento = tipoDocumento;
		this.nroDocumento = nroDocumento;
		this.nombreApellido = nombreApellido;
		this.email = email;
		this.password = password;
		this.fechaNacimiento = fechaNacimiento;
		this.codigoAreaTelefono = codigoAreaTelefono;
		this.nroTelefono = nroTelefono;
		this.fechaUltimaCompra = fechaUltimaCompra;
	}
	
	//GENERACION DE GETTER AND SETTER

	/**
	 * @return the tipoDocumento
	 */
	public String getTipoDocumento() {
		return tipoDocumento;
	}

	/**
	 * @param tipoDocumento the tipoDocumento to set
	 */
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	/**
	 * @return the nroDocumento
	 */
	public int getNroDocumento() {
		return nroDocumento;
	}

	/**
	 * @param nroDocumento the nroDocumento to set
	 */
	public void setNroDocumento(int nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	/**
	 * @return the nombreApellido
	 */
	public String getNombreApellido() {
		return nombreApellido;
	}

	/**
	 * @param nombreApellido the nombreApellido to set
	 */
	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the fechaNacimiento
	 */
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * @param fechaNacimiento the fechaNacimiento to set
	 */
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * @return the codigoAreaTelefono
	 */
	public int getCodigoAreaTelefono() {
		return codigoAreaTelefono;
	}

	/**
	 * @param codigoAreaTelefono the codigoAreaTelefono to set
	 */
	public void setCodigoAreaTelefono(int codigoAreaTelefono) {
		this.codigoAreaTelefono = codigoAreaTelefono;
	}

	/**
	 * @return the nroTelefono
	 */
	public int getNroTelefono() {
		return nroTelefono;
	}

	/**
	 * @param nroTelefono the nroTelefono to set
	 */
	public void setNroTelefono(int nroTelefono) {
		this.nroTelefono = nroTelefono;
	}

	/**
	 * @return the fechaUltimaCompra
	 */
	public LocalDate getFechaUltimaCompra() {
		return fechaUltimaCompra;
	}

	/**
	 * @param fechaUltimaCompra the fechaUltimaCompra to set
	 */
	public void setFechaUltimaCompra(LocalDate fechaUltimaCompra) {
		this.fechaUltimaCompra = fechaUltimaCompra;
	}

	
	
	//CALCULOS DE METODOS CONB FECHA
	/**
	 * calcula la edad q tengo en el tiempo actual
	 * @return
	 */
	public int getEdad() {
		int edad = 0;
		LocalDate hoy= LocalDate.now();
		Period periodo= Period.between(fechaNacimiento, hoy);
		edad = periodo.getYears();
		return edad;
	}
	
	/**
	 *  Tiempo transcurrido desde la fecha de la última compra a la fecha de hoy
	 *  expresado en Año-Mes-Día.
	 * @return una cadena concatenada
	 */
	
	public String fechaDesdeUltimaCompra() {
		String fecha="";
		LocalDate hoy= LocalDate.now();
		Period periodo= Period.between(this.fechaUltimaCompra, hoy);
		fecha = periodo.getYears()+"-"+periodo.getMonths()+"-"+periodo.getDays();
		
		return fecha;
	}
	
	/**
	 *  Tiempo transcurrido expresado en días desde la fecha de nacimiento
	 *  hasta la fecha actual.
	 * @return una cadena concatenada 
	 */
	
	public String tDesdeFechaNacimiento() {
		
		long dias = ChronoUnit.DAYS.between(fechaNacimiento, LocalDate.now());
		return"Dias transcurridos desde su fecha de cumpleaños "+ dias;
	}
	
	/**
	 *  Tiempo que falta para el próximo cumpleaños del cliente. Se quiere saber el
	 *  tiempo que expresado en Día-Mes-Año Hora-Min-Seg
	 * @return retorna una cadena concatenada
	 */
	
	
	public String calculoHastaProximoCumpleanos() {
		LocalDate fechaActual= LocalDate.now();
		LocalDate fechaProximoCumple =LocalDate.of(fechaActual.plusYears(1).getYear(), fechaNacimiento.getMonth(), fechaNacimiento.getDayOfMonth());
		
		Period p = Period.between(fechaActual, fechaProximoCumple);
		String respuesta= p.getYears()+"-"+p.getMonths()+"-"+p.getDays();
		
		LocalDateTime fechaTiempoProximoCumple = LocalDateTime.of(fechaProximoCumple,LocalTime.of(0, 0, 0));
		LocalDateTime fechaTiempoactual = LocalDateTime.of(fechaActual,LocalTime.of(0, 0, 0));
		Duration d =Duration.between(fechaTiempoactual, fechaTiempoProximoCumple);
		respuesta= respuesta + "/"+ d.toHours()+":"+d.toMinutesPart()+":"+ d.toSecondsPart();  
		return respuesta;
	}
	
	@Override
	public String toString() {
		return "Cliente [tipoDocumento=" + tipoDocumento + ", nroDocumento=" + nroDocumento + ", nombreApellido="
				+ nombreApellido + ", email=" + email + ", password=" + password + ", codigoAreaTelefono="
				+ codigoAreaTelefono + ", nroTelefono=" + nroTelefono + "]"
				+"edad"+ getEdad() +" fechaDesdeUltimaCompra() "+ fechaDesdeUltimaCompra()
				+" tDesdeFechaNacimiento() "+ tDesdeFechaNacimiento()
				+" calculoHastaProximoCumpleaños() "+ calculoHastaProximoCumpleanos();
	}

}
