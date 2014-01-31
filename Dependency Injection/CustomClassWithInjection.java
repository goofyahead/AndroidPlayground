@Inject
	ImageLoader mImageLoader;

	public ExploreViewsAdapter(List<OnfanType> elements, Context mContext) {
		this.mContext = mContext;

		final RoboInjector injector = RoboGuice.getInjector(mContext);
		// This will inject all fields marked with the @Inject annotation
		injector.injectMembersWithoutViews(this);

		this.elements = elements;
		mInflater = (LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}