package com.adammcneilly.retrofitsample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Adapter that displays a list of presidents.
 *
 * Created by adam.mcneilly on 8/31/16.
 */
public class PresidentAdapter extends BaseAdapter {
    private Context context;
    private Presidents presidents;

    public PresidentAdapter(Context context, Presidents presidents) {
        this.context = context;
        this.presidents = presidents;
    }

    @Override
    public int getCount() {
        return presidents.presidents.size();
    }

    @Override
    public Object getItem(int i) {
        return presidents.presidents.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        PresidentViewHolder viewHolder;

        if(view != null) {
            viewHolder = (PresidentViewHolder) view.getTag();
        } else {
            view = LayoutInflater.from(context).inflate(R.layout.list_item_president, viewGroup, false);
            viewHolder = new PresidentViewHolder(view);
            view.setTag(viewHolder);
        }

        viewHolder.bindPresident(presidents.presidents.get(i));

        return view;
    }

    public void swapPresidents(Presidents presidents) {
        this.presidents = presidents;
        notifyDataSetChanged();
    }

    public class PresidentViewHolder {
        private final TextView presidentName;

        public PresidentViewHolder(View view) {
            presidentName = (TextView) view.findViewById(R.id.president_name);
        }

        public void bindPresident(Person president) {
            presidentName.setText(president.getFullName());
        }
    }
}
