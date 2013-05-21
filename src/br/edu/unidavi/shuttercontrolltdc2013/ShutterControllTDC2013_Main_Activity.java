package br.edu.unidavi.shuttercontrolltdc2013;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import br.edu.unidavi.shuttercontrolltdc2013.R;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

public class ShutterControllTDC2013_Main_Activity extends Activity {

	private Button openShutterButton, closeShutterButton, openBladesButton,
			closeBladesButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_persiana_tdc2013_main);

		openShutterButton = (Button) findViewById(R.id.openShutterButton);
		closeShutterButton = (Button) findViewById(R.id.closeShutterButton);
		openBladesButton = (Button) findViewById(R.id.openBladesButton);
		closeBladesButton = (Button) findViewById(R.id.closeBladesButton);

		openBladesButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Thread t = new Thread() {
					public void run() {
						try {
							URL url = new URL("http://192.168.2.177/?rd=1");
							URLConnection conn = url.openConnection();
							BufferedReader rd = new BufferedReader(
									new InputStreamReader(conn.getInputStream()));

						} catch (Exception e) {
							Log.e("BUTTON BLADES OPEN", "ERRO");
							e.printStackTrace();
						}

					}
				};
				t.start();
			}
		});

		closeBladesButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Thread t = new Thread() {
					public void run() {
						try {
							URL url = new URL("http://192.168.2.177/?rd=2");
							URLConnection conn = url.openConnection();
							BufferedReader rd = new BufferedReader(
									new InputStreamReader(conn.getInputStream()));

						} catch (Exception e) {
							Log.e("BUTTON BLADES CLOSE", "ERRO");
							e.printStackTrace();
						}

					}
				};
				t.start();
			}
		});

		openShutterButton.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				Thread t = new Thread() {
					public void run() {
						try {
							URL url = new URL("http://192.168.2.177/?rd=4");
							URLConnection conn = url.openConnection();
							BufferedReader rd = new BufferedReader(
									new InputStreamReader(conn.getInputStream()));

						} catch (Exception e) {
							Log.e("BUTTON SHUTTER OPEN", "ERRO");
							e.printStackTrace();
						}

					}
				};
				t.start();
			}
		});

		closeShutterButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Thread t = new Thread() {
					public void run() {
						try {
							URL url = new URL("http://192.168.2.177/?rd=3");
							URLConnection conn = url.openConnection();
							
							BufferedReader rd = new BufferedReader(
									new InputStreamReader(conn.getInputStream()));

						} catch (Exception e) {
							Log.e("BUTTON SHUTTER CLOSE", "ERRO");
							e.printStackTrace();
						}

					}
				};
				t.start();
			}
		});

	}
}
