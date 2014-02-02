//fragments receive params through new instance, save them on bundle and keep execution.
//serializable is slower than parcelable, review libraries for parcelable bolierplate @parcel

    public static ProfileFragmentDetail newInstance(int profileId) {
        ProfileFragmentDetail myFragment = new ProfileFragmentDetail();

        Bundle args = new Bundle();
        args.putInt(PROFILE_ID, profileId);
        myFragment.setArguments(args);

        return myFragment;
    }

    public static ProfileFragmentDetail newInstance(OnfanUser user) {
        ProfileFragmentDetail myFragment = new ProfileFragmentDetail();

        Bundle args = new Bundle();
        args.putSerializable(PROFILE, user);
        myFragment.setArguments(args);

        return myFragment;
    }