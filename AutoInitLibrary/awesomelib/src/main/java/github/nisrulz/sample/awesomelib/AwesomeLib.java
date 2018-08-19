package github.nisrulz.sample.awesomelib;

import android.content.Context;

public class AwesomeLib {
    private static final AwesomeLib ourInstance = new AwesomeLib();

    public static AwesomeLib getInstance() {
        return ourInstance;
    }

    private AwesomeLib() {
    }

    private Context context;

    public void init(Context context) {

        this.context = context;
    }

    public String getStringData() {
        return (context != null) ? context.getString(R.string.string_from_init) : "";
    }
}
