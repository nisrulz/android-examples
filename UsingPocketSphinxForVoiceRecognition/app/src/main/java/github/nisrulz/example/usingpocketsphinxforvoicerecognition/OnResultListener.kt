package github.nisrulz.example.usingpocketsphinxforvoicerecognition

interface OnResultListener {
    fun onResult(commands: ArrayList<String>?)
}