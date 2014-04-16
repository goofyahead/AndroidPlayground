 //REQUIRES Google Play Services lib

 try {
        Intent intent = AccountPicker.newChooseAccountIntent(null, null,
                new String[] { GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE }, false, null, null, null, null);
        startActivityForResult(intent, REQUEST_CODE_EMAIL);
    } catch (ActivityNotFoundException e) {
        // TODO
    }


@Override
protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
    if (requestCode == REQUEST_CODE_EMAIL && resultCode == RESULT_OK) {
        String accountName = data.getStringExtra(AccountManager.KEY_ACCOUNT_NAME);
        email.setText(accountName);
    }
}