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

public class Aktulanosci extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
        int[]listaZdjec={R.drawable.poz1,R.drawable.a1};
        String[]daty={"29.03.2018","22.03.2018"};
        String[]tytuly={"11. Grand Off Festiwal + Dyskusyjny Klub Filmowy","Pokaz specjalny filmu „Najlepszy” oraz spotkanie Dyskusyjnego Klubu Filmowego :)"};
        String[]opisy={"25.03 w Kinie RADOŚĆ odbył się 11.GRAND OFF FestiwalUczestnicy tego niespotykanego wydarzenia☕ mogli zobaczyć najlepsze Niezależne Krótkie Filmy Świata11.GRAND OFF ","19.03 odbył się specjalny pokaz filmu „Najlepszy”, który był połączony z Dyskusyjnym Klubem Filmowym. Pokaz zamknięty był zorganizowany dla naszej wolbromskiej grupy biegaczy"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aktulanosci);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
     //  tytulArtykul.findViewById(R.id.tytulArtyklu);

      // tytulArtykul.setText("");
        ListView listView=findViewById(R.id.aktulanosciLista);
        ListaAktulanosci listaAktulanosci=new ListaAktulanosci();
        listView.setAdapter(listaAktulanosci);


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
        getMenuInflater().inflate(R.menu.aktulanosci, menu);
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
            Intent newactive = new Intent(this.getBaseContext(), StronaStartowa.class);

            startActivity(newactive);

        } else if (id == R.id.galeria) {
            Intent newactive = new Intent(this.getBaseContext(), Galeria.class);

            startActivity(newactive);

        } else if (id == R.id.o_kinie) {
            Intent newactive = new Intent(this.getBaseContext(), OKinie.class);

            startActivity(newactive);

        } else if (id == R.id.oferta) {
            Intent newactive = new Intent(this.getBaseContext(), Oferta.class);

            startActivity(newactive);
        } else if (id == R.id.gramy) {
            Intent newactive = new Intent(this.getBaseContext(), CoGramy.class);

            startActivity(newactive);
        } else if (id == R.id.cennik) {
            Intent newactive = new Intent(this.getBaseContext(), Cennik.class);

            startActivity(newactive);

        } else if (id == R.id.repertuar) {
            Intent newactive = new Intent(this.getBaseContext(), Repertuar.class);

            startActivity(newactive);
        } else if (id == R.id.galeria) {
            Intent newactive = new Intent(this.getBaseContext(), StronaStartowa.class);

            startActivity(newactive);
        } else if (id == R.id.kontakt) {
            Intent newactive= new Intent(this.getBaseContext(),Kontakt.class);

            startActivity(newactive);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    class ListaAktulanosci extends BaseAdapter{
        @Override
        public int getCount() {
            return listaZdjec.length;
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
           view=getLayoutInflater().inflate(R.layout.listaaktulanosci,null);
           ImageView imageView=view.findViewById(R.id.aktlnosciZdjecie);
           TextView data=view.findViewById(R.id.aktulanosciData);
           TextView tytul=view.findViewById(R.id.aktulanosciTytul);
           TextView opis=view.findViewById(R.id.aktualnosciOpis);
           data.setText(daty[i]);
          tytul.setText(tytuly[i]);
           opis.setText(opisy[i]);
           imageView.setImageResource(listaZdjec[i]);
           return view;}

        @Nullable
        @Override
        public CharSequence[] getAutofillOptions() {
            return new CharSequence[0];
        }
    }
}

