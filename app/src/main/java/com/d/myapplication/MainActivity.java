package com.d.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private TextView tvContext;


    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvContext = findViewById(R.id.tvContext);

        registerForContextMenu(tvContext);

        toolbar = findViewById(R.id.toolbar);

        toolbar.setTitle("ABC");

        setSupportActionBar(toolbar);

        // hien thi nut back tren toolbar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.my_menu, menu);
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.menu_item:

                Toast.makeText(MainActivity.this,
                        "Item clicked",
                        Toast.LENGTH_SHORT).show();

                break;

        }

        return super.onContextItemSelected(item);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {


            case android.R.id.home:
                Toast.makeText(MainActivity.this,
                        "BACK clicked",
                        Toast.LENGTH_SHORT).show();
                break;

            case R.id.menu_item:

                Toast.makeText(MainActivity.this,
                        "Item clicked",
                        Toast.LENGTH_SHORT).show();

                break;

        }
        return super.onOptionsItemSelected(item);
    }

    public void openPopUpMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(MainActivity.this, tvContext);
        popupMenu.getMenuInflater().inflate(R.menu.my_menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {

                switch (menuItem.getItemId()) {

                    case R.id.menu_item:

                        Toast.makeText(MainActivity.this,
                                "Item clicked",
                                Toast.LENGTH_SHORT).show();

                        break;

                }


                return false;
            }
        });

        popupMenu.show();
    }
}
