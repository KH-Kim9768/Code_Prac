package com.example.cardtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Card01_ViewPagerAdapter extends RecyclerView.Adapter<Card01_ViewPagerAdapter.ViewHolderPage>{

    private ArrayList<Integer> listData;
    private OnItemClickListener listener;

    public Card01_ViewPagerAdapter(ArrayList<Integer> data) {
        this.listData = data;
    }

    @NonNull
    @Override
    public ViewHolderPage onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.deco_viewpager_page, parent, false);

        return new ViewHolderPage(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPage holder, int position) {
        if( holder instanceof ViewHolderPage){
            ViewHolderPage viewHolderPage = holder;
            Integer[] imageIds = new Integer[6];
            for(int i = 0; i < 6 && 6 * position+i<listData.size(); i++) {
                imageIds[i] = listData.get(6* position + i);
            }
            viewHolderPage.onBind(imageIds);
        }

    }

    @Override
    public int getItemCount() {
        return listData.size()/6;
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }

    static public interface OnItemClickListener {
        public void click(int index);
    }

    static public class ViewHolderPage extends RecyclerView.ViewHolder{
        private final OnItemClickListener listener;
        private ImageButton[] itemIamges;

        ViewHolderPage(View itemView, OnItemClickListener listener){
            super(itemView);
            this.listener = listener;

            itemIamges = new ImageButton[6];
            itemIamges[0] = itemView.findViewById(R.id.grid_img_btn_1);
            itemIamges[1] = itemView.findViewById(R.id.grid_img_btn_2);
            itemIamges[2] = itemView.findViewById(R.id.grid_img_btn_3);
            itemIamges[3] = itemView.findViewById(R.id.grid_img_btn_4);
            itemIamges[4] = itemView.findViewById(R.id.grid_img_btn_5);
            itemIamges[5] = itemView.findViewById(R.id.grid_img_btn_6);


        }

        public void onBind(Integer[] position){
            for(int i = 0; i<6; i++){
                itemIamges[i].setImageResource(position[i]);
                if (listener != null){
                    int finalI = i;
                    itemIamges[i].setOnClickListener(view -> {
                        if (this.listener != null){
                            listener.click(finalI);
                        }
                    });
                }
            }
        }
    }
}
