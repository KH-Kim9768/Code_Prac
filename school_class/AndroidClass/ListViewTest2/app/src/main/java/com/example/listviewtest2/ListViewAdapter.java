package com.example.listviewtest2;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter implements Filterable {
    // Adapter에 추가된 데이터를 저장하기 위한 ArrayList. (원본 데이터 리스트)
    private ArrayList<ListViewItem> listViewItemList = new ArrayList<ListViewItem>();
    // 필터링된 결과 데이터를 저장하기 위한 ArrayList. 최초에는 전체 리스트 보유 (listViewItemList)
    private ArrayList<ListViewItem> filteredItemList = listViewItemList;

    Filter listFilter;

    // ListViewAdapter의 생성자
    public ListViewAdapter(){

    }

    @Override
    public int getCount(){  // Adapter에 사용되는 데이터의 개수를 리턴 - 필수 구현
        return filteredItemList.size();
    }

    @Override   // position에 위치한 데이터를 화면에 출력하는데 사용될 View 를 리턴 - 필수 구현
    public View getView(int position, View convertView, ViewGroup parent){
        final int pos = position;
        final Context context = parent.getContext();

        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_item, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate 된)으로부터 위젯에 대한 참조 획득
        ImageView iconImageView = (ImageView) convertView.findViewById(R.id.imageView1);
        TextView titleTextView = (TextView) convertView.findViewById(R.id.textView1);
        TextView descTextView = (TextView) convertView.findViewById(R.id.textView2);

        // Data Set(filteredItemList)에서 position에 위치한 데이터 참조 획득
        ListViewItem listViewItem = filteredItemList.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        iconImageView.setImageDrawable(listViewItem.getIcon());
        titleTextView.setText(listViewItem.getTitle());
        descTextView.setText(listViewItem.getDesc());

        return convertView;
    }

    @Override   // 지정한 position에 있는 데이터와 관계된 아이템(row)의 ID를 리턴  - 필수 구현
    public long getItemId(int position){
        return position;
    }

    @Override   // 지정한 position에 있는 데이터 리턴 - 필수 구현
    public Object getItem(int position){
        return filteredItemList.get(position);
    }

    // 아이템 데이터 추가를 위한 함수, 개발자가 원하는대로 작성 가능
    public void addItem(Drawable icon, String title, String desc){
        ListViewItem item = new ListViewItem();

        item.setIcon(icon);
        item.setTitle(title);
        item.setDesc(desc);

        listViewItemList.add(item);
    }

    // Filterable 인터페이스의 getFilter()함수 Override
    @Override
    public Filter getFilter() {
        if (listFilter == null){
            listFilter = new ListFilter();
        }
        return listFilter;
    }

    // 커스텀 Filter 클래스 정의, 구현 (Filter - 추상클래스)
    private class ListFilter extends Filter{
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            // 필터링을 수행하는 함수, 필터링을 수행하는 루프를 이 함수에 구현한 다음, 필터링된 결과 리스트를 FilterResults에 담아서 리턴
            FilterResults results = new FilterResults();

            if (charSequence == null || charSequence.length() == 0){
                results.values = listViewItemList;
                results.count = listViewItemList.size();
            } else{
                ArrayList<ListViewItem> itemList = new ArrayList<ListViewItem>(); // 리스트뷰 항목들의 리스트

                for (ListViewItem item : listViewItemList){ // 필터링 하는 부분
                    if(item.getTitle().toUpperCase().contains(charSequence.toString().toUpperCase()) ||
                        item.getDesc().toUpperCase().contains(charSequence.toString().toUpperCase())){
                        itemList.add(item);
                    }
                }

                results.values = itemList;
                results.count = itemList.size();
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults results) {
            // performFiltering() 함수에서 필터링된 결과를 UI에 갱신시키는 역할을 수행, ListView 갱신 작업을 구현하면 됨

            // Filtered 아이템리스트 update
            filteredItemList = (ArrayList<ListViewItem>) results.values;

            // notify
            if (results.count > 0){
                notifyDataSetChanged();
            } else {
                notifyDataSetInvalidated();
            }
        }
    }
}
