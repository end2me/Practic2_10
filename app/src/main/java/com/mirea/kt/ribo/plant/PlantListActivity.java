package com.mirea.kt.ribo.plant;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PlantListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private rcAdapter plantAdapter;
    private dbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_list);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dbHelper = new dbHelper(this);
        List<Plant> plants = dbHelper.getAllPlants();

        plantAdapter = new rcAdapter(plants);
        recyclerView.setAdapter(plantAdapter);
    }
}
