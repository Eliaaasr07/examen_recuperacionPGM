package com.example.consesionariorodriguez;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class Registro extends AppCompatActivity {

    Button btnregirtro, btnView;
    EditText Marca, Modelo, Ano, NumMotor, NumChasis;
//Se inicializa firestore
    private FirebaseFirestore nfirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        //Se hace el llamado
        nfirestore = FirebaseFirestore.getInstance();

        Marca = findViewById(R.id.editTextMarca);
        Modelo = findViewById(R.id.editTextModelo);
        Ano = findViewById(R.id.editTextAno);
        NumMotor = findViewById(R.id.editTextNumeroMotor);
        NumChasis = findViewById(R.id.editTextNumeroChasis);
        btnregirtro =findViewById(R.id.buttonRegistrar);
        btnView =findViewById(R.id.buttonVerAutos);

        btnregirtro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String SMarca = Marca.getText().toString().trim();
                String SModelo = Modelo.getText().toString().trim();
                String SAno = Ano.getText().toString().trim();
                String SNM = NumMotor.getText().toString().trim();
                String SMC = NumChasis.getText().toString().trim();


                if(SMarca.isEmpty() && SModelo.isEmpty() && SAno.isEmpty() && SNM.isEmpty() && SMC.isEmpty()){
                    Toast.makeText(Registro.this, "Por favor llene los campos", Toast.LENGTH_SHORT).show();

                }
                else{

                    postCar(SMarca, SModelo, SAno, SNM, SMC);

                }

            }
        });

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoview();
            }
        });


    }

    private void gotoview() {
        Intent i = new Intent(Registro.this, Vista.class);
        startActivity(i);
    }

    private void postCar(String SMarca, String SModelo, String SAno, String SNM, String SMC) {
        Map<String, Object> map = new HashMap<>();
        map.put("Marca", SMarca);
        map.put("Modelo", SModelo);
        map.put("Año", SAno);
        map.put("Numero de motor", SNM);
        map.put("Numeor de chasis", SMC);
     nfirestore.collection("car").add(map).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
         @Override
         public void onSuccess(DocumentReference documentReference) {
             Toast.makeText(Registro.this, "Auto registrado exitosamente", Toast.LENGTH_SHORT).show();


         }
     }).addOnFailureListener(new OnFailureListener() {
         @Override
         public void onFailure(@NonNull Exception e) {
             Toast.makeText(Registro.this, "Lo sentimos, ha ocurrido un error", Toast.LENGTH_SHORT).show();

         }
     });
    }
}