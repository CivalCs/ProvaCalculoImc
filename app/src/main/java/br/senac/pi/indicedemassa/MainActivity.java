package br.senac.pi.indicedemassa;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        findViewById(R.id.Calc).setOnClickListener(calculoImc());
    }

    private View.OnClickListener calculoImc(){
        return new View.OnClickListener(){
            @Override
            public void onClick(View view){
                EditText peso = (EditText) findViewById(R.id.txtPeso);
                EditText altura = (EditText) findViewById(R.id.txtAltura);
                double qtdPeso = Double.parseDouble(peso.getText().toString());
                double tmAltura = Double.parseDouble(altura.getText().toString());
                double altAoQuadrado = tmAltura * tmAltura;
                double imc = qtdPeso / altAoQuadrado;

                if (imc < 18.5){
                    TextView txtResultado = (TextView) findViewById(R.id.txtResultado);
                    TextView txtComent = (TextView) findViewById(R.id.txtComent);
                    txtResultado.setText(getString(R.string.imc)+" "+imc);
                    txtComent.setText(getString(R.string.abaixo));
                }
                if (imc >= 18.6 && imc <= 24.9){
                    TextView txtResultado = (TextView) findViewById(R.id.txtResultado);
                    TextView txtComent = (TextView) findViewById(R.id.txtComent);
                    txtResultado.setText(getString(R.string.imc) + " " + imc);
                    txtComent.setText(getString(R.string.peso_ideal));
                }
                if (imc >= 25 && imc <= 29.9){
                    TextView txtResultado = (TextView) findViewById(R.id.txtResultado);
                    TextView txtComent = (TextView) findViewById(R.id.txtComent);
                    txtResultado.setText(getString(R.string.imc) + " " + imc);
                    txtComent.setText(getString(R.string.acima));
                }
                if (imc >= 30 && imc <= 34.9){
                    TextView txtResultado = (TextView) findViewById(R.id.txtResultado);
                    TextView txtComent = (TextView) findViewById(R.id.txtComent);
                    txtResultado.setText(getString(R.string.imc) + " " + imc);
                    txtComent.setText(getString(R.string.obesidade_i));
                }
                if (imc >= 35 && imc <= 39.9){
                    TextView txtResultado = (TextView) findViewById(R.id.txtResultado);
                    TextView txtComent = (TextView) findViewById(R.id.txtComent);
                    txtResultado.setText(getString(R.string.imc) + " " + imc);
                    txtComent.setText(getString(R.string.obesidade_ii));
                }
                if (imc >= 40){
                    TextView txtResultado = (TextView) findViewById(R.id.txtResultado);
                    TextView txtComent = (TextView) findViewById(R.id.txtComent);
                    txtResultado.setText(getString(R.string.imc) + " " + imc);
                    txtComent.setText(getString(R.string.obesidade_iii));
                }

            }
        };
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




