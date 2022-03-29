package com.example.buttononclick;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {

    //Fusngsi getVount () mengembalikan jumlah item yang akan di tampilkan dalam list
    @Override
    public int getCount() {
        return Home_Activity.classNamaArrayList.size();
    }

    //Fungsi ini digunakan untuk mendapatkan data item yang terkait dengan posisi
    //tertentu dalam kumpulan data untuk mendapatkan data yang sesuai dari lokasi
    //tertentu dalam mengumpulkan item
    @Override
    public Object getItem(int i) {
        //mengembalikan nilai berupa objek dari array data
        return Home_Activity.classNamaArrayList.get(i);
    }

    //Fungsi mengembalikan "nilai" dari posisi ke adaptor
    @Override
    public long getItemId(int i) {
        return i;
    }

    //Fungsi ini secara otomatis dipanggil ketika tampilan item list siap untuk
    //ditampilkan atau akan ditampilkan
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //deklarasi variabel dengan jenis data viewHolder
        final ViewHolder holder;

        //Membuat kondisi apakah view null atau tidak
        if (view==null){
            //membuat objek view holder
            holder=new ViewHolder();

            //Mengatur layoy=ut untuk menampiilkan item
            view=inflater.inflate(R.layout.item_listview,null);

            //set id untuk textview
            holder.name=(TextView) view.findViewById(R.id.tvnama_item);

            //Menyimpan data dalam tampilan tanpa menggunakan struktur data lain
            view.setTag(holder);
        }
        else {
            //mengatur holder untuk mengembalikan nilai dari view tag
            holder=(ViewHolder) view.getTag();
        }
        //set item ke textView
        holder.name.setText(Home_Activity.classNamaArrayList.get(i).getName());

        //mengembalikan nilai ke variabel view
        return view;
    }

    //Deklarasi variabel dengan jenis data context
    Context mContext;

    //Deklarasi variabel dengan jenis data layput inflater
    LayoutInflater inflater;

    //Deklarasi variabel dengan jenis data arraylist
    private ArrayList<ClassNama> arrayList;

    //Membuat konstruktor ListViewAdapter
    public ListViewAdapter(Context context){
        //Memberi nilai mContext dengan context
        mContext=context;

        //mengatur LayoutInfrater dari context yang diberikan
        inflater=LayoutInflater.from(mContext);

        //Memberi niai arrayList dari ClassNama
        this.arrayList=new ArrayList<ClassNama>();

        //Menambahkan semua elemen ke arrayList
        this.arrayList.addAll(Home_Activity.classNamaArrayList);
    }

    public class ViewHolder {
        // mendeklarasikan variable dengan jenis TextView
        TextView name;
    }
}
