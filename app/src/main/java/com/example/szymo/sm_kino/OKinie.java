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

import org.w3c.dom.Text;

public class OKinie extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    int[]zdjecia={R.drawable.o1,R.drawable.o2};
    String[] opis={"Kino „Radość” rozpoczęło działalność w roku 1979 i funkcjonuje przy Domu Kultury w Wolbromiu nieprzerwanie do dziś.\n" +
            "\n" +
            "Kino dysponuje dwiema salami kinowymi: Widowiskową i Kameralną, wyposażonymi w nowoczesny sprzęt projekcyjny i nagłośnieniowy oraz komfortowe fotele.\n" +
            "\n" +
            "W 2012 roku, dzięki kolejnym dotacjom z Polskiego Instytutu Sztuki Filmowej, rozpoczął się proces cyfryzacji i kompleksowej odnowy Kina.\n" +
            "\n" +
            "Modernizację zainicjowała wymiana sprzętu nagłośnieniowego w jedynej wówczas sali – Widowiskowej, na nowoczesne DOLBY DIGITAL SURROUND 5.1. Kabina projekcyjna została wyremontowana i przygotowana do wymogów projekcji cyfrowych. Kasa biletowa zyskała nowoczesny charakter dzięki przebudowie i wprowadzeniu elektronicznego systemu sprzedaży biletów z możliwością zakupu online.","Pełna cyfryzacja Kina „Radość” nastąpiła w 2013 roku wraz z instalacją w Sali Widowiskowej nowoczesnego sprzętu projekcyjnego firmy SONY, umożliwiającego wyświetlanie filmów w formatach 2D i 3D oraz rozdzielczości 4K. Projekcją inaugurującą kino cyfrowe w Wolbromiu był seans filmu „Skyfall” 5 kwietnia 2013r.; tego samego dnia odbyła się także pierwsza projekcja 3D.\n" +
            "\n" +
            "W kolejnych etapach modernizacji wykonano nowe oświetlenie Sali Widowiskowej, wyremontowano rozdzielnię główną oraz wymieniono stare, wysłużone fotele na nowoczesne i komfortowe.\n" +
            "\n" +
            "Druga sala kinowa – Kameralna została otwarta 27 stycznia 2017 roku. Jako pierwszy wyświetlono w niej film „Ostatnia rodzina”. W dniu inauguracji nowej sali gościł w niej Prezydent RP Andrzej Duda wraz z Małżonką, który składał wizytę w Wolbromiu.\n" +
            "Sala Kameralna, podobnie jak Widowiskowa wyposażona jest w projektor cyfrowy SONY o rozdzielczości 4K, nagłośnienie DOLBY DIGITAL SURROUND 5.1. i komfortowe fotele.\n" +
            "\n" +
            "Kino „Radość” należy do Polskiej Sieci Kin Cyfrowych oraz Sieci Kin Studyjnych i Lokalnych."};
    TextView w;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okinie);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ListaOpis listaOpis=new ListaOpis();
        ListView listView=findViewById(R.id.historiakina);
        listView.setAdapter(listaOpis);
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
        getMenuInflater().inflate(R.menu.okinie, menu);
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
        else if (id == R.id.cennik) {         Intent newactive = new Intent(this.getBaseContext(), Cennik.class);

            startActivity(newactive);

        }
        else if (id == R.id.galeria) {

            Intent newactive= new Intent(this.getBaseContext(),Galeria.class);

            startActivity(newactive);
        }


        else if(id==R.id.kontakt){
            Intent newactive= new Intent(this.getBaseContext(),Kontakt.class);

            startActivity(newactive);
        }
        else if(id==R.id.repertuar){
            Intent newactive= new Intent(this.getBaseContext(),Repertuar.class);

            startActivity(newactive);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    class ListaOpis extends BaseAdapter{

        @Override
        public int getCount() {
            return zdjecia.length;
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
            view=getLayoutInflater().inflate(R.layout.kino,null);
            ImageView imageView=view.findViewById(R.id.obrazekKino);
            TextView textView=view.findViewById(R.id.historiaOpis);
            imageView.setImageResource(zdjecia[i]);
            textView.setText(opis[i]);
            return view;
        }

        @Nullable
        @Override
        public CharSequence[] getAutofillOptions() {
            return new CharSequence[0];
        }
    }
}
