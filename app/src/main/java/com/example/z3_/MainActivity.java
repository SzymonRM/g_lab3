package com.example.z3_;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import com.example.z3_.ui.login.LoginActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.provider.MediaStore;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {onFab(view);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.action_settings:
                Toast.makeText(getApplicationContext(), "action_settings",  Toast.LENGTH_SHORT).show();
                Intent inte = new  Intent(this, LoginActivity.class);
                startActivity(inte);
                break;
            case R.id.action_about:
                Toast.makeText(getApplicationContext(),"action_about",  Toast.LENGTH_SHORT).show();
                Intent inte2 = new  Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(inte2, REQUEST_IMAGE_CAPTURE);
                break;
            case R.id.action_exit:
                Toast.makeText(getApplicationContext(),"action_exit",  Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onFab(View v)
    {
        Toast.makeText(getApplicationContext(), "Kliknięto przycisk FAB", Toast.LENGTH_SHORT).show();
    }

    public void onButton(View v)
    {
        Toast.makeText(getApplicationContext(),"Kliknięto przycisk button",  Toast.LENGTH_SHORT).show();

        Random r = new Random();
        int number = r.nextInt() % 2;

        Button b = findViewById(R.id.button);
        ;
        if(number == 0)
        {
            b.setBackground(ContextCompat.getDrawable(this, android.R.drawable.ic_dialog_map));
        }
        else if(number == 1)
        {
            b.setBackground(ContextCompat.getDrawable(this, R.drawable.sketchpad));
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        //if (requestCode == ) {
            if (resultCode == RESULT_OK)
            {
                Bundle b = data.getExtras();
                Bitmap image = (Bitmap)b.get("data");
                ConstraintLayout l = (ConstraintLayout) findViewById(R.id.cont);
                l.setBackground(new BitmapDrawable(getResources(), image));
            }
        //}
    }
}
