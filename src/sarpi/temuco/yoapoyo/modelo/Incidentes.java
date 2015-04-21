package sarpi.temuco.yoapoyo.modelo;

public class Incidentes {
	
	private boolean error;
	private Incidente data[];

	public Incidentes() {}

	public Incidente[] getData() {
		return data;
	}

	public void setData(Incidente data[]) {
		this.data = data;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

}
