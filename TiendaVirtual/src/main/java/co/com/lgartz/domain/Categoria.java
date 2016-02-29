package co.com.lgartz.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pa_categoria")
public class Categoria implements Serializable {

	/**
	 * Constante que representa el serial version
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Atributo que representa el identificador del producto
	 */
	@Id
	@Column(name = "categoria_id", length = 5, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idCategoria;

	@Column(name = "categoria_nombre", length = 50, nullable = false)
	private String nombre;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "categoria_sub_categoria")
	private Categoria categoria;

	@OneToMany(mappedBy = "categoria", cascade = { CascadeType.ALL })
	private List<Categoria> subCategorias;
	
	@OneToMany(mappedBy = "categoria", cascade = { CascadeType.ALL })
	private List<Producto> productos;

	public Categoria() {
	}
	
	public Categoria(int idCategoria, String nombre, Categoria categoria) {
		this.idCategoria = idCategoria;
		this.nombre = nombre;
		this.categoria = categoria;
	}

	/**
	 * Metodo encargado de obtener el valor del atributo idCategoria
	 * 
	 * @return el valor del atributo idCategoria
	 */
	public int getIdCategoria() {
		return idCategoria;
	}

	/**
	 * Metodo encargado de asignar el valor al atributo idCategoria
	 * 
	 * @param idCategoria
	 *            valor de parametro que modifica el valor del atributo
	 *            idCategoria
	 */
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
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
	 * Metodo encargado de obtener el valor del atributo categoria
	 * 
	 * @return el valor del atributo categoria
	 */
	public Categoria getCategoria() {
		return categoria;
	}

	/**
	 * Metodo encargado de asignar el valor al atributo categoria
	 * 
	 * @param categoria
	 *            valor de parametro que modifica el valor del atributo
	 *            categoria
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	/**
	 * Metodo encargado de obtener el valor del atributo subCategorias
	 * 
	 * @return el valor del atributo subCategorias
	 */
	public List<Categoria> getSubCategorias() {
		return subCategorias;
	}

	/**
	 * Metodo encargado de asignar el valor al atributo subCategorias
	 * 
	 * @param subCategorias
	 *            valor de parametro que modifica el valor del atributo
	 *            subCategorias
	 */
	public void setSubCategorias(List<Categoria> subCategorias) {
		this.subCategorias = subCategorias;
	}

	/**
	 * Metodo encargado de obtener el valor del atributo productos
	 * @return el valor del atributo productos
	 */
	public List<Producto> getProductos() {
		return productos;
	}

	/**
	 * Metodo encargado de asignar el valor al atributo productos
	 * @param productos valor de parametro que modifica el valor del atributo productos
	 */
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	/**
	 * Metodo encargado de agregar categorias
	 * 
	 * @param categoria,
	 *            categoria a agregar
	 * @return la categoria agregada
	 */
	public Categoria addCategoria(Categoria categoria) {
		getSubCategorias().add(categoria);
		categoria.setCategoria(this);

		return categoria;
	}

	/**
	 * Metodo encargado de eliminar la categoria
	 * 
	 * @param categoria,
	 *            categoria a eliminar
	 * @return categoria eliminada
	 */
	public Categoria removeCategoria(Categoria categoria) {
		getSubCategorias().remove(categoria);
		categoria.setCategoria(null);
		return categoria;
	}

}
