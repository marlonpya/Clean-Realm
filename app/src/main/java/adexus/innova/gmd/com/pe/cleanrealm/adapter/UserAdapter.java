package adexus.innova.gmd.com.pe.cleanrealm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import adexus.innova.gmd.com.pe.cleanrealm.R;
import adexus.innova.gmd.com.pe.cleanrealm.model.UserEntity;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by tincio on 25/07/17.
 */

public class UserAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private List<UserEntity> users;

    public UserAdapter(Context context, List<UserEntity> users) {
        this.inflater = LayoutInflater.from(context);
        this.users = users;
    }

    public void add(UserEntity userEntity) {
        this.users.add(userEntity);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int i) {
        return users.get(i);
    }

    @Override
    public long getItemId(int i) {
        return users.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view != null) {
            holder = (ViewHolder) view.getTag();
        } else {
            view = inflater.inflate(R.layout.row_user, viewGroup, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }

        UserEntity userEntity = users.get(i);
        holder.lblName.setText(userEntity.getName());
        holder.lblLastName.setText(userEntity.getLastName());
        holder.lblAge.setText(userEntity.getAge());

        return view;
    }

    public static class ViewHolder {
        @BindView(R.id.lblName) TextView lblName;
        @BindView(R.id.lblLastName) TextView lblLastName;
        @BindView(R.id.lblAge) TextView lblAge;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
