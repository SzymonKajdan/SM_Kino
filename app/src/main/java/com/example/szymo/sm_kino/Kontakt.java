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

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Kontakt extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, OnMapReadyCallback {
    GoogleMap mgoogleMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kontakt);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        wlaczmapy();
    }
    private  void wlaczmapy(){
        MapFragment mapFragment= (MapFragment) getFragmentManager().findFragmentById(R.id.fragment);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mgoogleMap=googleMap;
        idzdoLokaizacji(50.378000, 19.759715,15);
    }
    private void idzdoLokaizacji(double width,double heigth,float zoom){
        LatLng ll=new LatLng(width,heigth);
        mgoogleMap.addMarker( new MarkerOptions().position(ll).title("Kino"));
        CameraUpdate update= CameraUpdateFactory.newLatLngZoom(ll,zoom);
        mgoogleMap.moveCamera(update);

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

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
        getMenuInflater().inflate(R.menu.kontakt, menu);
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

        else if(id==R.id.galeria){
            Intent newactive= new Intent(this.getBaseContext(),Galeria.class);

            startActivity(newactive);}

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
