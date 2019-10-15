package edu.depaul.cdm;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
//import android.widget.Toast;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG="MainActivity";
private TextView history;
private RadioGroup radioGroup;
private EditText inputFah;
private EditText inputCel;
private Button convert;
private Button clear;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       history=findViewById(R.id.history);
       radioGroup=findViewById(R.id.radioGroup);
       inputFah=findViewById(R.id.inputFah);
       inputCel=findViewById(R.id.inputCel);
       convert=findViewById(R.id.buttonConvert);



    }

/*

    @Override
    protected void onSaveInstanceState (Bundle outstate)
    {
        outstate.putString("HISTORY", history.getText().toString());
        super.onSaveInstanceState(outstate);
    }
   // @Override
    //protected void onRestoreIns(){}*/
    public void onClickConvert(View v)
        {

            RadioButton radioButtonFahtoCel=findViewById(R.id.radioButtonFahToCel);
            RadioButton radioButtionCeltoFah=findViewById(R.id.radioButtonCelToFah);
            history.setMovementMethod(new ScrollingMovementMethod());
            String orig=history.getText().toString();

            if(radioButtonFahtoCel.isChecked()){

                String fahVal=inputFah.getText().toString();
                if (!fahVal.trim().isEmpty())
                {
                    String result=ConvertTemp.toCelsiuis(fahVal);
                    Log.d(TAG, "Convert pressed  result is " + result);
                    history.setText(fahVal+"F==>"+result +"C"+"\n"+orig);
                    inputFah.getText().clear();
                }
            }
            else if (radioButtionCeltoFah.isChecked())
            {
                String celVal=inputCel.getText().toString();
                if(!celVal.trim().isEmpty())
                {
                    String result=ConvertTemp.toFahrenheit(celVal);
                    history.setText(celVal+"C==>"+result+"F"+"\n"+orig);
                    inputCel.getText().clear();
                }
            }





        }

     public void onClickClear(View v)
     {
         history.setText("");

     }
     @Override
    protected void onSaveInstanceState(Bundle outState){
        outState.putString("HISTORY", history.getText().toString());
        super.onSaveInstanceState(outState);
     }
     @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        history.setText(savedInstanceState.getString("HISTORY"));
     }




}
