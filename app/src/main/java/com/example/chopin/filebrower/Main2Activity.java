package com.example.chopin.filebrower;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import java.io.File;

public class Main2Activity extends ListActivity {
    ArrayAdapter<EFile> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.d("Activity","YES");
        String dir= getIntent().getStringExtra("dir");
        if(dir==null){
            dir="/";
        }
        Log.d("die",dir);
        File dirFile=new File(dir);
        //获取子文件
        File[] children=dirFile.listFiles();

        adapter=new ArrayAdapter<EFile>(this,android.R.layout.simple_list_item_1);
        for (File f:children) {
            adapter.add(new EFile(f));
        }
        setListAdapter(adapter);
    }
}
