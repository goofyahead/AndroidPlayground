package es.mgl.onfan.pagerAdapter;

import java.util.LinkedList;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.google.inject.Inject;

public class ImagesPageAdapter extends PagerAdapter {
	LinkedList<String> imageUrls;
	@Inject
	Context mContext;
	@Inject
	ImageLoader mImageLoader;
	LayoutInflater inflater;

	public ImagesPageAdapter(LinkedList<String> imageUrls) {
		this.imageUrls = imageUrls;
		inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		return imageUrls.size();
	}

	@Override
	public boolean isViewFromObject(View v, Object o) {
		return v == ((View) o);
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		NetworkImageView view = new NetworkImageView(mContext);
		view.setImageUrl(imageUrls.get(position), mImageLoader);
		container.addView(view, 0);
		return view;
	}

	@Override
	public void setPrimaryItem(ViewGroup container, int position, Object object) {
		NetworkImageView item = (NetworkImageView) object;
		ViewPager pager = (ViewPager) container;
		int width = item.getMeasuredWidth();
		int height = item.getMeasuredHeight();
		pager.setLayoutParams(new FrameLayout.LayoutParams(width, Math.max(height, 1)));
	}

}
