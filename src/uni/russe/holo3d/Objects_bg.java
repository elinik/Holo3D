package uni.ruse.holo3d;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Objects_bg extends Activity implements OnClickListener {

	private Button cubeButton;
	private Button coneButton;
	private Button cylinderButton;
	private Button sphereButton;
	private Button pyramidButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.object_bg);

		cubeButton = (Button) findViewById(R.id.cube);
		cubeButton.setOnClickListener((OnClickListener) this);

		coneButton = (Button) findViewById(R.id.cone);
		coneButton.setOnClickListener((OnClickListener) this);

		cylinderButton = (Button) findViewById(R.id.cylinder);
		cylinderButton.setOnClickListener((OnClickListener) this);

		sphereButton = (Button) findViewById(R.id.sphere);
		sphereButton.setOnClickListener((OnClickListener) this);

		pyramidButton = (Button) findViewById(R.id.pyramid);
		pyramidButton.setOnClickListener((OnClickListener) this);

	}

	public void onClick(View view) {

		if (view.equals(cubeButton)) {
			Intent i = new Intent(this, CubeEx_bg.class);
			startActivity(i);
		}
		if (view.equals(coneButton)) {
			Intent i = new Intent(this, ConeEx_bg.class);
			startActivity(i);
		}
		if (view.equals(cylinderButton)) {
			Intent i = new Intent(this, CylinderEx_bg.class);
			startActivity(i);
		}
		if (view.equals(sphereButton)) {
			Intent i = new Intent(this, SphereEx_bg.class);
			startActivity(i);
		}
		if (view.equals(pyramidButton)) {
			Intent i = new Intent(this, PyramidEx_bg.class);
			startActivity(i);
		}
	}

}
