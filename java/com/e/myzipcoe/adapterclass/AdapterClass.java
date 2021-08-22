package com.e.myzipcoe.adapterclass;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.e.myzipcoe.R;
import com.e.myzipcoe.modelclass.ModelClassZIp;

import java.util.Collections;
import java.util.List;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.ViewHolderClass> {
             List<ModelClassZIp.List> items;
       int i;
    public AdapterClass( List<ModelClassZIp.List> items) {
        this.items = items;
    }



//    public void setMovieList(ModelClassZIp items) {
//        this.items =  items;
//        notifyDataSetChanged();
//        Log.d("kko","123");
//
//    }



    @NonNull
    @Override
    public ViewHolderClass onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.zipcode_list, parent, false);
                 return new ViewHolderClass(view);
    }
    int count=0;
    @Override
    public void onBindViewHolder(AdapterClass.ViewHolderClass holder, int position) {
        try {
     Log.d("hh","111");


//            ModelClassZIp.List item=items.get(position);
//            holder.zipid.setText("id: " + item.getId().toString() +" count= "+i);
//            holder.zipcode.setText("Zipcode: " + item.getZipcode().toString());

               count++;
for( i = 0; i<=position; i++) {
//    holder.msg.setText("msg:"+items.getMsg());
//    holder.count.setText("count: " + items.getData().getCount());
    holder.zipid.setText("id: " + items.get(position).getId().toString() +" count= "+i);
    holder.zipcode.setText("Zipcode: " + items.get(position).getZipcode().toString());


   // holder.zipid.setText("id: " + );


    //  Log.d("ff", String.valueOf(count++));
    Log.d("ff", String.valueOf(position));
    Log.d("ffff", String.valueOf(i));
}

        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.d("kko","123");
    }

    @Override
    public int getItemCount() {
        return items.size() ;
    }

//    public void setMovieList(ModelClassZIp list) {
//        Log.d("kko","1234");
//        this.items = items;
//        notifyDataSetChanged();
//    }

    public class ViewHolderClass extends RecyclerView.ViewHolder {
        private final TextView zipid, zipcode,msg,count;
        public ViewHolderClass(View itemView) {
            super(itemView);
            zipid=itemView.findViewById(R.id.zip_id);
            zipcode=itemView.findViewById(R.id.zipcode);
            msg=itemView.findViewById(R.id.msg);
            count=itemView.findViewById(R.id.count);
        }
    }
}
