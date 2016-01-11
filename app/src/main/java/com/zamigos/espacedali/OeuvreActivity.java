package com.zamigos.espacedali;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class OeuvreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oeuvre);
        if(getIntent().getExtras()!=null) {
            // Recupération de l'idOeuvre
            // A envoyer au ChargmentOeuvre en fesant une sort de findByIdOeuvre
            // Méthode à créer
            int idOeuvre = getIntent().getExtras().getInt("idOeuvre");
        }
    }
}
