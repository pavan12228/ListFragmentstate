package com.example.ravinderreddy.listfragmentstate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ravinder Reddy on 03-03-2017.
 */
public class CustomAdapter extends BaseAdapter {
    LayoutInflater layoutInflater;
    Context mContext;
    ImageLoader imageLoader;

    List<Model> models = new ArrayList<>();

    public CustomAdapter(Context mContext, List<Model> models) {
        this.mContext = mContext;
        this.models = models;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public Object getItem(int position) {
        return models.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = new Holder();
         imageLoader = ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(mContext));
        if (layoutInflater == null) {
            layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        }
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.drugs_adapter_list_item, null);

            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        holder.name = (TextView) convertView.findViewById(R.id.text);
        holder.imageView = (ImageView) convertView.findViewById(R.id.image);
        Model model = models.get(position);
        holder.name.setText(model.getName());
        imageLoader.displayImage(model.getImage(), holder.imageView);


        return convertView;
    }

    class Holder {

        private TextView name;
        private ImageView imageView;


    }
}
