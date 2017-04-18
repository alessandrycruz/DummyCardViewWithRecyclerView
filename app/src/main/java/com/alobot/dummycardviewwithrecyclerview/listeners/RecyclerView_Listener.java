package com.alobot.dummycardviewwithrecyclerview.listeners;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.alobot.dummycardviewwithrecyclerview.R;
import com.alobot.dummycardviewwithrecyclerview.interfaces.RecyclerView_Interface;

public class RecyclerView_Listener implements RecyclerView.OnItemTouchListener {
    private GestureDetector gestureDetector;
    private RecyclerView_Interface recyclerView_Interface;

    public RecyclerView_Listener(Context context, final RecyclerView recyclerView, final RecyclerView_Interface recyclerView_Interface) {
        this.recyclerView_Interface = recyclerView_Interface;
        this.gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                return true;
            }

            @Override
            public void onLongPress(MotionEvent motionEvent) {
                View view = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());

                if (view != null && recyclerView_Interface != null) {
                    recyclerView_Interface.onLongClickCardView(view, recyclerView.getChildPosition(view));
                }
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(final RecyclerView recyclerView, MotionEvent motionEvent) {
        final View view = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());

        if (view != null && recyclerView_Interface != null && gestureDetector.onTouchEvent(motionEvent)) {
            LinearLayout linearLayoutSendCall = (LinearLayout) view.findViewById(R.id.linear_layout_send_call);
            linearLayoutSendCall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    recyclerView_Interface.onClickSendCall(view, recyclerView.getChildPosition(view));
                }
            });

            LinearLayout linearLayoutSendMessage = (LinearLayout) view.findViewById(R.id.linear_layout_send_message);
            linearLayoutSendMessage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    recyclerView_Interface.onClickSendMessage(view, recyclerView.getChildPosition(view));
                }
            });

            LinearLayout linearLayoutCardView = (LinearLayout) view.findViewById(R.id.linear_layout_card_view);
            linearLayoutCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    recyclerView_Interface.onClickCardView(view, recyclerView.getChildPosition(view));
                }
            });
        }

        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
    }
}

