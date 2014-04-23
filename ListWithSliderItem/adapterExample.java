package es.mgl.hai.adapters;

import java.util.ArrayList;

import roboguice.RoboGuice;
import roboguice.inject.RoboInjector;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.google.inject.Inject;

import es.mgl.hai.R;
import es.mgl.hai.fragments.NewsDetailFragment;
import es.mgl.hai.models.ModelTypes;
import es.mgl.hai.models.News;

public class NewsAdapter extends BaseAdapter {
    protected static final String TAG = NewsAdapter.class.getName();
    private ArrayList<ModelTypes> elements;
    private LayoutInflater mInflater;
    @Inject
    ImageLoader mImageLoader;
    private Context mContext;
    private FragmentActivity fragmentActivity;

    public NewsAdapter(ArrayList<ModelTypes> elements, Context context) {
        this.elements = elements;
        this.mInflater = LayoutInflater.from(context);
        this.mContext = context;
        fragmentActivity = (FragmentActivity) context;
        final RoboInjector injector = RoboGuice.getInjector(context);
        injector.injectMembersWithoutViews(this);
    }

    @Override
    public int getCount() {
        return elements.size();
    }

    @Override
    public Object getItem(int position) {
        return elements.get(position);
    }

    @Override
    public long getItemId(int position) {
        return ((News) elements.get(position)).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        News current = (News) getItem(position);
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.news_list_item, null);
            holder.tittle = (TextView) convertView.findViewById(R.id.news_list_item_title);
            holder.description = (TextView) convertView.findViewById(R.id.news_list_item_description);
            holder.image = (NetworkImageView) convertView.findViewById(R.id.news_list_item_image);
            holder.icon = (ImageView) convertView.findViewById(R.id.news_list_item_favorite);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        if (position % 2 == 0) {
            convertView.setBackgroundColor(mContext.getResources().getColor(R.color.background));
            holder.tittle.setTextColor(mContext.getResources().getColor(R.color.grayBackground));
        } else {
            convertView.setBackgroundColor(mContext.getResources().getColor(R.color.grayBackground));
            holder.tittle.setTextColor(mContext.getResources().getColor(R.color.background));
        }
        holder.tittle.setText(current.getTitle());
        holder.description.setText(current.getDescription());
        holder.image.setImageUrl(current.getImage(), mImageLoader);
        holder.id = current.getId();
        convertView.setOnTouchListener(gestureListener);
        convertView.setPadding(0, 0, 0, 0);
        return convertView;
    }

    class ViewHolder {
        public int id;
        public NetworkImageView image;
        public TextView tittle;
        public TextView description;
        public boolean running;
        public ImageView icon;
    }

    OnTouchListener gestureListener = new View.OnTouchListener() {
        private int padding = 0;
        private int initialx = 0;
        private int currentx = 0;
        private ViewHolder viewHolder;

        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                Log.d(TAG, "DOWN" + padding);
                padding = 0;
                initialx = (int) event.getX();
                currentx = (int) event.getX();
                viewHolder = ((ViewHolder) v.getTag());
                return true;
            case MotionEvent.ACTION_CANCEL:
                // put all to 0
                break;
            case MotionEvent.ACTION_MOVE:
                currentx = (int) event.getX();
                padding = currentx - initialx;
                if (viewHolder != null) {

                    if (padding < -75) {
                        viewHolder.running = false;
                        v.setBackgroundColor(0xFFFF0000);
                        v.setPadding(padding, 0, 0, 0);
                    }
                }
                return true;
            case MotionEvent.ACTION_UP:
                Log.d(TAG, "UP" + padding);
                if (padding > -75) {
                    int id = viewHolder.id;
                    FragmentTransaction ft = fragmentActivity.getSupportFragmentManager().beginTransaction();
                    NewsDetailFragment book = NewsDetailFragment.newInstance(id);
                    ft.add(R.id.news_category_holder, book);
                    ft.addToBackStack("fasdf");
                    ft.commit();
                    Log.d(TAG, "perform click");
                }
                break;
            }
            return false;

        }
    };
}
