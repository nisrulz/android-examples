package github.nisrulz.example.usingroomorm

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Person {
    @PrimaryKey(autoGenerate = true)
    var uid = 0
    @ColumnInfo(name = "name")
    var name: String = ""
    @ColumnInfo(name = "age")
    var age = 0
    @ColumnInfo(name = "address")
    var address: String = ""
}