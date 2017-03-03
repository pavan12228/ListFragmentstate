package com.example.ravinderreddy.listfragmentstate;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ravinderreddy.listfragmentstate.R;

/**
 * Created by Ravi on 26-11-2016.
 */

public class Tab1 extends Fragment
{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab1, container, false);
        return rootView;
    }
}
