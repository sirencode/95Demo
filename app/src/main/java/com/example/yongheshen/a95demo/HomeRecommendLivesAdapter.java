package com.example.yongheshen.a95demo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by yonghe.shen on 16/7/7.
 */
public class HomeRecommendLivesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater mInflater;
    private List<HomeRecommendLiveResult> mDatas;
    public static final int TYPE_HEAD = 0;//头部
    public static final int TYPE_NORMAL = 1;//其他
    private HomeRecommendLiveResult headData;
    private static ItemClickInterface itemClickInterface;
    private boolean hasHead;
    private int position;

    public void setItemClickInterface(ItemClickInterface itemClickInterface) {
        this.itemClickInterface = itemClickInterface;
    }

    public HomeRecommendLivesAdapter(Context context, HomeRecommendLiveResult headData, List<HomeRecommendLiveResult> datats) {
        mInflater = LayoutInflater.from(context);
        mDatas = datats;
        this.headData = headData;
        if (headData != null){
            hasHead = true;
        }
    }

    @Override
    public int getItemCount() {
        int count = 0;
        if (hasHead){
            count++;
            checkLives();
        }
        count = mDatas.size() + count;
        return count;
    }

    private void checkLives(){
        for (int i=0;i<mDatas.size();i++){
            if (mDatas.get(i).getLiveId() == headData.getLiveId()){
                mDatas.remove(i);
            }
        }
    }
    @Override
    public int getItemViewType(int position) {
        int type = 0;
        if (!hasHead){
            return TYPE_NORMAL;
        }
        if (position == 0) {
            type = TYPE_HEAD;
        } else {
            type = TYPE_NORMAL;
        }
        return type;
    }

    /**
     * 创建ViewHolder
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        if (viewType == TYPE_HEAD) {
            return new HeadHolder(mInflater.inflate(R.layout.home_recommend_live_item_strategy, viewGroup, false));
        } else {
            return new NormalViewHolder(mInflater.inflate(R.layout.home_recommend_live_item, viewGroup, false));
        }
    }

    public static class HeadHolder extends RecyclerView.ViewHolder {

        ImageView mImg;
        TextView mTxt;
        LinearLayout mLy;

        public HeadHolder(View itemView) {
            super(itemView);
            mLy = (LinearLayout) itemView.findViewById(R.id.item_head_ly);
            mTxt = (TextView) itemView.findViewById(R.id.item_head_name);
            mImg = (ImageView) itemView.findViewById(R.id.item_head_image);
        }
    }

    public static class NormalViewHolder extends RecyclerView.ViewHolder {

        ImageView mImg;
        TextView mTxt;
        LinearLayout mLy;

        public NormalViewHolder(View itemView) {
            super(itemView);
            mLy = (LinearLayout) itemView.findViewById(R.id.item_ly);
            mTxt = (TextView) itemView.findViewById(R.id.item_name);
            mImg = (ImageView) itemView.findViewById(R.id.item_image);
        }
    }

    /**
     * 设置值
     */
    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder viewHolder, final int i) {
        if (viewHolder instanceof HeadHolder) {
            final String name = headData.getName();
            ((HeadHolder) viewHolder).mTxt.setText(name);
            ((HeadHolder) viewHolder).mLy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemClickInterface.headItemClick(headData.getName());
                }
            });
        } else if (viewHolder instanceof NormalViewHolder) {
            position = i;
            if (hasHead){
                position--;
            }
            final String name = mDatas.get(position).getName();
            ((NormalViewHolder) viewHolder).mTxt.setText(name);
            ((NormalViewHolder) viewHolder).mLy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemClickInterface.normalItemClick(name);
                }
            });
        }
    }

    public interface ItemClickInterface {
        public void headItemClick(String result);

        public void normalItemClick(String result);
    }
}
