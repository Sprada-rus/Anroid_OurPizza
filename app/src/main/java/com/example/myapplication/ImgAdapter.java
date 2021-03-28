package com.example.myapplication;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ImgAdapter extends RecyclerView.Adapter<ImgAdapter.ViewHolder> {

    private String[] captions;
    private int[] id;
    private Listener listener;

    public interface Listener{
        public void onClick(int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private CardView card;

        public ViewHolder(CardView view){
            super(view);
            card = view;
        }
    }


    public ImgAdapter(String[] captions, int[] id){
        this.captions = captions;
        this.id = id;
    }

    @Override
    public int getItemCount(){
        return captions.length;
    }

    public void setListener(Listener listener){
        this.listener = listener;
    }

    @Override
    public ImgAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        CardView cardView = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        return new ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position){
        CardView cardView = holder.card;
        int pos = position;
        ImageView imageView = (ImageView) cardView.findViewById(R.id.photo);
        Drawable drawable = ContextCompat.getDrawable(cardView.getContext(), id[position]);
        imageView.setImageDrawable(drawable);
        imageView.setContentDescription(captions[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        TextView text = (TextView) cardView.findViewById(R.id.caption_text);
        text.setText(captions[position]);
        text.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        text.setPadding(4,4,4,4);

        cardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if (listener != null){
                    listener.onClick(pos);
                }
            }
        });
    }


}
