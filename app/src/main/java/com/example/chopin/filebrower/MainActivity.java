package com.example.chopin.filebrower;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;

public class MainActivity extends ListActivity {
    ArrayAdapter<EFile> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String dir= getIntent().getStringExtra("dir");
        if(dir==null){
            Log.d("INFO","YES");
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

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        EFile f=adapter.getItem(position);
        if(f.getFile().isDirectory()){
            Intent  i=new Intent(this,Main2Activity.class);
            i.putExtra("dir",f.getFile().getAbsoluteFile());
            startActivity(i);
            Log.d("send", String.valueOf(f.getFile().getAbsoluteFile()));
        }
        super.onListItemClick(l, v, position, id);
    }
}
