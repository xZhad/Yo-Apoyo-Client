package sarpi.temuco.yoapoyo.modelo;

public class singleIncidenteInner {
	
	private IncidenteFull incidente[];
	private Interaccion interacciones[];

	public singleIncidenteInner() {}

	public IncidenteFull[] getIncidente() {
		return incidente;
	}

	public void setIncidente(IncidenteFull incidente[]) {
		this.incidente = incidente;
	}

	public Interaccion[] getInteracciones() {
		return interacciones;
	}

	public void setInteracciones(Interaccion interacciones[]) {
		this.interacciones = interacciones;
	}

}
