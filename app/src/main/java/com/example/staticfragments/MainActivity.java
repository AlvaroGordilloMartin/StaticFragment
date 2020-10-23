package com.example.staticfragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements FragmentA.OnSetMessageSizeListener{
    private final  String TAG="StaticFragment";
    private Fragment fragmentb;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentb=getSupportFragmentManager().findFragmentById(R.id.fragmentb);
        Log.d(TAG,"Activity -> onCreate()");
    }

    /**
     * Método que modifica el texto y el tamaño de texto del TextView del
     * FragmentB
     * @param message
     * @param size
     */
    @Override
    public void onSetMessageSize(String message, int size) {
        //Toast.makeText(this,"Muestra mensaje:"+message,Toast.LENGTH_SHORT).show();
        //La Activity puede realizar cualquier operación o comprobación de los datos antes
        //de pasárselo al Fragment --> Clase Controladora
        ((FragmentB)fragmentb).setMessageSize(message,size);
    }

    /************************************************************
       Métodos que se llaman para guardar el estado de la Activity
     ************************************************************/

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG,"Activity -> onSaveInstanceState()");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG,"Activity -> onRestoreInstanceState()");
    }

    /********************************************************/


    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG,"Activity -> onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG,"Activity -> onStop()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"Activity -> onDestroy()");
    }
}
