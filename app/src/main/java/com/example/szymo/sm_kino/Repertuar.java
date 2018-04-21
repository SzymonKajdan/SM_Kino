package com.example.szymo.sm_kino;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Repertuar extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
        int[] plakaty1={R.drawable.poz6,R.drawable.poz6,R.drawable.poz6,R.drawable.poz4,R.drawable.poz2,R.drawable.poz5,R.drawable.poz3,R.drawable.poz1};
        String []sala1={"Kameralna","Kameralna","Widowiskowa","Kameralna","Widowiskowa","Kameralna","Kameralna","Widowiskowa"};
        String []godzina1={"10:00","14:00","16:00","16:15","18:00","18:15","20:00","20:15"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repertuar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView repertuar=findViewById(R.id.repertuar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ListaFilmow listaFilmow= new ListaFilmow();
        repertuar.setAdapter(listaFilmow);

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
        getMenuInflater().inflate(R.menu.repertuar, menu);
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

        } else if (id == R.id.aktualnosci) {
            Intent newactive =new Intent(this.getBaseContext(),Aktulanosci.class);
            startActivity(newactive);

        }
        else if (id == R.id.oferta) {
            Intent newactive= new Intent(this.getBaseContext(),Oferta.class);

            startActivity(newactive);
        }
        else if (id == R.id.gramy) {
            Intent newactive= new Intent(this.getBaseContext(),CoGramy.class);

            startActivity(newactive);
        }
        else if (id == R.id.cennik) {
            Intent newactive = new Intent(this.getBaseContext(), Cennik.class);

            startActivity(newactive);
        }
        else if (id == R.id.galeria) {

        }


        else if(id==R.id.kontakt){
            Intent newactive= new Intent(this.getBaseContext(),Kontakt.class);

            startActivity(newactive);
        }
        else if(id==R.id.o_kinie) {

            Intent newactive= new Intent(this.getBaseContext(),OKinie.class);

            startActivity(newactive);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    class ListaFilmow extends BaseAdapter{

        @Override
        public int getCount() {
            return plakaty1.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view=getLayoutInflater().inflate(R.layout.listafilmow,null);
            ImageView plakaty=view.findViewById(R.id.plakaty);
            TextView  sala=view.findViewById(R.id.sala);
            TextView godizna=view.findViewById(R.id.godzina);
            plakaty.setImageResource(plakaty1[i]);
            sala.setText(sala1[i]);
            godizna.setText(godzina1[i]);
            return view;
        }

        @Nullable
        @Override
        public CharSequence[] getAutofillOptions() {
            return new CharSequence[0];
        }
    }
}
