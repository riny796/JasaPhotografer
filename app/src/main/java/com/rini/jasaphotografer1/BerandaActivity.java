package com.rini.jasaphotografer1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class BerandaActivity extends AppCompatActivity {

    ImageView weeding,birthday,studio,hunting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda);

        weeding=(ImageView) findViewById(R.id.iv_weeding);
        weeding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Anda Menekan Tombol Weeding", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(BerandaActivity.this, OrderActivity.class);
                startActivity(intent);
            }
        });

        birthday=(ImageView) findViewById(R.id.iv_birthday);
        birthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Anda Menekan Tombol Birthday", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(BerandaActivity.this, OrderActivity.class);
                startActivity(intent);
            }
        });

        studio=(ImageView) findViewById(R.id.iv_studio);
        studio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Anda Menekan Tombol Studio", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(BerandaActivity.this, OrderActivity.class);
                startActivity(intent);
            }
        });

        hunting=(ImageView) findViewById(R.id.iv_hunting);
        hunting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Anda Menekan Tombol Hunting", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(BerandaActivity.this, OrderActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu, menu);
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.history){
            startActivity(new Intent(this, HistoryActivity.class));
        } else if (item.getItemId() == R.id.Logout) {
            startActivity(new Intent(this, LogoutActivity.class));
        }

        return true;
    }
}

