package com.example.staticfragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentB extends Fragment {
    private static final String TAG = "StaticFragment";
    private static final String SIZE = "size";
    private static final String MESSAGE = "message";
    private TextView tvMessage;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "FragmentB -> onCreate()");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentb, root, false);
        Log.d(TAG, "FragmentB -> onCreateView()");
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvMessage = view.findViewById(R.id.tvMessage);
        Log.d(TAG, "FragmentB -> onViewCreated()");
    }


    /**
     * Método que actualiza el texto y tamaño en el Textview de la interfaz
     *
     * @param message
     * @param size
     */
    public void setMessageSize(String message, int size) {
        tvMessage.setText(message);
        tvMessage.setTextSize(size);
    }

    /**
     * Este método guarda/salvar el estado dinámico del Fragment dentro del
     * objeto Bundle
     *
     * @param outState
     */
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putFloat(SIZE, tvMessage.getTextSize()/getResources().getDisplayMetrics().scaledDensity); //Convert px to sp
        outState.putString(MESSAGE, tvMessage.getText().toString());
        Log.d(TAG, "FragmentB -> onSaveInstanceState()");
    }

    /**
     * Método que restaura el estado del Fragment si ha sido reiniciado
     * después de un cambio de configuración.
     *     1. Se llama siempre con lo cual hay que comprobar si es en la creación o
     *        se ha restaurado (savedInstanceState != null)
     *     2. Hay que guardar el texto ya que tvMessage se ha inicializado a
     *        traves del método setText no porque el usuario haya introducido datos
     *
     * @param savedInstanceState
     */
    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (savedInstanceState != null) {
            tvMessage.setText(savedInstanceState.getString(MESSAGE));
            tvMessage.setTextSize(savedInstanceState.getFloat(SIZE));
        }
        Log.d(TAG, "FragmentB -> onViewStateRestored()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "FragmentB -> onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "FragmentB -> onStop()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "FragmentB -> onDestroy()");
    }
}
