package com.example.buttononclick;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;

public class Home_Activity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    //Deklarasii variabel dengan jenis data Listview
    private ListView list;

    //Memanggil class ListViewAdapter dan diinisiasi menjadi variabel adapter
    private ListViewAdapter adapter;

    //Deklarasi array untuk menyimpan nama
    String[] listNama;

    //Memanggil class ClassNama
    public static ArrayList<ClassNama> classNamaArrayList = new ArrayList<ClassNama>();

    //Membuat objek Bundle
    Bundle bundle=new Bundle();

    //Membuat obejek Intent
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Menyimpan nama di dalam array ListNama
        listNama = new String[]{"Inayah","Ilham","Eris",
        "Fikri","Maul","Intan","Vina","Gita","Vian","Lutfi"};

        list=findViewById(R.id.listKontak);

        //Membuat oobjek dari class ClassNama menjadi arrayList
        classNamaArrayList=new ArrayList<>();

        //Membaca seluruh data pada array listNama
        for (int i=0;i<listNama.length;i++){

            //Membuat objek class nama
            ClassNama classNama=new ClassNama(listNama[i]);
            //Binds string ke array
            classNamaArrayList.add(classNama);
        }

        //Membuat objek dari ListviewAdapter
        adapter=new ListViewAdapter(this);

        //Binds Adapter ke ListView
        list.setAdapter(adapter);

        //Membuat event dari list onclick
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                //Deklarasi variabel nama yang berisi item yang diklik
                String nama=classNamaArrayList.get(position).getName();

                //memasukkan value dari variabel nama kunci "a"
                //dan dimasukkan ke dlam bundle
                bundle.putString("a", nama.trim());

                //Membuat objek grup menu
                PopupMenu pm = new PopupMenu(getApplicationContext(),view);

                //Membuat event untuk popup menu ketika dipilih
                pm.setOnMenuItemClickListener(Home_Activity.this);

                //Menempilkan popup menu dari layout menu
                pm.inflate(R.menu.popup_menu);

                //Menempilkan popup menu
                pm.show();
            }
        });
    }

    //even yang terjadi ketika menu dipilih
    @Override
    public boolean onMenuItemClick(MenuItem menuItem){
        switch (menuItem.getItemId()){
            case R.id.mnview:
                intent = new Intent(getApplicationContext(),ActivityLihatData.class);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.nmedit:
                Toast.makeText(getApplicationContext(),"Ini untuk edit kontak",
                        Toast.LENGTH_LONG).show();
                break;
        }
        return false;
    }
}