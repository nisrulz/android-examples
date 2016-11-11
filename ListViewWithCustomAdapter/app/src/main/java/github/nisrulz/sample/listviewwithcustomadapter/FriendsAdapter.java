package github.nisrulz.sample.listviewwithcustomadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

public class FriendsAdapter extends BaseAdapter {
    private final Context mContext;
    private List<Friend> mFriends = Collections.EMPTY_LIST;

    public FriendsAdapter(Context mContext, List<Friend> mFriends) {
        this.mContext = mContext;
        this.mFriends = mFriends;
    }

    @Override
    public int getCount() {
        if (mFriends == null || mFriends.size() == 0) {
            return -1;
        }
        return mFriends.size();
    }

    @Override
    public Object getItem(int position) {
        if (mFriends == null || mFriends.size() == 0) {
            return null;
        }
        return mFriends.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater myInflater = LayoutInflater.from(mContext);
            view = myInflater.inflate(R.layout.friend_layout, parent, false);

            ImageView imageView = (ImageView) view.findViewById(R.id.iconID);
            TextView textView = (TextView) view.findViewById(R.id.name);

            textView.setText(mFriends.get(position).getName());
            imageView.setImageResource(mFriends.get(position).getIconID());
        }

        return view;
    }

    public String getFriend(int position) {
        return mFriends.get(position).getName();
    }
}
