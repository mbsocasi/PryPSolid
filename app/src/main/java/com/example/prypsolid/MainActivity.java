package com.example.prypsolid;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    //decralar losobjetos graficos

    EditText txtUsuario;

    EditText txtContrasenia;

    Button btnLogin;

    private String user="admin";
    private String pass="Doris";

    @SuppressLint("MissingInflatedId")


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //mapeo

        txtUsuario = findViewById(R.id.et_user);
        txtContrasenia = findViewById(R.id.et_pass);
        btnLogin = findViewById(R.id.tn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario, contrasenia;

                usuario = txtUsuario.getText().toString();
                contrasenia= txtContrasenia.getText().toString();

                if(usuario.length()!=0){
                    if (usuario.equals(user)){
                        if(contrasenia.equals(pass)){
                            Toast.makeText(getApplicationContext(), "Datos Correctos",Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(getApplicationContext(), index.class);
                            startActivity(intent);

                        } else {
                            Toast.makeText(MainActivity.this, "Pass incorrect", Toast.LENGTH_LONG).show();
                        }
                    }
                }else {
                    Toast.makeText(MainActivity.this, "Llene todos los campos", Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}