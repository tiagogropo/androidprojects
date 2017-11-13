package com.example.aluno_gti_ads.idioma;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.aluno_gti_ads.idioma.dao.TarefaDAO;
import com.example.aluno_gti_ads.idioma.model.Tarefas;

import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    long userID;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        String user = pref.getString("user", "User");
        userID = pref.getLong("usuID", 0);


        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent goToTarefas = new Intent(MainActivity.this, CadastroTarefa.class);
                goToTarefas.putExtra("usuID", userID);
                startActivity(goToTarefas);
                finish();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Magica para mudar o textview do header do drawer
        View header = ((NavigationView) findViewById(R.id.nav_view)).getHeaderView(0);
        TextView text = (TextView) header.findViewById(R.id.txtMenuUsuario);
        text.setText(" " + user);


        //CARREGAMENTO DA LISTA
        TarefaDAO tarefaDao = new TarefaDAO(this);
        List<Tarefas> tarefas = tarefaDao.buscaTarefa(userID);
        tarefaDao.close();

        ListView listaTarefas = (ListView) findViewById(R.id.lstClientes);
        ArrayAdapter<Tarefas> adapter = new ArrayAdapter<Tarefas>(this, android.R.layout.simple_list_item_1, tarefas);
        listaTarefas.setAdapter(adapter);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            final SharedPreferences.Editor editor = pref.edit();
            editor.putString("user", ""); // Storing string
            editor.putString("senha", ""); // Storing string
            editor.putLong("usuID", 0); // Storing string
            editor.commit();
            Intent goToLogin = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(goToLogin);
            finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

        if (id == R.id.nav_camera) {

            Intent goToTarefas = new Intent(MainActivity.this, CadastroTarefa.class);
            goToTarefas.putExtra("usuID", userID);
            startActivity(goToTarefas);
        } else if (id == R.id.nav_gallery) {


        } else if (id == R.id.nav_slideshow) {

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("APP de gerenciamento de salão de beleza criado por:\n\nAndrew\nEllen\nTiago")
                    .setTitle("Sobre!?");
            // Add the buttons
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {

                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();


        } else if (id == R.id.nav_manage) {
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
