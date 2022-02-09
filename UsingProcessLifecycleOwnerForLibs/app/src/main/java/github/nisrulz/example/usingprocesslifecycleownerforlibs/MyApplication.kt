package github.nisrulz.example.usingprocesslifecycleownerforlibs

import android.app.Application
import androidx.lifecycle.ProcessLifecycleOwner
import github.nisrulz.android_lib.MyLib

class MyApplication : Application() {
    lateinit var mylib: MyLib

    override fun onCreate() {
        super.onCreate()

        // setup process lifecycle tracking
        mylib = MyLib(ProcessLifecycleOwner.get().lifecycle)
    }
}