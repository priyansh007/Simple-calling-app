package com.priyansh.project1;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.provider.CallLog;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] array = {"Kanojiya ram", "Shyam manjuvadiya", "kaano", "Pankaj", "don", "ron", "mon"};
    int images[] = {R.drawable.one,R.drawable.one,R.drawable.one,R.drawable.one,R.drawable.one,R.drawable.one,R.drawable.one};
    String[] array1 = {"8460108506","8238911820","8569852156","9876543212","8569823545","9865732541","8796587456"};
    ListView l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        l = (ListView) findViewById(R.id.list1);
        new1 adapter = new new1(this, array, images,array1);
        l.setAdapter(adapter);

    }

    public void cal(View v) {
        if(v.getId()==R.id.ca) {
            Toast toast=Toast.makeText(this,"You are goig to Contact list",Toast.LENGTH_SHORT);
            toast.show();
            Intent toy = new Intent(Intent.ACTION_VIEW, ContactsContract.Contacts.CONTENT_URI);

            startActivity(toy);
        }
        String tex=((EditText)findViewById(R.id.text1)).getText().toString();
        Intent chooser=null;
        if(v.getId()==R.id.ca1){
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:"+tex));
            chooser = Intent.createChooser(callIntent,"CALL");
            startActivity(chooser);

        }
        if(v.getId()==R.id.ca2){
              // The number on which you want to send SMS
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", tex, null)));
        }
        if(v.getId()==R.id.cali){
            Intent showCallLog = new Intent();
            showCallLog.setAction(Intent.ACTION_VIEW);
            showCallLog.setType(CallLog.Calls.CONTENT_TYPE);
            startActivity(showCallLog);
        }
    }


    public void callme(View v) {
        Intent chooser=null;
        /*
        if(v.getId()==R.id.image1){
            String tex=((TextView)findViewById(R.id.text2)).getText().toString();
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:"+tex));
            chooser = Intent.createChooser(callIntent,"CALL");
            startActivity(chooser);

        }*/
        ListView lvItems = (ListView) findViewById(R.id.list1);;

        LinearLayout vwParentRow = (LinearLayout)v.getParent();
        LinearLayout vwParentRow1 = (LinearLayout) vwParentRow.getChildAt(1);

        //ImageView child = (ImageView) vwParentRow.getChildAt(0);
        TextView child1 = (TextView) vwParentRow1.getChildAt(1);
        String tex=child1.getText().toString();
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:"+tex));
        chooser = Intent.createChooser(callIntent,"CALL");
        startActivity(chooser);
        vwParentRow.refreshDrawableState();
       /* int c = Color.CYAN;

        vwParentRow.setBackgroundColor(c);
        */

    }

}

    class new1 extends ArrayAdapter<String> {
        Context cc;
        String[] s;
        int[] im;
        String[] o;

        new1(Context c, String[] array, int[] img,String[] array1) {
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



