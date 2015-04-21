package sarpi.temuco.yoapoyo.modelo;

public class IncidenteFull {
	private int id_incidente;
	private int categoria;
	private String url_imagen = null;
	private String descripcion = null;
	private int estado;
	private String geopos = null;
	private String fecha_publicacion = null;
	private String fecha_resolucion = null;
	private int apoyo;

	public IncidenteFull() {}

	public int getId_incidente() {
		return id_incidente;
	}

	public void setId_incidente(int id_incidente) {
		this.id_incidente = id_incidente;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
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

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getGeopos() {
		return geopos;
	}

	public void setGeopos(String geopos) {
		this.geopos = geopos;
	}

	public String getFecha_publicacion() {
		return fecha_publicacion;
	}

	public void setFecha_publicacion(String fecha_publicacion) {
		this.fecha_publicacion = fecha_publicacion;
	}

	public String getFecha_resolucion() {
		return fecha_resolucion;
	}

	public void setFecha_resolucion(String fecha_resolucion) {
		this.fecha_resolucion = fecha_resolucion;
	}

	public int getApoyo() {
		return apoyo;
	}

	public void setApoyo(int apoyo) {
		this.apoyo = apoyo;
	}

}
