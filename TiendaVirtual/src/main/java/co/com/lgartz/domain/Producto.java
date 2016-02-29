package co.com.lgartz.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tv_producto")
@NamedQueries({ @NamedQuery(name = "Producto.findAll", query = "select p from Producto p"),
		@NamedQuery(name = "Producto.findById", query = "select p from Producto p where p.idProducto = :idProducto"),
		@NamedQuery(name = "Producto.findByNombre", query = "select p from Producto p where p.nombre like '%:nombre%'"),
		@NamedQuery(name = "Producto.findByPrecio", query = "select p from Producto p where p.precio between :inicio and :fin") })
public class Producto implements Serializable {

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Atributo que representa el identificador del producto
	 */
	@Id
	@Column(name = "producto_id", length = 15, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idProducto;

	/**
	 * Atributo que representa el nombre del producto
	 */
	@Column(name = "producto_nombre", length = 200, nullable = false)
	private String nombre;

	/**
	 * Atributo que representa el precio del producto
	 */
	@Column(name = "producto_precio", nullable = false)
	private double precio;

	/**
	 * Atributo que representa los detalles del producto
	 */
	@Column(name = "producto_detalle", length = 1000, nullable = false)
	private String detalle;
	
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="producto_categoria_id")
	private Categoria categoria;

	/**
	 * Metodo Contructor
	 */
	public Producto() {
	}

	/**
	 * Metodo Contructor
	 * 
	 * @param nombre,
	 *            parametro que representa el nombre del producto
	 * @param precio,
	 *            parametro que representa el precio del producto
	 * @param detalle,
	 *            parametro que representa el detalle del producto
	 */
	public Producto(String nombre, double precio, String detalle) {
		this.nombre = nombre;
		this.precio = precio;
		this.detalle = detalle;
	}

	/**
	 * Metodo encargado de obtener el valor del atributo idProducto
	 * 
	 * @return el valor del atributo idProducto
	 */
	public int getIdProducto() {
		return idProducto;
	}

	/**
	 * Metodo encargado de asignar el valor al atributo idProducto
	 * 
	 * @param idProducto
	 *            valor de parametro que modifica el valor del atributo
	 *            idProducto
	 */
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	/**
	 * Metodo encargado de obtener el valor del atributo nombre
	 * 
	 * @return el valor del atributo nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo encargado de asignar el valor al atributo nombre
	 * 
	 * @param nombre
	 *            valor de parametro que modifica el valor del atributo nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo encargado de obtener el valor del atributo precio
	 * 
	 * @return el valor del atributo precio
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * Metodo encargado de asignar el valor al atributo precio
	 * 
	 * @param precio
	 *            valor de parametro que modifica el valor del atributo precio
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * Metodo encargado de obtener el valor del atributo detalle
	 * 
	 * @return el valor del atributo detalle
	 */
	public String getDetalle() {
		return detalle;
	}

	/**
	 * Metodo encargado de asignar el valor al atributo detalle
	 * 
	 * @param detalle
	 *            valor de parametro que modifica el valor del atributo detalle
	 */
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	/**
	 * Metodo encargado de obtener el valor del atributo categoria
	 * @return el valor del atributo categoria
	 */
	public Categoria getCategoria() {
		return categoria;
	}

	/**
	 * Metodo encargado de asignar el valor al atributo categoria
	 * @param categoria valor de parametro que modifica el valor del atributo categoria
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}