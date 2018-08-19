package github.nisrulz.sample.awesomelib;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;

public class AwesomeLibInitProvider extends ContentProvider {

    public AwesomeLibInitProvider() {
    }

    @Override
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        if (providerInfo == null) {
            throw new NullPointerException("YourLibraryInitProvider ProviderInfo cannot be null.");
        }
        // So if the authorities equal the library internal ones, the developer forgot to set his applicationId
        String libAuthorityString = "github.nisrulz.sample.awesomelib.awesomelibinitprovider";
        if (libAuthorityString.equals(providerInfo.authority)) {
            throw new IllegalStateException("Incorrect provider authority[" + libAuthorityString + "]" +
                    " in manifest. " +
                    "Most likely due to a "
                    + "missing applicationId variable in application\'s build.gradle.");
        }
        super.attachInfo(context, providerInfo);
    }

    @Override
    public boolean onCreate() {

        // get the context (Application context)
        Context context = getContext();
        // initialize AwesomeLib  here
        AwesomeLib.getInstance().init(context);

        return false;
    }


    @Override
    public String getType(Uri uri) {
        return null;
    }


    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        return 0;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }
}
