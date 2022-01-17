package github.nisrulz.example.awesomelib

object AwesomeLib {
    var stringData: String = "n/a"
        private set

    fun initLibrary() {
        stringData = "String updated from initLibrary() method"
    }
}