package com.alobot.dummycardviewwithrecyclerview.interfaces;

import android.view.View;

public interface RecyclerView_Interface {
    void onClickSendCall(View view, int position);

    void onClickSendMessage(View view, int position);

    void onClickCardView(View view, int position);

    void onLongClickCardView(View view, int position);
}
