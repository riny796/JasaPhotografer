package com.rini.jasaphotografer1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;

public class OrderActivity extends AppCompatActivity {

    EditText etNama,etNohp,etHari,etAlamat;
    Button btOrder;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();

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

        // kode yang dipanggil ketika tombol Submit diklik
        btOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getNama = etNama.getText().toString();
                String getNohp = etNohp.getText().toString();
                String getHari = etHari.getText().toString();
                String getAlamat = etAlamat.getText().toString();

                if (getNama.isEmpty()) {
                    etNama.setError("Masukkan Nama..");
                }else if (getNohp.isEmpty()){
                    etNohp.setError("Nohp masih kosong");
                }else
                  database.child("OrderanMasuk").push().setValue(new Order(getNama, getNohp, getHari, getAlamat)).addOnSuccessListener(new OnSuccessListener<Void>() {
                      @Override
                      public void onSuccess(Void unused) {
                          Toast.makeText(OrderActivity.this, "Orderan Berhasil Disimpan!", Toast.LENGTH_SHORT).show();
                          startActivity(new Intent(OrderActivity.this, BerandaActivity.class));
                          finish();
                      }
                  }).addOnFailureListener(new OnFailureListener() {
                      @Override
                      public void onFailure(@NonNull Exception e) {
                          Toast.makeText(OrderActivity.this, "Gagal Menyimpan Data!", Toast.LENGTH_SHORT).show();
                      }
                  });
            }
        });
    }
}
