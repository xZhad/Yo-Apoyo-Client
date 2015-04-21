package sarpi.temuco.yoapoyo.obj;

import sarpi.temuco.yoapoyo.modelo.Incidentes;
import sarpi.temuco.yoapoyo.modelo.singleIncidente;
import android.content.Context;

public class dataS {

	// Data
	private static Incidentes incidentes;
	private static singleIncidente singleIncidente;

	/**
	* Inicializar Variables.
	* @param context a usar para cargar informaci?n.
	* @return void.
	*/
	public static void loadData(Context context) {
		
	}


	// Getters & Setters

	public static Incidentes getIncidentes() {
		return incidentes;
	}

	public static void setIncidentes(Incidentes incidentes) {
		dataS.incidentes = incidentes;
	}


	public static singleIncidente getSingleIncidente() {
		return singleIncidente;
	}


	public static void setSingleIncidente(singleIncidente singleIncidente) {
		dataS.singleIncidente = singleIncidente;
	}

}
