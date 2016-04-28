package sample.github.nisrulz.interprocessservice;

import android.util.Log;

public class LogHelper {
    static int pid;
    static long tid;
    static StringBuilder data;

    public static void log(String label, String value) {
        pid = android.os.Process.myPid();
        tid = Thread.currentThread().getId();

        data = new StringBuilder();
        data.append("Process :").append(pid)
                .append(" Thread :").append(tid)
                .append(" Value received : ").append(value);
        Log.d(label, data.toString());

    }
}
