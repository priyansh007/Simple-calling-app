package com.priyansh.project1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String[] array = {"Kanojiya ram", "Shyam manjuvadiya", "kaano", "Pankaj", "don", "ron", "mon"};
    int images[] = {R.drawable.one,R.drawable.one,R.drawable.one,R.drawable.one,R.drawable.one,R.drawable.one,R.drawable.one};
    ListView l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        l = (ListView) findViewById(R.id.list1);
        new1 adapter = new new1(this, array, images);
        l.setAdapter(adapter);
    }
}

    class new1 extends ArrayAdapter<String> {
        Context cc;
        String[] s;
        int[] im;

        new1(Context c, String[] array, int[] img) {
            super(c, R.layout.listelement, R.id.text1, array);
            this.cc = c;
            this.s = array;
            this.im = img;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            if (v == null) {
                LayoutInflater inflat = (LayoutInflater) cc.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = inflat.inflate(R.layout.listelement, parent, false);
            }
            ImageView i = (ImageView) v.findViewById(R.id.image1);
            TextView t = (TextView) v.findViewById(R.id.text1);
            i.setImageResource(im[position]);
            t.setText(s[position]);

            return v;
        }
    }

