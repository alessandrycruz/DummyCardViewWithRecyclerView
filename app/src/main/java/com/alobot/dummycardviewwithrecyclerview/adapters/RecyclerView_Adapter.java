package com.alobot.dummycardviewwithrecyclerview.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alobot.dummycardviewwithrecyclerview.R;
import com.alobot.dummycardviewwithrecyclerview.utils.Base_Util;

public class RecyclerView_Adapter extends RecyclerView.Adapter<RecyclerView_Adapter.ViewHolder> {
    private String[] mDataset;
    private Context mContext;

    public RecyclerView_Adapter(Context context, String[] myDataset) {
        mContext = context;
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public RecyclerView_Adapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.card_view_main,
                viewGroup, false);

        return new ViewHolder(view);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.mTextViewContactName.setText(mDataset[position]);

        Drawable drawableCardViewCall = Base_Util.changeDrawableColor(mContext,
                R.drawable.ic_cardview_call, mContext.getResources().getColor(R.color.colorPrimary));
        viewHolder.mImageViewSendCall.setImageDrawable(drawableCardViewCall);

        Drawable drawableCardViewMessage = Base_Util.changeDrawableColor(mContext,
                R.drawable.ic_cardview_message, mContext.getResources().getColor(R.color.colorPrimary));
        viewHolder.mImageViewSendMessage.setImageDrawable(drawableCardViewMessage);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewContactName;
        public ImageView mImageViewSendCall;
        public ImageView mImageViewSendMessage;

        public ViewHolder(View v) {
            super(v);

            mTextViewContactName = (TextView) v.findViewById(R.id.text_view_contact_name);
            mImageViewSendCall = (ImageView) v.findViewById(R.id.image_view_send_call);
            mImageViewSendMessage = (ImageView) v.findViewById(R.id.image_view_send_message);
        }
    }
}
