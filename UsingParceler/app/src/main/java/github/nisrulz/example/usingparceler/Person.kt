package github.nisrulz.example.usingparceler

import org.parceler.Parcel

// When using Parceler Lib with Kotlin Data class, one must provide default values
// to make it work.
// Ref: https://stackoverflow.com/a/33892435/2745762
@Parcel
data class Person(
    val name: String = "",
    val address: String = "",
    val age: Int = 0,
    val occupation: String = ""
) {
    override fun toString() = buildString {
        append("Name : ")
        append(name)
        append("\n")
        append("Address : ")
        append(address)
        append("\n")
        append("Age : ")
        append(age)
        append("\n")
        append("Occupation : ")
        append(occupation)
    }

}