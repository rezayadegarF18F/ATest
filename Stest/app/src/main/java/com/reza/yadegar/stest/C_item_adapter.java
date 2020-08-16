package com.reza.yadegar.stest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textview.MaterialTextView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

class C_item_adapter extends RecyclerView.Adapter<C_item_adapter.C_view_holder>
{
    Activity activity;
    Context context;
    ArrayList<item_detail> show_list;

    LinearLayout.LayoutParams first_layout_params, last_layout_params;
    //----------------------------------------------------------------------------------------------

    C_item_adapter(Context context, Activity activity, ArrayList<item_detail> show_list)
    {
        this.context = context;
        this.activity = activity;
        this.show_list = show_list;
    }

    @NonNull
    @Override
    public C_view_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View main_view = LayoutInflater.from(context)
                .inflate(R.layout.c_item_row , parent , false);

        return new C_item_adapter.C_view_holder(main_view);
    }
    //----------------------------------------------------------------------------------------------

    @Override
    public void onBindViewHolder(@NonNull C_view_holder holder, final int position)
    {
        /*
        //first, last margins
        if(position == 0)
        {
            //
            LinearLayout.LayoutParams first_layout_params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            first_layout_params.setMargins(8, 8, 8, 4);

            holder.c_item_card.setLayoutParams(first_layout_params);
        }
        else if(position == show_list.size() - 1)
        {
            LinearLayout.LayoutParams last_layout_params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            last_layout_params.setMargins(8, 4, 8, 8);

            holder.c_item_card.setLayoutParams(last_layout_params);
        }
        //------------------------------------------------------------------------------------------*/

        //
        holder.item_title.setText(show_list.get(position).title);
        holder.item_sub_title.setText(show_list.get(position).sub_title);
        Picasso.get().load(show_list.get(position).icon_id).resize(100, 0)
                .into(holder.image_img);
        Picasso.get().load(show_list.get(position).second_icon_id)
                .resize(100, 0)
                .into(holder.secondary_img);
        //------------------------------------------------------------------------------------------

        holder.c_item_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(activity, Show_item_activity.class);

                intent.putExtra("IMAGE",show_list.get(position).icon_id);
                intent.putExtra("TITLE", show_list.get(position).title);
                intent.putExtra("SUBTITLE", show_list.get(position).sub_title);

                context.startActivity(intent);
            }
        });
        //------------------------------------------------------------------------------------------
    }
    //----------------------------------------------------------------------------------------------

    @Override
    public int getItemCount() {
        return show_list.size();
    }
    //----------------------------------------------------------------------------------------------

    public class C_view_holder extends RecyclerView.ViewHolder
    {
        //
        MaterialCardView c_item_card;
        CircleImageView image_img;
        MaterialTextView item_title, item_sub_title;
        ImageView secondary_img;
        //------------------------------------------------------------------------------------------

        public C_view_holder(@NonNull View itemView) {
            super(itemView);

            //
            c_item_card = itemView.findViewById(R.id.C_item_card);
            image_img = itemView.findViewById(R.id.Image_img);
            item_title = itemView.findViewById(R.id.Item_title);
            item_sub_title = itemView.findViewById(R.id.Item_sub_title);
            secondary_img = itemView.findViewById(R.id.Secondary_Image_img);
            //--------------------------------------------------------------------------------------

        }
    }

}
