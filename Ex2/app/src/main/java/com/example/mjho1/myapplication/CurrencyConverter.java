package com.example.mjho1.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

public class CurrencyConverter extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_converter);


        back();
        list();
        Spinner drop1 = (Spinner) findViewById(R.id.drop1);
        drop1.setOnItemSelectedListener(this);
        /*drop1.setOnItemSelectedListener(
                new OnItemSelectedListener() {
                    public void onItemSelected(
                            AdapterView<?> parent, View view, int position, long id) {
                        String item=parent.getItemAtPosition(position).toString();
                        Toast.makeText(parent.getContext(),"Selected" + item,Toast.LENGTH_LONG).show();
                    }

                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });*/
        //convert();
        clear();
    }

    private void back(){
        Button backbtn = (Button) findViewById(R.id.backbtn);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void convert(){

    }

    private void list(){
        Spinner drop1 = (Spinner) findViewById(R.id.drop1);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(CurrencyConverter.this
                , android.R.layout.simple_spinner_item
                , getResources().getStringArray(R.array.list));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        drop1.setAdapter(myAdapter);
    }

    private void clear(){

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item=parent.getItemAtPosition(position).toString();
        //show selected item on toast
        Toast.makeText(parent.getContext(),"Selected" + item,Toast.LENGTH_LONG).show();
        final String currency = item;
        final double scale;

        switch (currency){
            case "USD": scale=22753;
                break;
            case "BITCOIN": scale=201462456.73;
                break;
            case "EURO": scale=28014.72;
                break;
            case "VND":scale=1;
                break;
            default:scale=1;
                break;
        }
        /*Button convertbtn = (Button) findViewById(R.id.convertbtn);

        convertbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText input = (EditText) findViewById(R.id.input);
                TextView result = (TextView) findViewById(R.id.result);
                double num =Double.parseDouble(input.getText().toString());

                result.setText(currency1 +"");
            }
        });*/
        EditText input = (EditText) findViewById(R.id.input);
        TextView usd =(TextView) findViewById(R.id.usd);
        TextView euro =(TextView) findViewById(R.id.euro);
        TextView bitcoin =(TextView) findViewById(R.id.bitcoin);
        TextView vnd =(TextView) findViewById(R.id.vnd);
        double num =Double.parseDouble(input.getText().toString());

        usd.setText(num*scale/22753 +"");
        bitcoin.setText(num*scale/201462456.73 +"");
        euro.setText(num*scale/28014.72 +"");
        vnd.setText(num*scale+"");
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
