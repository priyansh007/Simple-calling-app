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

public class second extends AppCompatActivity {
    String[] array = {"Kanojiya ram", "Shyam manjuvadiya", "kaano", "Pankaj", "don", "ron", "mon"};
    int images[] = {R.drawable.one,R.drawable.one,R.drawable.one,R.drawable.one,R.drawable.one,R.drawable.one,R.drawable.one};
    String[] array1 = {"8460108506","8238911820","8569852156","9876543212","8569823545","9865732541","8796587456"};
    ListView l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        l = (ListView) findViewById(R.id.list2);
        new2 adapter = new new2(this, array, images,array1);
        l.setAdapter(adapter);
    }
}
class new2 extends ArrayAdapter<String> {
    Context cc;
    String[] s;
    int[] im;
    String[] o;

    new2(Context c, String[] array, int[] img,String[] array1) {
        super(c, R.layout.listelement, R.id.text1, array);
        this.cc = c;
        this.s = array;
        this.im = img;
        this.o = array1;
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
        TextView p = (TextView) v.findViewById(R.id.text2);
        i.setImageResource(im[position]);
        t.setText(s[position]);
        p.setText(o[position]);


        return v;
    }



}
