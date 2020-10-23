package com.example.staticfragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class FragmentC extends Fragment {
    private static final String TAG = "StaticFragment" ;

    private WebView wbAbout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentc,root,false);
        //¡¡ SOLO DESPUÉS DE INFLAR LA VISTA SE PUEDE HACER FINDBYID !!
        //wbAbout=view.findViewById(R.id.webAbout);
        Log.d(TAG,"FragmentC -> onCreateView()");
        return view;
    }

    /**
     * Este método se puede utilizar para inicializar los componentes o widget
     * porque la vista ya se ha inflado y no es null
     * @param view
     * @param savedInstanceState
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        wbAbout=view.findViewById(R.id.webAbout);
        String html= getResources().getString(R.string.aboutus);
        wbAbout.loadData(html,"text/html","UTF-8");
        Log.d(TAG,"FragmentC -> onViewCreated()");
    }
}
