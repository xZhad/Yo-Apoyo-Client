package sarpi.temuco.yoapoyo;

import sarpi.temuco.yoapoyo.dao.WebServices;
import sarpi.temuco.yoapoyo.obj.dataS;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class IncidenteActivity extends Activity {

	public static FrameLayout working;
	public static Context context;
	LayoutInflater inflater;
	LinearLayout content;
	TextView categoria;
	TextView descripcion;
	ImageView ico;
	TextView fecha;
	TextView estado;
	ImageView imagen;
	TextView apoyo;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.singleincident);
		context = this;
		working = (FrameLayout) findViewById(R.id.IncidentWorking);
		content = (LinearLayout) findViewById(R.id.IncidenteContent);
		inflater = LayoutInflater.from(IncidenteActivity.context);
		ico = (ImageView) findViewById(R.id.IncidenteIco);
		categoria = (TextView) findViewById(R.id.IncidenteCategoria);
		descripcion = (TextView) findViewById(R.id.IncidenteDescripcion);
		fecha = (TextView) findViewById(R.id.IncidenteFecha);
		estado = (TextView) findViewById(R.id.IncidenteEstado);
		imagen = (ImageView) findViewById(R.id.IncidenteImagen);
		apoyo = (TextView) findViewById(R.id.IncidenteApoyo);
	}

	@Override
	protected void onResume() {
		super.onResume();
		switch(dataS.getSingleIncidente().getData().getIncidente()[0].getCategoria()) {
		    case 1:
		    	ico.setImageResource(R.drawable.congestion);
		    	categoria.setText("Incidente en calzada");
		        break;
		    case 2:
		    	ico.setImageResource(R.drawable.walk);
		    	categoria.setText("Incidente en acera");
		        break;
		    case 3:
		    	ico.setImageResource(R.drawable.lightbulb);
		    	categoria.setText("Incidente en alumbrado público");
		        break;
		    case 4:
		    	ico.setImageResource(R.drawable.delete);
		    	categoria.setText("Basura acumulada");
		        break;
		    case 5:
		    	ico.setImageResource(R.drawable.billboard);
		    	categoria.setText("Publicidad peligrosa");
		        break;
		    default:
		    	ico.setImageResource(R.drawable.places);
		    	categoria.setText("Otros");
		        break;
		}
		apoyo.setText(""+dataS.getSingleIncidente().getData().getIncidente()[0].getApoyo());
		descripcion.setText(dataS.getSingleIncidente().getData().getIncidente()[0].getDescripcion());
		fecha.setText(dataS.getSingleIncidente().getData().getIncidente()[0].getFecha_publicacion());
		
		if (dataS.getSingleIncidente().getData().getIncidente()[0].getEstado() == 1)
			estado.setText("Pendiente");
		else
			estado.setText("Terminado");
		
		if (dataS.getSingleIncidente().getData().getIncidente()[0].getUrl_imagen() != null)
			WebServices.loadImg(imagen, dataS.getSingleIncidente().getData().getIncidente()[0].getUrl_imagen());
		
		for(int i = 0; i < dataS.getSingleIncidente().getData().getInteracciones().length; i ++) {
			View vista = inflater.inflate(R.layout.interacciones, null);

			ImageView interImagen = (ImageView) vista.findViewById(R.id.InteraccionesImagen);
			TextView descripcion = (TextView) vista.findViewById(R.id.InteraccionesDescripcion);

			if(dataS.getSingleIncidente().getData().getInteracciones()[i].getUrl_imagen() != null)
				WebServices.loadImg(interImagen, dataS.getSingleIncidente().getData().getInteracciones()[i].getUrl_imagen());
			descripcion.setText(dataS.getSingleIncidente().getData().getInteracciones()[i].getDescripcion());

			content.addView(vista);
		}
	}

}
