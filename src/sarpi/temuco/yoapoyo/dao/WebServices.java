package sarpi.temuco.yoapoyo.dao;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.DefaultHttpClient;

import sarpi.temuco.yoapoyo.modelo.Incidentes;
import sarpi.temuco.yoapoyo.modelo.singleIncidente;
import sarpi.temuco.yoapoyo.obj.dataS;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.ImageView;

import com.google.gson.Gson;

public class WebServices {

	static Gson gson = new Gson();
	static String uri = "URL";
	static HttpClient client = new DefaultHttpClient();
	static HttpGet get;
	static HttpPost post;
	static HttpPut put;
	static HttpDelete delete;
	static HttpResponse response;
	static InputStream data = null;

	public static void loadImg(ImageView img, String link) {
		URL imageUrl = null;
		HttpURLConnection conn = null;
		try {
			imageUrl = new URL(uri+link);
			conn = (HttpURLConnection) imageUrl.openConnection();
			conn.connect();
			Bitmap imagen = BitmapFactory.decodeStream(conn.getInputStream());
			img.setImageBitmap(imagen);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void getIncidentes(int estado) {
		try {
			get = new HttpGet(uri+"api/v1/index.php/incidentes/"+estado);
			response = client.execute(get);
			data = response.getEntity().getContent();
			Reader r = new InputStreamReader(data);
			dataS.setIncidentes(gson.fromJson(r, Incidentes.class));
			Log.i("INCIDENTES", "Success");
		} catch (ClientProtocolException e) {
			Log.e("PRE INCIDENTES", "Error 1");
		} catch (IOException e) {
			Log.e("PRE INCIDENTES", "Error 2");
		} catch (Exception e) {
			Log.e("PRE INCIDENTES", "Error 3");
		}
	}

	public static void getIncidente(int id) {
		try {
			get = new HttpGet(uri+"api/v1/index.php/incidente/"+id);
			response = client.execute(get);
			data = response.getEntity().getContent();
			Reader r = new InputStreamReader(data);
			dataS.setSingleIncidente(gson.fromJson(r, singleIncidente.class));
			Log.i("INCIDENTE", "Success");
		} catch (ClientProtocolException e) {
			Log.e("PRE INCIDENTE", "Error 1");
		} catch (IOException e) {
			Log.e("PRE INCIDENTE", "Error 2");
		} catch (Exception e) {
			Log.e("PRE INCIDENTE", "Error 3");
		}
	}

}