import com.google.inject.Inject;

//Uses RoboGuice for constructor injection, defined in Custom module.

public class AppPreferences {

	    private static final String REGISTERED = "user_registered";

	    private SharedPreferences prefs;

	    @Inject
	    public AppPreferences(Context context) {
	        prefs = PreferenceManager.getDefaultSharedPreferences(context);
	    }

	    public boolean isRegistered (){
	        return prefs.getBoolean(REGISTERED, false);
	    }

	    public void setToken(boolean token) {
	        prefs.edit().putBoolean(REGISTERED, token).commit();
	    }
}