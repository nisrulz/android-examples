package github.nisrulz.example.usingrxjava

data class GistFile(val content: String = "n/a")

data class Gist(val files: Map<String, GistFile> = emptyMap())
