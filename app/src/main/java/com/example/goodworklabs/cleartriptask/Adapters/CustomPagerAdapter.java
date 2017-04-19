package com.example.goodworklabs.cleartriptask.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.goodworklabs.cleartriptask.Models.CarouselImages;
import com.example.goodworklabs.cleartriptask.Models.FeaturedActivityModel;
import com.example.goodworklabs.cleartriptask.R;
import com.example.goodworklabs.cleartriptask.Utils.Constants;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


/**
 * Created by Madhu on 13/04/17.
 */

public class CustomPagerAdapter extends PagerAdapter {
    private FeaturedActivityModel mainModel;
    private ArrayList<Integer> cpModelArr;
    private Context context;
    private LayoutInflater inflater;
    String busiUrl;
    RelativeLayout totLay;
    private ImageView featuredImage;
    private TextView titleTxt, subTitleTxt, tagTxt;
    private String imgUrl;
    String TAG = "ADAPTER:";
    ArrayList<CarouselImages> imagesList;

    public CustomPagerAdapter(Context activity,
                              FeaturedActivityModel model) {
        // TODO Auto-generated constructor stub
        this.context = activity;
        this.mainModel = model;
        this.cpModelArr = mainModel.getEditorial().getTtdModel().getCpModel();
        inflater = (LayoutInflater) activity
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return cpModelArr.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object arg1) {
        // TODO Auto-generated method stub
        return view == ((RelativeLayout) arg1);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.activity_pager_row,
                container, false);
        if (cpModelArr.contains(mainModel.getEditorial().getCarouselModels().get(position).getId())) {
            imagesList = mainModel.getEditorial().getCarouselModels().get(position).getCarouselImages();
            featuredImage = (ImageView) itemView.findViewById(R.id.imgArticle);
            titleTxt = (TextView) itemView.findViewById(R.id.title);
            subTitleTxt = (TextView) itemView.findViewById(R.id.sub_title);
            tagTxt = (TextView) itemView.findViewById(R.id.tag_txt);
            imgUrl = imagesList.get(0).getImage().replace("{type}", "w");
            titleTxt.setText(mainModel.getEditorial().getCarouselModels().get(position).getTitle());
            subTitleTxt.setText(mainModel.getEditorial().getCarouselModels().get(position).getSubTitle());
            tagTxt.setText(mainModel.getEditorial().getCarouselModels().get(position).getTagTxt().toUpperCase());
            Log.d(TAG, Constants.IMAGE_BASE_URL + imgUrl);
            featuredImage.setBackgroundColor(Color.parseColor(imagesList.get(0).getVibrantColor()));

            Picasso.with(context)
                    .load(Constants.IMAGE_BASE_URL + imgUrl).placeholder(R.drawable.noimagel) // optional
                    .error(R.drawable.noimagel)
                    .into(featuredImage);
        }
        // Add viewpager_item.xml to ViewPager
        ((ViewPager) container).addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // Remove viewpager_item.xml from ViewPager
        ((ViewPager) container).removeView((RelativeLayout) object);
    }
}

