package com.sweta.androidimageviewer;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends Activity {
	private static final String IMAGE_URL = "http://www.fnordware.com/superpng/pnggrad16rgba.png";
	private ImageView imageView;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView)findViewById(R.id.imageView);
        loadImage(IMAGE_URL);
    }
    /**
     * This is a helper method to load an image from the given
     * URL
     * @param url
     */
    private void loadImage(String imageUrl) {
    	
    	Picasso.with(this)
    	.load(imageUrl)
    	//Placeholder image
    	.placeholder(R.drawable.ic_launcher)
    	//Display this image in case of error in downloading the image.
    	.error(R.drawable.error)
    	.into(imageView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
        case R.id.action_about:
        	showAboutDialog();
        	return true;
        case R.id.action_reload:
        	loadImage(IMAGE_URL);
        	return true;
        default:
        	return super.onOptionsItemSelected(item);
        }
    }
    /**
     * This is a helper method to display the About dialog.
     */
    private void showAboutDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.action_about);
        builder.setMessage(R.string.alert_about);
        builder.setPositiveButton(R.string.ok, null);
        builder.create().show();
    }
}
