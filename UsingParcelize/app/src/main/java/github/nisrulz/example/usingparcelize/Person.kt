package github.nisrulz.example.usingparcelize

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person(
    val name: String = "",
    val address: String = "",
    val age: Int = 0,
    val occupation: String = ""
) : Parcelable {

    override fun toString(): String {
        return "Name: $name" +
                "\nAge: $age" +
                "\nAddress: $address" +
                "\nOccupation: $occupation"
    }
}