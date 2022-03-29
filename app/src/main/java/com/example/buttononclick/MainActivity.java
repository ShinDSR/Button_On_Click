package com.example.buttononclick;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //deklarasi variabel untuk button
    Button btnLogin;

    //deklrasi variabel untuk EditText
    EditText edemail, edpassword;

    //deklarasi variabel untuk menyimpan email dan password
    String nama, password;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //Membuat kondisi jika yang dipilih adalah id mnDaftar
        if (item.getItemId() == R.id.mnDaftar)
        {
            //Method untuk memanggil activity "DaftarActivity"
            Intent i = new Intent(getApplicationContext(), DaftarActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Method untuk menampilkan menu.
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //menghubungkan variabel btnLogin dengan componen button pada Layout
        btnLogin=findViewById(R.id.btSignin);

        //menghubungkan variabel edemail dengan componen button pada layout
        edemail=findViewById(R.id.edEmail);

        //menghubungkan variabel edpassword dengan componen button pada Layout
        edpassword=findViewById(R.id.edPassword);

        //membuat fungsi onclik pada button btnLogin
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //menyimpan input user di eddittex email kedalam variabel nama
                nama = edemail.getText().toString();

                //menyimpan input user di edittext password kedalam variabel password
                password = edpassword.getText().toString();

                //menegeset email yang benar
                String email="danang123@mail.com";

                //mengeset password yang benar
                String pass = "tidak ada";

                //mengecek apakah isi dari email dan password sudah sama dengan email dan
                // password yang sudah diset
                if (nama.isEmpty() || password.isEmpty()) {
                    //membuat variabel toast dan menampilkan pesan "edittext tidak boleh kosong"
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Email dan password wajib diisi!!!",
                            Toast.LENGTH_LONG);
                    //menampilkan toast
                    t.show();

                } else
                    //mengecek apakah isi dari email dan password sudah sama dngan email dan
                    // password uang sudah diset
                    if (nama.equals(email) && password.equals(pass)) {
                        //membuat variabel toast dan menampilkan pesan "login sukses"
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Login Sukses",
                                Toast.LENGTH_LONG);

                        //menampilkan toast
                        t.show();

                        //Membuat objek bundle
                        Bundle b = new Bundle();

                        //memasukkan value dari variabel nama dengan kunci "a"
                        // dan dimasukkan kedalam bundle
                        b.putString("a", nama.trim());

                        //memasukkan value dari variabel password dengan kunci "b"
                        // dan dimasukkan ke dalam bundle
                        b.putString("b", password.trim());

                        //membuat objek intent berpindah activity dari mainactivity ke Home_Activity
                        Intent i = new Intent(getApplicationContext(), Home_Activity.class);

                        //memasukkan bundle kedalam intent untuk dikirimkan ke ActivityHasil
                        i.putExtras(b);

                        //berpindah ke ActivityHasil
                        startActivity(i);

                    }
                    else if (nama.equals("danang123@mail.com")){
                        //Password salah
                        Toast.makeText(MainActivity.this, "Password Salah", Toast.LENGTH_SHORT).show();
                    }
                    else if (password.equals("tidak ada")){
                        //Email salah
                        Toast.makeText(MainActivity.this, "Email salah", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        //email dan password salah
                        Toast.makeText(MainActivity.this, "Email dan Password Anda Salah", Toast.LENGTH_SHORT).show();
                    }
            }
        });
    }
}