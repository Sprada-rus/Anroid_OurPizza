package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class PizzaFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView recycler = (RecyclerView) inflater.inflate(R.layout.fragment_pizza, container, false);

        String[] pizzaName = new String[Pizza.pizzas.length];
        for (int i = 0; i < pizzaName.length; i++){
            pizzaName[i] = Pizza.pizzas[i].getName();
        }

        int[] id = new int[Pizza.pizzas.length];
        for (int i = 0; i < id.length; i++){
            id[i] = Pizza.pizzas[i].getImgId();
        }

        ImgAdapter adapter = new ImgAdapter(pizzaName, id);
        recycler.setAdapter(adapter);

        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        recycler.setLayoutManager(layoutManager);

        adapter.setListener(new ImgAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), PizzaDetailActivity.class);
                intent.putExtra(PizzaDetailActivity.EXTRA_PIZZA_ID, position);
                startActivity(intent);
            }
        });

        return recycler;
    }
}