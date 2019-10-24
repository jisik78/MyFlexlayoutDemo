package com.inossem.myflexboxdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

import java.util.ArrayList;
import java.util.List;

public class TagViewActivity extends AppCompatActivity {

    List<String> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tag_view);

        mList = new ArrayList<>();
        mList.add("ads");
        mList.add("gff");
        mList.add("gff");
        mList.add("fgfgrtt44");
        mList.add("fgfgrtt44");
        mList.add("fgfgrtt44");
        mList.add("dfsdf4");
        mList.add("dfsdfgffffffdsdsd4");
        mList.add("dfsdfdsdsdsdsdsdsdsd4");
        mList.add("dfsdfsdssdsdsd4");



        RecyclerView recyclerView = findViewById(R.id.recycler);


        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(TagViewActivity.this);
        layoutManager.setFlexDirection(FlexDirection.ROW);
        layoutManager.setJustifyContent(JustifyContent.FLEX_START);//FLEX_START , FLEX_END , CENTER , SPACE_BETWEEN , SPACE_AROUND ,SPACE_EVENLY
        recyclerView.setLayoutManager(layoutManager);


        BaseQuickAdapter<String, BaseViewHolder> adapter = new BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_tagview, mList) {
            @Override
            protected void convert(@NonNull BaseViewHolder helper, String item) {
                helper.setText(R.id.tv_tag, item);
            }
        };

        recyclerView.setAdapter(adapter);


    }
}
