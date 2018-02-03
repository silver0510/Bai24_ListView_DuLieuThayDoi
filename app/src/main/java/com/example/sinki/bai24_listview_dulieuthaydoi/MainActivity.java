package com.example.sinki.bai24_listview_dulieuthaydoi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView txtTen;
    Button btnLuu;
    ListView lvTen;

    ArrayList<String>arrten;
    ArrayAdapter<String>adapterTen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyLuuDuLieu();
            }
        });
    }

    private void xuLyLuuDuLieu() {
        String ten = txtTen.getText().toString();
        arrten.add(ten);
        adapterTen.notifyDataSetChanged();//cập nhập dữ liệu thay đổi
        txtTen.setText("");
        txtTen.requestFocus();
    }

    private void addControls() {
        arrten = new ArrayList<>();
        adapterTen = new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                arrten);
        lvTen= (ListView) findViewById(R.id.lvTen);
        lvTen.setAdapter(adapterTen);
        txtTen = (TextView) findViewById(R.id.txtTen);
        btnLuu = (Button) findViewById(R.id.btnLuu);
    }
}
