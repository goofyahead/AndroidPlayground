//class must implement on click listener

    private void setOptionsMenu() {
        int texts[] = { R.string.menu_option_created_specialities };
        int drawables[] = { R.drawable.specialty_camera };
        LayoutInflater inflater = (LayoutInflater) this.getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        for (int i = 0; i < texts.length; i++) {
            View option = inflater.inflate(R.layout.option_list_icon_and_text, null);
            ImageView icon = (ImageView) option.findViewById(R.id.options_list_icon);
            TextView text = (TextView) option.findViewById(R.id.option_list_text);

            icon.setImageResource(drawables[i]);
            text.setText(texts[i]);
            option.setOnClickListener(ProfileFragmentDetail.this);
            option.setTag(typeOfOption.SPECIALITY_CREATED);
            holder.addView(option);
        }
    }

//on listener define enum with options and set it on the view tag gen.
   @Override
    public void onClick(View v) {
        switch ((typeOfOption) v.getTag()) {
        case SPECIALITY_CREATED:
            Log.d(TAG, "view specialities from user " + currentUser.getName());
            break;
        default:
            break;
        }
    }