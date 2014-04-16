public class FixedSpeedScroller extends Scroller {

    private int mDuration = 5000;

    public FixedSpeedScroller(Context context) {
        super(context);
    }

    public FixedSpeedScroller(Context context, Interpolator interpolator) {
        super(context, interpolator);
    }

    public FixedSpeedScroller(Context context, Interpolator interpolator, boolean flywheel) {
        super(context, interpolator, flywheel);
    }


    @Override
    public void startScroll(int startX, int startY, int dx, int dy, int duration) {
        // Ignore received duration, use fixed one instead
        super.startScroll(startX, startY, dx, dy, mDuration);
    }

    @Override
    public void startScroll(int startX, int startY, int dx, int dy) {
        // Ignore received duration, use fixed one instead
        super.startScroll(startX, startY, dx, dy, mDuration);
    }
}


// reflection field load
try {
    Field mScroller;
    mScroller = ViewPager.class.getDeclaredField("mScroller");
    mScroller.setAccessible(true); 
    FixedSpeedScroller scroller = new FixedSpeedScroller(mPager.getContext(), sInterpolator);
    // scroller.setFixedDuration(5000);
    mScroller.set(mPager, scroller);
} catch (NoSuchFieldException e) {
} catch (IllegalArgumentException e) {
} catch (IllegalAccessException e) {
}