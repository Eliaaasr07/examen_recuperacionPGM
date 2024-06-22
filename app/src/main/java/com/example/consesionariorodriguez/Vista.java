package com.example.consesionariorodriguez;



import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class Vista extends AppCompatActivity {

    private FirebaseFirestore nfirestore;
    private RecyclerView recyclerViewAutos;
    private AutosAdapter autosAdapter;
    private List<Auto> listaAutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista);

        nfirestore = FirebaseFirestore.getInstance();
        recyclerViewAutos = findViewById(R.id.recyclerViewAutos);
        recyclerViewAutos.setLayoutManager(new LinearLayoutManager(this));
        listaAutos = new ArrayList<>();
        autosAdapter = new AutosAdapter(listaAutos);
        recyclerViewAutos.setAdapter(autosAdapter);

        obtenerAutos();
    }

    private void obtenerAutos() {
        nfirestore.collection("car").get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                listaAutos.clear();
                for (QueryDocumentSnapshot document : task.getResult()) {
                    Auto auto = document.toObject(Auto.class);
                    listaAutos.add(auto);
                }
                autosAdapter.notifyDataSetChanged();
            } else {
                Toast.makeText(this, "No hay carros a mostrar", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

