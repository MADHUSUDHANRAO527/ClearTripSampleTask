package com.example.goodworklabs.cleartriptask.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.goodworklabs.cleartriptask.Models.CollectionsModel;
import com.example.goodworklabs.cleartriptask.R;
import com.example.goodworklabs.cleartriptask.Utils.Constants;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;



/**
 * Created by GoodWorkLabs on 17-04-2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    private Context mContext;
    private ArrayList<CollectionsModel> collecitonModel;
    private String imgUrl;

    public RecyclerAdapter(Context context, ArrayList<CollectionsModel> list) {
        this.mContext = context;
        this.collecitonModel = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final CollectionsModel collections = collecitonModel.get(position);
        holder.titleTxt.setText(collections.getCollectionName());
        holder.counterTxt.setText(collections.getCountText());
        imgUrl = collections.getImage().replace("{type}", "w");


        Picasso.with(mContext)
                .load(Constants.IMAGE_BASE_URL + imgUrl).placeholder(R.drawable.noimagel) // optional
                .error(R.drawable.noimagel)
                .into(holder.imageArticle);
        holder.imageArticle.setBackgroundColor(Color.parseColor(collections.getVibrantColor()));
    }

    @Override
    public int getItemCount() {
        return collecitonModel.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView titleTxt, counterTxt;
        private ImageView imageArticle;

        private MyViewHolder(View view) {
            super(view);
            titleTxt = (TextView) view.findViewById(R.id.title_txt);
            counterTxt = (TextView) view.findViewById(R.id.count_text);
            imageArticle = (ImageView) itemView.findViewById(R.id.imgArticle);

        }
    }
}
