package ORM;
// Generated 8 nov. 2021 7:27:15 by Hibernate Tools 5.5.7.Final

import java.math.BigDecimal;

/**
 * Empleadodatosprof generated by hbm2java
 */
public class Empleadodatosprof implements java.io.Serializable {

	private String dni;
	private Empleado empleado;
	private String categoria;
	private BigDecimal sueldoBrutoAnual;

	public Empleadodatosprof() {
	}

	public Empleadodatosprof(Empleado empleado, String categoria) {
		this.empleado = empleado;
		this.categoria = categoria;
	}

	public Empleadodatosprof(Empleado empleado, String categoria, BigDecimal sueldoBrutoAnual) {
		this.empleado = empleado;
		this.categoria = categoria;
		this.sueldoBrutoAnual = sueldoBrutoAnual;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public String getCategoria() {
		return this.categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public BigDecimal getSueldoBrutoAnual() {
		return this.sueldoBrutoAnual;
	}

	public void setSueldoBrutoAnual(BigDecimal sueldoBrutoAnual) {
		this.sueldoBrutoAnual = sueldoBrutoAnual;
	}

}
