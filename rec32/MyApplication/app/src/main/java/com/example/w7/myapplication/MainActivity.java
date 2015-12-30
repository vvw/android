package com.example.w7.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //java.io.File f = getFilesDir();
                //String dir = getApplicationContext().getFilesDir().getAbsolutePath();
                String dir = "/data/data/com.example.w7.myapplication";
                String fname = dir + "/0.bmp";
                Log.d ("###################", fname);
                java.io.File file = new java.io.File(fname);
                if (file.exists()) {
                    Log.d ("###################", "exists: " + fname);
                    android.graphics.Bitmap bm = android.graphics.BitmapFactory.decodeFile(fname);
                    int w = bm.getWidth();
                    int h = bm.getHeight();
                    Log.d ("###################", "width,htight=" + w + "," + h);
                    //将图片显示到ImageView中
                    //img.setImageBitmap(bm);
                } else {
                    Log.d ("###################", "not exists: " + fname);
                }
                // Context.getExternalFilesDir();
                NdkJniUtils jni = new NdkJniUtils();
                //String s =  jni.getCLanguageString();
                String s =  jni.reconize(fname);


                Snackbar.make(view, "$Replace with your own action#" + s.length(), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Log.d("###################", s);
                //s.length();
                try
                {
                    java.io.FileWriter writer=new java.io.FileWriter(dir + "/0.txt");
                    writer.write(s);
                    writer.close();
                    Log.d("###################", "write json success.");
                } catch (java.io.IOException e) {
                    e.printStackTrace();
                }
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
