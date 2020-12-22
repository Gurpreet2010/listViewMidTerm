package com.example.midtermfinalproject;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class OwnerListAdapter extends RecyclerView.Adapter<OwnerListAdapter.ViewHolder> {
    private ArrayList<Owner>  ownerArrayList=new ArrayList<>();
    private Context context;



    public OwnerListAdapter(Context context, ArrayList<Owner> ownerArrayList) {
        this.ownerArrayList=ownerArrayList;
        this.context=context;
    }

    @NonNull
    @Override
    public OwnerListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.owner_item_list,viewGroup,false);
        return new OwnerListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OwnerListAdapter.ViewHolder viewHolder, int i) {
        viewHolder.car_name.setText(ownerArrayList.get(i).getName());
        viewHolder.car_desc.setText(ownerArrayList.get(i).getOwner().getLogin());

        final Owner ownerArrayList = this.ownerArrayList.get(i);
        viewHolder.car_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,OwnerDetail.class);

                intent.putExtra("ownerName",ownerArrayList.getName());
                intent.putExtra("ownerLogin",ownerArrayList.getLogin());
                intent.putExtra("ownerFullName",ownerArrayList.getFull_name());
                  intent.putExtra("Owner",  ownerArrayList.getOwner().getLogin());


                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return ownerArrayList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        //private ImageView car_image;
        private TextView car_name,car_desc;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //car_image=(ImageView)itemView.findViewById(R.id.car_image);
            car_name=(TextView) itemView.findViewById(R.id.car_name);
            car_desc=(TextView)itemView.findViewById(R.id.car_desc);
        }
    }
}
