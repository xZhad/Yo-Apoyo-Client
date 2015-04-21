package sarpi.temuco.yoapoyo;

import sarpi.temuco.yoapoyo.dao.WebServices;
import sarpi.temuco.yoapoyo.obj.dataS;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	public static FrameLayout working;
	public static Context context;
	LayoutInflater inflater;
	LinearLayout content;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		context = this;
		working = (FrameLayout) findViewById(R.id.MainWorking);
		content = (LinearLayout) findViewById(R.id.MainContent);
		inflater = LayoutInflater.from(MainActivity.context);
	}

	@Override
	protected void onResume() {
		super.onResume();
		working.setVisibility(View.VISIBLE);
		WebServices.getIncidentes(1);
		working.setVisibility(View.GONE);
		
		if(dataS.getIncidentes().isError()) {
			Toast.makeText(this,
					"Error al obtener los incidentes! :(",
					Toast.LENGTH_SHORT).show();
		} else {
			for(int i = 0; i < dataS.getIncidentes().getData().length; i ++) {
				View vista = inflater.inflate(R.layout.incidentes, null);

				ImageView ico = (ImageView) vista.findViewById(R.id.IncidentesIco);
				TextView categoria = (TextView) vista.findViewById(R.id.IncidentesCategoria);
				TextView descripcion = (TextView) vista.findViewById(R.id.IncidentesDescripcion);
				LinearLayout click = (LinearLayout) vista.findViewById(R.id.IncidentesClick);

				switch(dataS.getIncidentes().getData()[i].getCategoria()) {
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
				descripcion.setText(dataS.getIncidentes().getData()[i].getDescripcion());
				click.setTag(""+dataS.getIncidentes().getData()[i].getId_incidente());

				content.addView(vista);
			}
		}
	}
	
	public void goTo(View v) {
		int id = Integer.parseInt(v.getTag().toString());
		working.setVisibility(View.VISIBLE);
		WebServices.getIncidente(id);
		working.setVisibility(View.GONE);
		Intent incidenteIntent = new Intent(MainActivity.this, IncidenteActivity.class);
		MainActivity.this.startActivity(incidenteIntent);
	}

}
