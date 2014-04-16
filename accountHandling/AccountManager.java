Pattern emailPattern = Patterns.EMAIL_ADDRESS; // API level 8+
Account[] accounts = AccountManager.get(context).getAccounts();
for (Account account : accounts) {
    if (emailPattern.matcher(account.name).matches()) {
        String possibleEmail = account.name;
        ...
    }
}


// in manifest

<uses-permission android:name="android.permission.GET_ACCOUNTS" />