public class CustomConfigModule extends AbstractModule {

	@Override
	protected void configure() {
		Context mContext = OnfanApplication.getContext();

		OnfanApi onfanApi = new OnfanApi();
		OnfanAPIMock onfanMock = new OnfanAPIMock();

		RequestQueue mRequestQueue = Volley.newRequestQueue(mContext);
		int memClass = ((ActivityManager) mContext
				.getSystemService(Context.ACTIVITY_SERVICE)).getMemoryClass();
		// Use 1/8th of the available memory for this memory cache.
		int cacheSize = 1024 * 1024 * memClass / 8;
		ImageLoader mImageLoader = new ImageLoader(mRequestQueue,
				new BitmapLruCache(cacheSize));

		bind(OnfanApiIntefrace.class).toInstance(onfanMock);
		bind(ImageLoader.class).toInstance(mImageLoader);
		bind(RequestQueue.class).toInstance(mRequestQueue);

	}

}
