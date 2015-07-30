package com.valentine.parseloginsignup;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.hs.image.ImageIntentHandler;
import com.hs.image.ImageUtils;

import java.io.File;


public class MainActivity extends ActionBarActivity {
ImageView mImageView;
    Button mButtonCapture;
    Button mButtonPick;

    ImageIntentHandler.ImagePair mImagePair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView = (ImageView) findViewById(R.id.imageView);
        mButtonCapture = (Button) findViewById(R.id.button_capture);
        mButtonPick = (Button) findViewById(R.id.button_pick);
        mButtonCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File f = ImageUtils.createImageFile(ImageUtils.getPackageName(MainActivity.this));
                if ((f != null) && f.exists()) {
                    mImagePair = new ImageIntentHandler.ImagePair(mImageView, f.getAbsolutePath());
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
                    startActivityForResult(takePictureIntent, ImageIntentHandler.REQUEST_CAPTURE);
                } else {
                    Toast.makeText(MainActivity.this, "Storage Error", Toast.LENGTH_LONG).show();
                }
            }
        });
        mButtonPick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mImagePair = new ImageIntentHandler.ImagePair(mImageView, null);
                Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, ImageIntentHandler.REQUEST_GALLERY);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
