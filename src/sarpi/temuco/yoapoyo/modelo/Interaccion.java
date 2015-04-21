package sarpi.temuco.yoapoyo.modelo;

public class Interaccion {
	private int id_interaccion;
	private String url_imagen;
	private String descripcion = null;
	private int solucionado;
	private String fecha = null;

	public Interaccion() {}

	public int getId_interaccion() {
		return id_interaccion;
	}

	public void setId_interaccion(int id_interaccion) {
		this.id_interaccion = id_interaccion;
	}

	public String getUrl_imagen() {
		return url_imagen;
	}

	public void setUrl_imagen(String url_imagen) {
		this.url_imagen = url_imagen;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getSolucionado() {
		return solucionado;
	}

	public void setSolucionado(int solucionado) {
		this.solucionado = solucionado;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

}
