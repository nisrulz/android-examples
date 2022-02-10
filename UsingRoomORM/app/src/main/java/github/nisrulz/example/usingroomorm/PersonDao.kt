package github.nisrulz.example.usingroomorm

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PersonDao {
    // Adds a person to the database
    @Insert
    fun insertAll(vararg people: Person)

    // Removes a person from the database
    @Delete
    fun delete(person: Person)

    // Gets all people in the database
    @get:Query("SELECT * FROM person")
    val allPeople: List<Person?>?

    // Gets all people in the database with a address
    @Query("SELECT * FROM person WHERE address LIKE :address")
    fun getAllPeopleWithAddress(address: String): List<Person?>?
}