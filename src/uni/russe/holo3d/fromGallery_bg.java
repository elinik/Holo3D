package uni.ruse.holo3d;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class fromGallery_bg extends Activity {
	private static int RESULT_LOAD_IMAGE = 1;
	ImageView topImage;
	ImageView leftImage;
	ImageView rightImage;
	ImageView bottomImage;
	int click = 0;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gallery_bg);

		Button btnLoadPicture = (Button) findViewById(R.id.button1);
		btnLoadPicture.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// Create intent to Open Image applications like Gallery
				Intent i = new Intent(
						Intent.ACTION_PICK,
						android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
				// Start the Intent
				startActivityForResult(
						Intent.createChooser(i, "Select Picture"), 1);
				click++;

			}

		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		// When an Image is picked
		if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK
				&& null != data) {
			// Get the Image from data
			Uri selectedImage = data.getData();
			String[] filePathColumn = { MediaStore.Images.Media.DATA };
			// Get the cursor
			Cursor cursor = getContentResolver().query(selectedImage,
					filePathColumn, null, null, null);
			// Move to first row
			cursor.moveToFirst();

			int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
			String picturePath = cursor.getString(columnIndex);
			cursor.close();

			// String picturePath contains the path of selected Image

			if (click == 1) {

				topImage = (ImageView) findViewById(R.id.image1);
				// Set the Image in ImageView after decoding the String
				topImage.setImageBitmap(BitmapFactory.decodeFile(picturePath));
			}
			if (click == 2) {
				leftImage = (ImageView) findViewById(R.id.image2);
				leftImage.setRotation(270);
				leftImage.setImageBitmap(BitmapFactory.decodeFile(picturePath));
			}

			if (click == 3) {
				rightImage = (ImageView) findViewById(R.id.image3);
				rightImage.setRotation(90);
				rightImage
						.setImageBitmap(BitmapFactory.decodeFile(picturePath));
			}
			if (click == 4) {
				bottomImage = (ImageView) findViewById(R.id.image4);
				bottomImage.setRotation(180);
				bottomImage.setImageBitmap(BitmapFactory
						.decodeFile(picturePath));
			}
		}
	}

}
