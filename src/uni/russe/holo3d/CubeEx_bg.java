package uni.ruse.holo3d;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class CubeEx_bg extends Activity {
	GLSurfaceView view;
	GLSurfaceView viewR;
	GLSurfaceView viewG;
	GLSurfaceView viewB;
	GLSurfaceView viewC;
	GLSurfaceView viewM;
	GLSurfaceView viewY;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		view = new GLSurfaceView(this);
		view.setRenderer(new OpenGLRendererCube());

		viewR = new GLSurfaceView(this);
		viewR.setRenderer(new OpenGLRendererCubeRed());

		viewG = new GLSurfaceView(this);
		viewG.setRenderer(new OpenGLRendererCubeGreen());

		viewB = new GLSurfaceView(this);
		viewB.setRenderer(new OpenGLRendererCubeBlue());

		viewC = new GLSurfaceView(this);
		viewC.setRenderer(new OpenGLRendererCubeCyan());

		viewM = new GLSurfaceView(this);
		viewM.setRenderer(new OpenGLRendererCubeMagenta());

		viewY = new GLSurfaceView(this);
		viewY.setRenderer(new OpenGLRendererCubeYellow());

		setContentView(view);

	}

	@Override
	protected void onPause() {
		super.onPause();
		view.onPause();
		viewR.onPause();
		viewG.onPause();
		viewB.onPause();
		viewC.onPause();
		viewM.onPause();
		viewY.onPause();
	}

	@Override
	protected void onResume() {
		super.onResume();
		view.onResume();
		viewR.onResume();
		viewG.onResume();
		viewB.onResume();
		viewC.onResume();
		viewM.onResume();
		viewY.onResume();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case R.id.color:
			showDialogColor();
			return true;
		case R.id.object:
			Intent i = new Intent(this, Objects_bg.class);
			startActivity(i);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	private void showDialogColor() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		final CharSequence[] choiceList = { "Бял", "Червен", "Зелен", "Син",
				"Циан", "Магента", "Жълт" };

		int selected = -1;

		builder.setTitle("Избери цвят");
		builder.setSingleChoiceItems(choiceList, selected,
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						String color = choiceList[which].toString();

						if (choiceList[which] == choiceList[0]) {
							setContentView(view);
							Toast.makeText(getApplicationContext(),
									"Избран " + color, Toast.LENGTH_SHORT)
									.show();
						}
						if (choiceList[which] == choiceList[1]) {

							setContentView(viewR);
							Toast.makeText(getApplicationContext(),
									"Избран " + color, Toast.LENGTH_SHORT)
									.show();

						}
						if (choiceList[which] == choiceList[2]) {
							setContentView(viewG);
							Toast.makeText(getApplicationContext(),
									"Избран " + color, Toast.LENGTH_SHORT)
									.show();
						}
						if (choiceList[which] == choiceList[3]) {
							setContentView(viewB);
							Toast.makeText(getApplicationContext(),
									"Избран " + color, Toast.LENGTH_SHORT)
									.show();
						}
						if (choiceList[which] == choiceList[4]) {
							setContentView(viewC);
							Toast.makeText(getApplicationContext(),
									"Избран " + color, Toast.LENGTH_SHORT)
									.show();
						}
						if (choiceList[which] == choiceList[5]) {
							setContentView(viewM);
							Toast.makeText(getApplicationContext(),
									"Избран " + color, Toast.LENGTH_SHORT)
									.show();
						}
						if (choiceList[which] == choiceList[6]) {
							setContentView(viewY);
							Toast.makeText(getApplicationContext(),
									"Избран " + color, Toast.LENGTH_SHORT)
									.show();
						}
						dialog.dismiss();// Dismiss this dialog, removing it
						// from the screen.
					}

				});

		AlertDialog alert = builder.create();
		alert.show();

	}

}
