package com.marlonortiz.villavicencio;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter<String> adaptador;
    ListView listnav;

    private layout_item[] datos =
            new layout_item[] {
                    new layout_item(R.drawable.turismo, ""),
                    new layout_item(R.drawable.hotel,""),
                    new layout_item(R.drawable.coctel,""),
                    new layout_item(R.drawable.information,"")
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Adapter adaptador = new Adapter(this, datos);

        listnav = (ListView) findViewById(R.id.list);
        listnav.setAdapter(adaptador);


        String[] nombre = getResources().getStringArray(R.array.menu); // nombre carga el nombre del archivo strings.xml correspondiente

        datos[0].setAccion(nombre[0]); //Asigna de acuerdo al idioma del cel. los nombres para los items del listview
        datos[1].setAccion(nombre[1]);
        datos[2].setAccion(nombre[2]);
        datos[3].setAccion(nombre[3]);

        listnav.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String selection = ((layout_item) parent.getItemAtPosition(position)).getAccion();
                Toast.makeText(MainActivity.this, selection, Toast.LENGTH_SHORT).show();

                switch ((int) id) {
                    case 0:
                        Intent i0 = new Intent(MainActivity.this, TourismActivity.class);
                        startActivity(i0);
                        break;
                    case 1:
                        Intent i1 = new Intent(MainActivity.this, HotelActivity.class);
                        startActivity(i1);
                        break;
                    case 2:
                        Intent i2 = new Intent(MainActivity.this, BarActivity.class);
                        startActivity(i2);
                        break;
                    case 3:
                        Intent i3 = new Intent(MainActivity.this, InfoActivity.class);
                        startActivity(i3);
                        break;
                    default:
                        break;
                }
            }
        });


    }


    public class Adapter extends ArrayAdapter<layout_item> {

        public Adapter(Context context, layout_item[] datos) {
            super(context, R.layout.activity_layout_item, datos);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.activity_layout_item, null);

            ImageView image = (ImageView) item.findViewById(R.id.image);
            image.setImageResource(datos[position].getIdImage());

            TextView nombre = (TextView) item.findViewById(R.id.accion);
            nombre.setText(datos[position].getAccion());

            return item;
        }
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
        if (id == R.id.action_setting) {

            // Toast.makeText(this, "MENU ACTIVADO", Toast.LENGTH_SHORT).show();

            Intent i=new Intent (this,Activity_about.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
