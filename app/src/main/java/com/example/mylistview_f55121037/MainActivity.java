package com.example.mylistview_f55121037;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String[] datadescription;
    private TypedArray dataPhoto;
    private HeroAdapter adapter;
    private ArrayList<Hero> heroes;
    private String[] dataName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new HeroAdapter(this);
        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);
        prepare();
        addItem();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, heroes.get(i).getName(), Toast.LENGTH_SHORT).show();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int Position, long id) {
                if(Position==0){
                    startActivity(new Intent(MainActivity.this, DetailActivity_f55121037.class));
                }
                else if(Position==1){
                    startActivity(new Intent(MainActivity.this, Ahmaddahlan.class));
                }
                else if(Position==2){
                    startActivity(new Intent(MainActivity.this, Ahmadyani.class));
                }
                else if(Position==3){
                    startActivity(new Intent(MainActivity.this, Sutomo.class));
                }
                else if(Position==4){
                    startActivity(new Intent(MainActivity.this, GatotSoebroto.class));
                }
                else if(Position==5){
                    startActivity(new Intent(MainActivity.this, KiHadjarDewantara.class));
                }
                else if(Position==6){
                    startActivity(new Intent(MainActivity.this, MohammadHatta.class));
                }
                else if(Position==7){
                    startActivity(new Intent(MainActivity.this, Soedirman.class));
                }
                else if(Position==8){
                    startActivity(new Intent(MainActivity.this, Soekarno.class));
                }
                else if(Position==9){
                    startActivity(new Intent(MainActivity.this, Soepomo.class));
                }
                else if(Position==10){
                    startActivity(new Intent(MainActivity.this, TanMalaka.class));
                }
            }
        });

    }

    private void prepare() {
        dataName = getResources().getStringArray(R.array.data_name);
        datadescription = getResources().getStringArray(R.array.data_description);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
    }
    private void addItem() {
        heroes = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Hero hero = new Hero ();
            hero.setPhoto(dataPhoto.getResourceId(i, -1));
            hero.setName(dataName[i]);
            hero.setDescription(datadescription[i]);
            heroes.add(hero);
        }
        adapter.setHeroes(heroes);
    }
}