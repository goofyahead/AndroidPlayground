 InputMethodManager imm=
      (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);

  imm.hideSoftInputFromWindow(v.getWindowToken(), 0);