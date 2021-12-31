package com.example.thinkanumber;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView kep1,kep2;
    private Button btn_1kocka,btn_2kocka,btn_dobas,btn_reset;
    private TextView txtV_eredmeny;
    private int kockaszama, elsoKockaErtek, masodikKockaErtek, eredmeny;
    private String dobas, eredmenyek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btn_1kocka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kep2.setVisibility(View.GONE);
                kockaszama=1;
            }
        });
        btn_2kocka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kep2.setVisibility(View.VISIBLE);
                kockaszama=2;
            }
        });
        btn_dobas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                elsoKockaErtek=(int) (Math.random()*6)+1;
                dobas = elsoKockaErtek+"";
                kepek(elsoKockaErtek,kep1);
                if (kockaszama ==1){
                    kepek(elsoKockaErtek,kep1);
                }else {
                    masodikKockaErtek=(int) (Math.random()*6)+1;
                    eredmeny=elsoKockaErtek+masodikKockaErtek;
                    kepek(elsoKockaErtek,kep1);
                    kepek(masodikKockaErtek,kep2);
                    dobas=eredmeny+" "+" ("+elsoKockaErtek+"+"+masodikKockaErtek+")";
                }
                Toast.makeText(getApplicationContext(),dobas,Toast.LENGTH_SHORT).show();
                eredmenyek=dobas+"\n"+eredmenyek;
                txtV_eredmeny.setText(eredmenyek);
            }
        });
        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();
            }
        });

    }
    private void kepek(int rnd, ImageView imageView){
        switch (rnd){
            case 1:
                imageView.setImageResource(R.drawable.kocka1);
            break;
            case 2:
                imageView.setImageResource(R.drawable.kocka2);
                break;
            case 3:
                imageView.setImageResource(R.drawable.kocka3);
                break;
            case 4:
                imageView.setImageResource(R.drawable.kocka4);
                break;
            case 5:
                imageView.setImageResource(R.drawable.kocka5);
                break;
            case 6:
                imageView.setImageResource(R.drawable.kocka6);
                break;
        }
    }
    private void reset(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Reset");
        builder.setMessage("Biztos, hogy töröni szeretné az eddigi dobásokat?");
        builder.setNegativeButton("Nem", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                closeContextMenu();
            }
        });
        builder.setPositiveButton("Igen", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                uj();
            }
        });
        builder.create().show();
    }
    private void uj(){
        eredmeny=0;
        kockaszama=0;
        elsoKockaErtek=0;
        masodikKockaErtek=0;
        txtV_eredmeny.setText("");
        eredmenyek="";
        dobas="";
        kep1.setImageResource(R.drawable.kocka1);
        kep2.setImageResource(R.drawable.kocka1);
        kep2.setVisibility(View.VISIBLE);
    }
    private void init(){
        kep1=findViewById(R.id.kep1);
        kep2=findViewById(R.id.kep2);
        btn_1kocka=findViewById(R.id.btn_1kocka);
        btn_2kocka=findViewById(R.id.btn_2kocka);
        btn_dobas=findViewById(R.id.btn_dobas);
        btn_reset=findViewById(R.id.btn_reset);
        txtV_eredmeny=findViewById(R.id.txtV_eredmeny);
    }
}