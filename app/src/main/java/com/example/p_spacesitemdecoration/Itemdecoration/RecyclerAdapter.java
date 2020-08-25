package com.example.p_spacesitemdecoration.Itemdecoration;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.p_spacesitemdecoration.Itemdecoration.opjo.AdapterInfo;
import com.example.p_spacesitemdecoration.R;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private List<AdapterInfo> mDatas;

    public RecyclerAdapter(@NonNull List<AdapterInfo> mDatas) {
        this.mDatas = mDatas;
    }

    public List<AdapterInfo> getmDatas() {
        return mDatas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecyclerAdapter.ViewHolder(View.inflate(parent.getContext(), R.layout.item_recycler, null));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AdapterInfo info = mDatas.get(position);
//        if (holder.itemView.getLayoutParams() instanceof StaggeredGridLayoutManager.LayoutParams) {
//            StaggeredGridLayoutManager.LayoutParams layoutParams = (StaggeredGridLayoutManager.LayoutParams) holder.itemView.getLayoutParams();
//            layoutParams.setFullSpan(position % 3 == 0);
//        }
        if (!TextUtils.isEmpty(info.message)) {
            holder.tvInfo.setText(info.message);
        } else {
            holder.tvInfo.setText(R.string.long_text);
        }
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();

    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvInfo;

        public ViewHolder(View itemView) {
            super(itemView);
            tvInfo = (TextView) itemView.findViewById(R.id.tv_info);
        }
    }
}
