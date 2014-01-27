public class TabHostActivity extends RoboFragmentActivity {
	private FragmentTabHost mTabHost;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.tabhost);
		mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
		mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

		View exploreTab = LayoutInflater.from(this).inflate(R.layout.timeline_tab, null);
		ImageView exploreIcon = (ImageView) exploreTab.findViewById(R.id.timeline_tab_icon_imageView);
		exploreIcon.setImageResource(R.drawable.tabbar_explore);
		
		View timelineTab = LayoutInflater.from(this).inflate(R.layout.timeline_tab, null);
		ImageView timelineIcon = (ImageView) timelineTab.findViewById(R.id.timeline_tab_icon_imageView);
		timelineIcon.setImageResource(R.drawable.tabbar_timeline);

		View createTab = LayoutInflater.from(this).inflate(R.layout.timeline_tab, null);
		ImageView createIcon = (ImageView) createTab.findViewById(R.id.timeline_tab_icon_imageView);
		createIcon.setImageResource(R.drawable.create_action);

		View profileTab = LayoutInflater.from(this).inflate(R.layout.timeline_tab, null);
		ImageView profileIcon = (ImageView) profileTab.findViewById(R.id.timeline_tab_icon_imageView);
		profileIcon.setImageResource(R.drawable.tabbar_profile);
		
		View searchTab = LayoutInflater.from(this).inflate(R.layout.timeline_tab, null);
		ImageView searchIcon = (ImageView) searchTab.findViewById(R.id.timeline_tab_icon_imageView);
		searchIcon.setImageResource(R.drawable.tabbar_search);
		
		mTabHost.addTab(mTabHost.newTabSpec("explore").setIndicator(exploreTab), ExploreFragment.class, null);
		mTabHost.addTab(mTabHost.newTabSpec("timeline").setIndicator(timelineTab), TimelineFragment.class, null);
		mTabHost.addTab(mTabHost.newTabSpec("create").setIndicator(createTab), CreateFragment.class, null);
		mTabHost.addTab(mTabHost.newTabSpec("profile").setIndicator(profileTab), ProfileFragment.class, null);
		mTabHost.addTab(mTabHost.newTabSpec("search").setIndicator(searchTab), SearchFragment.class, null);
	}
}