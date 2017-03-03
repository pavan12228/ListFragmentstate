package com.example.ravinderreddy.listfragmentstate;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class Tab  extends Fragment implements AdapterView.OnItemClickListener
{
    ListView listView;
    List<Model> models=new ArrayList<>();
    private static final String Root_url="http://api.androidhive.info/";
    CustomAdapter customAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View  view = inflater.inflate(R.layout.tab, container, false);
        listView= (ListView) view.findViewById(R.id.lvItems);
        response();
        return view;
    }

    private void response() {
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(Root_url).build();
        Apiservice apiservice = restAdapter.create(Apiservice.class);
        apiservice.myMeth(new Callback<JsonArray>() {
            @Override
            public void success(JsonArray jsonElements, Response response) {
                try {
                    for (int i = 0; i < jsonElements.size(); i++) {
                        JsonObject jsonObject= jsonElements.get(i).getAsJsonObject();
                        String name=jsonObject.get("title").getAsString();
                        String image=jsonObject.get("image").getAsString();
                        Model model=new Model();
                        model.setImage(image);
                        model.setName(name);
                        models.add(model);

                    }

                }catch (JsonIOException e){
                    e.printStackTrace();
                }
                customAdapter=new CustomAdapter(getContext(),models);
                listView.setAdapter(customAdapter);

            }

            @Override
            public void failure(RetrofitError error) {
                try {
                    Toast.makeText(getContext(), ""+error.toString(), Toast.LENGTH_SHORT).show();
                }catch (JsonIOException e){
                    e.printStackTrace();
                }


            }
        });
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        if(position==0){



        }










    }
}
