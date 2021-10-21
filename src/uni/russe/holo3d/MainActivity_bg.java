package uni.ruse.holo3d;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity_bg extends Activity implements OnClickListener {

	private Button objectButton;
	private Button galleryButton;
	private Button templateButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main_bg);

		objectButton = (Button) findViewById(R.id.object);
		objectButton.setOnClickListener((OnClickListener) this);

		galleryButton = (Button) findViewById(R.id.gallery);
		galleryButton.setOnClickListener((OnClickListener) this);

		templateButton = (Button) findViewById(R.id.tr_pyramid);
		templateButton.setOnClickListener((OnClickListener) this);

	}

	public void onClick(View view) {

		if (view.equals(objectButton)) {
			Intent i = new Intent(this, Objects_bg.class);
			startActivity(i);
		}
		if (view.equals(galleryButton)) {
			Intent i = new Intent(this, fromGallery_bg.class);
			startActivity(i);
		}
		if (view.equals(templateButton)) {
			Intent i = new Intent(this, tr_pyramid_bg.class);
			startActivity(i);
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main_lang, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case R.id.en:
			// en
			Intent i = new Intent(this, MainActivity.class);
			startActivity(i);
			return true;
		case R.id.bg:
			// bg
			Intent in = new Intent(this, MainActivity_bg.class);
			startActivity(in);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

}
