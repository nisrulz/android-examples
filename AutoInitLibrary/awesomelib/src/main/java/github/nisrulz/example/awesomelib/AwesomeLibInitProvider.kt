package github.nisrulz.example.awesomelib

import android.content.ContentProvider
import android.content.ContentValues
import android.content.Context
import android.content.pm.ProviderInfo
import android.database.Cursor
import android.net.Uri

class AwesomeLibInitProvider : ContentProvider() {
    override fun attachInfo(context: Context, providerInfo: ProviderInfo) {
        if (providerInfo == null) {
            throw NullPointerException("YourLibraryInitProvider ProviderInfo cannot be null.")
        }
        // So if the authorities equal the library internal ones, the developer forgot to set his applicationId
        val libAuthorityString = "github.nisrulz.example.awesomelib.awesomelibinitprovider"
        check(libAuthorityString != providerInfo.authority) {
            ("Incorrect provider authority[" + libAuthorityString + "]" +
                    " in manifest. " +
                    "Most likely due to a "
                    + "missing applicationId variable in application\'s build.gradle.")
        }
        super.attachInfo(context, providerInfo)
    }

    override fun onCreate(): Boolean {

        // get the context (Application context)
        val context = context
        // initialize AwesomeLib  here
        AwesomeLib.initLibrary()
        return false
    }

    override fun getType(uri: Uri): String? {
        return null
    }

    override fun query(
        uri: Uri, projection: Array<String>?, selection: String?,
        selectionArgs: Array<String>?, sortOrder: String?
    ): Cursor? {
        return null
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        return null
    }

    override fun update(
        uri: Uri, values: ContentValues?, selection: String?,
        selectionArgs: Array<String>?
    ): Int {
        return 0
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int {
        return 0
    }
}