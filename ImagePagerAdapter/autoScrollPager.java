private Handler handler = new Handler();
private Runnable runnable = new Runnable() {
    public void run() {
            if( position >= 4){
                position = 0;
            }else{
                position = position+1;
            }
            toBarPager.setCurrentItem(position, true);
            handler.postDelayed(runnable, 10000);
    }
};

// with adapter

 runnable = new Runnable() {
            public void run() {
                if (slider.getCurrentItem() == slider.getAdapter().getCount() - 1) {
                    slider.setCurrentItem(0, true);
                } else {
                    slider.setCurrentItem(slider.getCurrentItem() + 1, true);
                }
            }
        };
        
 handler.postDelayed(runnable, SLIDER_TIME);

// On pause resume, actions

@Override
public void onPause() {
    super.onPause();
    if (handler!= null) {
        handler.removeCallbacks(runnable);
    }
}

@Override
public void onResume() {
    super.onResume();  // Always call the superclass method first
    handler.postDelayed(runnable, 10000);
}