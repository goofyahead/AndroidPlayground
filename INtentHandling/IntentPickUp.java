Intent target = new Intent(Intent.ACTION_VIEW);
                    target.setDataAndType(Uri.parse(mBook.getUrl()), "text/html");
                    target.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);

                    Intent intent = Intent.createChooser(target, "Open File");
                    try {
                        startActivity(intent);
                    } catch (ActivityNotFoundException e) {
                        // Instruct the user to install a PDF reader here, or
                        // something
                    }