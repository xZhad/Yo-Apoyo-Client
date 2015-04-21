package sarpi.temuco.yoapoyo.modelo;

public class singleIncidente {
	
	private boolean error;
	private singleIncidenteInner data;

	public singleIncidente() {}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public singleIncidenteInner getData() {
		return data;
	}

	public void setData(singleIncidenteInner data) {
		this.data = data;
	}

}
