package github.nisrulz.example.usingtimberlogger

import timber.log.Timber

class LineNumberDebugTree : Timber.DebugTree() {
    // Add line numbers to logs
    override fun createStackElementTag(element: StackTraceElement): String {
        return super.createStackElementTag(element) + ":" + element.lineNumber
    }
}