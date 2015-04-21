package sarpi.temuco.yoapoyo.modelo;

public class Incidente {
	private int id_incidente;
	private int categoria;
	private String descripcion = null;
	private int apoyo;

	public Incidente() {}

	public Incidente(int id_incidente, int categoria, String descripcion, int apoyo) {
		setId_incidente(id_incidente);
		setCategoria(categoria);
		setDescripcion(descripcion);
		setApoyo(apoyo);
	}

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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getApoyo() {
		return apoyo;
	}

	public void setApoyo(int apoyo) {
		this.apoyo = apoyo;
	}

}
