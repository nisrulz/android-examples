package github.nisrulz.example.usingroomorm

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Person::class /*, AnotherEntityType::class, AThirdEntityType::class */],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract val personDao: PersonDao?
}