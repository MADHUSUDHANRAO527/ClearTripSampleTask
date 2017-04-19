package com.example.goodworklabs.cleartriptask.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.goodworklabs.cleartriptask.Adapters.RecyclerAdapter;
import com.example.goodworklabs.cleartriptask.Models.CollectionsModel;
import com.example.goodworklabs.cleartriptask.Models.FeaturedActivityModel;
import com.example.goodworklabs.cleartriptask.R;
import com.example.goodworklabs.cleartriptask.Utils.WorkspaceApp;

import java.util.ArrayList;
import java.util.HashMap;

import static android.content.ContentValues.TAG;

/**
 * Created by "Madhu sudhan" on 17/04/17.
 */

public class FeaturedItemFragment extends Fragment {
    RecyclerView recyclerView;
    public FeaturedActivityModel model = new FeaturedActivityModel();
    Context mContext;
    ArrayList<String> cateList;
    String cateId;
    ProgressBar progressBar;

    public FeaturedItemFragment(String id) {
        this.mContext = getActivity();
        this.cateId = id;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_featured, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
        model = WorkspaceApp.getInstance().getMainModel();
        progressBar = (ProgressBar) v.findViewById(R.id.pBar);
        for (int i = 0; i < model.getCategory().size(); i++) {
            cateList = new ArrayList<>();
            cateList.add(model.getCategory().get(i).getId());
        }
        Log.d(TAG, "LIST : " + cateList + "");
        HashMap<String, ArrayList<CollectionsModel>> collectionsCate = new HashMap<>();
        for (CollectionsModel collectionModel : model.getCollectionsModel()) {
            if (collectionModel.getCollectionsCategoriesIdsModel() != null) {
                String categoryId = collectionModel.getCollectionsCategoriesIdsModel().get(0);

                ArrayList<CollectionsModel> list = collectionsCate.get(categoryId);
                if (list == null) {
                    list = new ArrayList<CollectionsModel>();
                    collectionsCate.put(categoryId, list);
                }
                list.add(collectionModel);
            }
        }
        Log.d(TAG, "************: " + collectionsCate);
        ArrayList<CollectionsModel> list = collectionsCate.get(cateId);
        RecyclerAdapter adapter = new RecyclerAdapter(mContext, list);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setAdapter(adapter);
        progressBar.setVisibility(View.GONE);
        return v;
    }
}