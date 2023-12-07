package com.example.conectamovilb.Vista;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.conectamovilb.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private EditText editTextCorreo;
    private EditText editTextContraseña;
    private Button btnLogin;
    private Button btnRegister;

    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editTextCorreo = findViewById(R.id.editTextCorreo);
        editTextContraseña = findViewById(R.id.editTextContraseña);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);

        mAuth = FirebaseAuth.getInstance();
        // Configurar eventos de clic
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Validar campos
                String correo = editTextCorreo.getText().toString();
                String contraseña = editTextContraseña.getText().toString();

                if (TextUtils.isEmpty(correo) || TextUtils.isEmpty(contraseña)) {
                    Toast.makeText(MainActivity.this, "Por favor, completa todos los campos.", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Autenticar usuario con Firebase
                mAuth.signInWithEmailAndPassword(correo, contraseña)
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Inicio de sesión exitoso, puedes redirigir a otra actividad
                                    Toast.makeText(MainActivity.this, "Inicio de sesión exitoso.", Toast.LENGTH_SHORT).show();
                                    // Ejemplo: redirigir a la actividad Menu
                                    Intent intent = new Intent(MainActivity.this, Menu.class);
                                    startActivity(intent);
                                } else {
                                    // Si falla el inicio de sesión, mostrar un mensaje al usuario
                                    Toast.makeText(MainActivity.this, "Inicio de sesión fallido. Verifica tus credenciales.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Register.class);
                startActivity(intent);
            }
        });

    }
}