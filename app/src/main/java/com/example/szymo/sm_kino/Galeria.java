package com.example.szymo.sm_kino;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class Galeria extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    //galeria
    Integer[] obrazzki= new Integer[7];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galeria);

        for(int i =0 ; i<obrazzki.length;i++){
            obrazzki[i]=getResources().getIdentifier("f"+i,"drawable",getPackageName());
        }
        GridView tablicaObrazow=findViewById(R.id.gridView);
        tablicaObrazow.setAdapter(new ImageAdapter());
        tablicaObrazow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if(position==0)
                Toast.makeText(getBaseContext(),"Pierwszy pokaz.Obrazek nr  "+(position+1),Toast.LENGTH_SHORT).show();
            }
        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.galeria, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.strona_glowna) {
            Intent newactive= new Intent(this.getBaseContext(),StronaStartowa.class);

            startActivity(newactive);

        } else if (id == R.id.o_kinie) {
            Intent newactive= new Intent(this.getBaseContext(),OKinie.class);

            startActivity(newactive);
        } else if (id == R.id.oferta) {
            Intent newactive= new Intent(this.getBaseContext(),Oferta.class);

            startActivity(newactive);

        } else if (id == R.id.gramy) {
            Intent newactive= new Intent(this.getBaseContext(),CoGramy.class);

            startActivity(newactive);
        } else if (id == R.id.cennik) {         Intent newactive = new Intent(this.getBaseContext(), Cennik.class);

            startActivity(newactive);

        } else if (id == R.id.aktualnosci) {

            Intent newactive= new Intent(this.getBaseContext(),Aktulanosci.class);

            startActivity(newactive);
        }
        else if(id==R.id.repertuar){
            Intent newactive= new Intent(this.getBaseContext(),Repertuar.class);

            startActivity(newactive);
        }

        else if(id==R.id.kontakt){
            Intent newactive= new Intent(this.getBaseContext(),Kontakt.class);

            startActivity(newactive);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public  class ImageAdapter extends BaseAdapter{
        @Override
        public int getCount(){
            return obrazzki.length;

        }
        @Override
        public Object getItem(int position){
            return obrazzki[position];
        }
        @Override
        public long getItemId(int position){
            return position;
        }
        public View getView(int position, View convertView, ViewGroup parent){
            ImageView imageView;
            if(convertView==null){
                imageView=new ImageView((getBaseContext()));
                imageView.setLayoutParams(new GridView.LayoutParams(400,400));
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                imageView.setPadding(10,10,10,10);
            }
            else{
                imageView=(ImageView)convertView;
            }
            imageView.setImageResource(obrazzki[position]);
            return imageView;
        }
    }
}

