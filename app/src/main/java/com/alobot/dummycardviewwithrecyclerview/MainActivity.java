package com.alobot.dummycardviewwithrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.alobot.dummycardviewwithrecyclerview.adapters.RecyclerView_Adapter;
import com.alobot.dummycardviewwithrecyclerview.interfaces.RecyclerView_Interface;
import com.alobot.dummycardviewwithrecyclerview.listeners.RecyclerView_Listener;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_main);

        // Use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        // mLayoutManager.scrollToPosition(5);
        mAdapter = new RecyclerView_Adapter(getApplicationContext(), new String[]{"Alessandry Cruz", "Alessandry Cruz",
                "Alessandry Cruz", "Alessandry Cruz", "Alessandry Cruz", "Alessandry Cruz",
                "Alessandry Cruz", "Alessandry Cruz", "Alessandry Cruz", "Alessandry Cruz",
                "Alessandry Cruz", "Alessandry Cruz", "Alessandry Cruz", "Alessandry Cruz",
                "Alessandry Cruz", "Alessandry Cruz", "Alessandry Cruz", "Alessandry Cruz",});
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnItemTouchListener(new RecyclerView_Listener(getApplicationContext(), mRecyclerView, new RecyclerView_Interface() {
            @Override
            public void onClickSendCall(View view, int position) {
                Toast.makeText(getApplicationContext(), "onClickSendCall(): " + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onClickSendMessage(View view, int position) {
                Toast.makeText(getApplicationContext(), "onClickSendMessage(): " + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onClickCardView(View view, int position) {
                Toast.makeText(getApplicationContext(), "onClickCardView(): " + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClickCardView(View view, int position) {
                Toast.makeText(getApplicationContext(), "onLongClickCardView(): " + position, Toast.LENGTH_SHORT).show();
            }
        }));
    }
}
