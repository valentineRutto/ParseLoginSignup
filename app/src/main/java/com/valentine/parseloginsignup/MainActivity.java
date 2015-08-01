package com.valentine.parseloginsignup;

import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.hs.image.ImageIntentHandler;
import com.hs.image.ImageUtils;

import java.io.File;
import java.io.OutputStream;
import android.widget.ImageButton;
import android.widget.Toolbar;


public class MainActivity extends ActionBarActivity {
ImageView mImageView;
    Button mButtonCapture;
    Button mButtonPick;
Button mButtonShare;
    Bitmap mBitmap;
    ImageIntentHandler.ImagePair mImagePair;
Toolbar toolbar;
    ImageButton FAB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView = (ImageView) findViewById(R.id.imageView);
        mButtonCapture = (Button) findViewById(R.id.button_capture);
        mButtonPick = (Button) findViewById(R.id.button_pick);
        mButtonShare = (Button) findViewById(R.id.button);
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
        mButtonShare.setOnClickListener(new View.OnClickListener()  {
            public void onClick(View v) {
                shareIt();
            }
        });

        toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FAB=(ImageButton) findViewById(R.id.imageButton);
        FAB.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"inTOUCH",Toast.LENGTH_SHORT);
            }
        });


    }



    private void shareIt() {
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        Bitmap icon = mBitmap;
        sharingIntent.setType("image/jpeg");

        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.TITLE, "title");
        values.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg");
        Uri uri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                values);
        OutputStream outstream;
        try {
            outstream = getContentResolver().openOutputStream(uri);
            icon.compress(Bitmap.CompressFormat.JPEG, 100, outstream);
            outstream.close();
        } catch (Exception e) {
            System.err.println(e.toString());
        }

        sharingIntent.putExtra(Intent.EXTRA_STREAM, uri);
        startActivity(Intent.createChooser(sharingIntent, "Share Image"));
        //sharingIntent.setType("image/jpeg");
        String shareBody = "caption";
        sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
        //startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ImageIntentHandler intentHandler = new ImageIntentHandler(MainActivity.this, mImagePair)
                .folder("inTOUCH")
                        .sizeDp(200);
        intentHandler.handleIntent(requestCode, resultCode, data);


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
