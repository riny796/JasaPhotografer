package com.rini.jasaphotografer1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;

public class OrderActivity extends AppCompatActivity {

    EditText etNama,etNohp,etHari,etAlamat;
    Button btOrder;
    DatabaseReference dbref;
    Order order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        // inisialisasi fields EditText dan Button
        etNama = findViewById(R.id.name);
        etNohp = findViewById(R.id.no_hp);
        etHari = findViewById(R.id.hari);
        etAlamat = findViewById(R.id.alamat);
        btOrder = findViewById(R.id.btn_order);

        // mengambil referensi ke Firebase Database
        order = new Order();
        //dbref = FirebaseDatabase.getInstance().getReference().child("OrderanMasuk");

        // kode yang dipanggil ketika tombol Submit diklik
        btOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                order.setNama(etNama.getText().toString().trim());
                order.setNohp(etNohp.getText().toString().trim());
                order.setHari(etHari.getText().toString().trim());
                order.setAlamat(etAlamat.getText().toString().trim());

                dbref.push().setValue(order);
            }
        });
    }
}
