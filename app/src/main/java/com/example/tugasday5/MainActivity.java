package com.example.tugasday5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText teks1, teks2, teks3;
    RadioGroup radioGroup;
    Button btnProcess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        teks1 = findViewById(R.id.teks1);
        teks2 = findViewById(R.id.teks2);
        teks3 = findViewById(R.id.teks3);
        radioGroup = findViewById(R.id.radioGroup);
        btnProcess = findViewById(R.id.btnProcess);

        btnProcess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processTransaction();
            }
        });
    }

    private void processTransaction() {
        String customerName = teks1.getText().toString().trim();
        String itemCode = teks2.getText().toString().trim();
        int unit = Integer.parseInt(teks3.getText().toString().trim());
        String membershipType = getMembershipType();

        // Lakukan pengiriman data ke activity Total
        Intent intent = new Intent(MainActivity.this, TotalBon.class);
        intent.putExtra("customerName", customerName);
        intent.putExtra("itemCode", itemCode);
        intent.putExtra("unit", unit);
        intent.putExtra("membershipType", membershipType);
        startActivity(intent);
    }

    private String getMembershipType() {
        int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
        return selectedRadioButton.getText().toString();
    }
}

