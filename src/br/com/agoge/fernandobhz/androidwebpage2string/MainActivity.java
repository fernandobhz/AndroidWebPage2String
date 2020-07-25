package br.com.agoge.fernandobhz.androidwebpage2string;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import android.os.Bundle;
import android.os.StrictMode;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy); 
		
		i=0;
		
		a();
		
		/*
		Button button= (Button) findViewById(R.id.button1);
		button.setOnClickListener(new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		        a();
		    }
		});
		*/
	}
	
	private Integer i;
	
	void a(){
		URL url;
		String body = "";
		
		try {
			url = new URL("http://www.google.com/");
			URLConnection con = url.openConnection();
			InputStream in = con.getInputStream();
			String encoding = con.getContentEncoding();
			encoding = encoding == null ? "UTF-8" : encoding;
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte[] buf = new byte[8192];
			int len = 0;
			while ((len = in.read(buf)) != -1) {
			    baos.write(buf, 0, len);
			}
			body = new String(baos.toByteArray(), encoding);
		} catch (Exception e) {
			body = e.toString();
		}
		
		
		body = i.toString() + ": " + body;
		
        TextView t1 = (TextView)findViewById(R.id.txt1);
        t1.setText(body);
        
        i = i + 1;
        
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	
}
