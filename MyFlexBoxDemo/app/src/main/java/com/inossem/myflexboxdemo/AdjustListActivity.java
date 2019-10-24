package com.inossem.myflexboxdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdjustListActivity extends AppCompatActivity {


    private List<Integer> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adjust_list);

        mList = Arrays.asList(
                R.drawable.cat_1,
                R.drawable.cat_2,
                R.drawable.cat_3,
                R.drawable.cat_4,
                R.drawable.cat_5,
                R.drawable.cat_6,
                R.drawable.cat_7,
                R.drawable.cat_8,
                R.drawable.cat_10,
                R.drawable.cat_11,
                R.drawable.cat_12,
                R.drawable.cat_13,
                R.drawable.cat_14,
                R.drawable.cat_15,
                R.drawable.cat_16,
                R.drawable.cat_17,
                R.drawable.cat_18,
                R.drawable.cat_19);


        RecyclerView recyclerView = findViewById(R.id.recycler);
        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(AdjustListActivity.this);
        layoutManager.setFlexWrap(FlexWrap.WRAP);
        layoutManager.setFlexDirection(FlexDirection.ROW);
        layoutManager.setAlignItems(AlignItems.STRETCH);
        recyclerView.setLayoutManager(layoutManager);

        BaseQuickAdapter<Integer, BaseViewHolder> adapter = new BaseQuickAdapter<Integer, BaseViewHolder>(R.layout.item_adjust_list, mList) {
            @Override
            protected void convert(@NonNull BaseViewHolder helper, Integer item) {
                helper.setImageResource(R.id.iv_adjust, item);

                View linearLayout = helper.itemView;

                //  item的 父布局子布局的宽高参数对显示效果有影响
                //  imageView 的 scaleType 也有影响

                ViewGroup.LayoutParams lp = linearLayout.getLayoutParams();
                if (lp instanceof FlexboxLayoutManager.LayoutParams) {
                    FlexboxLayoutManager.LayoutParams flexboxLp =
                            (FlexboxLayoutManager.LayoutParams) linearLayout.getLayoutParams();
                    flexboxLp.setFlexGrow(1.0f);
                    //  FlexGrow
                    //  默认值为0,就是不放大，
                    //  如果有一个item的 layout_flexGrow 是一个正值，那么会将全部剩余空间分配给这个Item,
                    //  如果有多个Item这个属性都为正值，那么剩余空间的分配按照layout_flexGrow定义的比例分配
                    // （有点像LinearLayout的layout_weight属性）

                }

            }
        };

        recyclerView.setAdapter(adapter);

    }
}
