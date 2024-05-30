package com.mirea.kt.ribo.plant;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextType;
    private Switch switchGreenhouse;
    private dbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextType = findViewById(R.id.editTextType);
        switchGreenhouse = findViewById(R.id.switchGreenhouse);
        Button buttonSave = findViewById(R.id.buttonSave);
        Button buttonViewAll = findViewById(R.id.buttonViewAll);

        dbHelper = new dbHelper(this);

        buttonSave.setOnClickListener(v -> {
            String name = editTextName.getText().toString();
            String type = editTextType.getText().toString();
            boolean isGreenhouse = switchGreenhouse.isChecked();
            Plant plant = new Plant(name, type, isGreenhouse);
            dbHelper.addPlant(plant);
            Toast.makeText(MainActivity.this, "Растение сохранено", Toast.LENGTH_SHORT).show();
        });

        buttonViewAll.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, PlantListActivity.class);
            startActivity(intent);
        });
    }
}
