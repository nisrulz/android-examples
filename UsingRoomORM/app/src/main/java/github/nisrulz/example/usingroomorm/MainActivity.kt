package github.nisrulz.example.usingroomorm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import github.nisrulz.example.usingroomorm.databinding.ActivityMainBinding
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {
    private lateinit var db: AppDatabase
    private val dao by lazy { db.personDao }
    private val executor: ExecutorService = Executors.newSingleThreadExecutor()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        with(binding) {
            setContentView(root)
            createDb()
            insertSomeDummyData(executor)
            retrieveData(this, executor)
        }
    }

    private fun createDb() {
        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "people-db"
        ).build()
    }

    private fun insertSomeDummyData(executor: ExecutorService) {
        for (i in 0..9) {
            Person().apply {
                name = "Person-$i"
                age = 18 + i
                address = "Address-$i"
            }.also {
                // Do not run db operations on the main thread
                // Using the executor service to run it off the main thread
                executor.execute { dao?.insertAll(it) }
            }
        }
    }

    private fun retrieveData(binding: ActivityMainBinding, executor: ExecutorService) {
        // Do not run db operations on the main thread
        // Using the executor service to run it off the main thread
        executor.execute {
            val everyone = dao?.allPeople
            var str = ""
            everyone?.let {
                for (i in everyone.indices) {
                    str += buildString {
                        append("\n> Row ")
                        append(i)
                        append(" : ")
                        append("UID-")
                        append(everyone[i]?.uid)
                        append(", ")
                        append(everyone[i]?.name)
                        append(", ")
                        append(everyone[i]?.address)
                        append(", ")
                        append(everyone[i]?.age)
                    }
                }
            }
            binding.textView.text = str
        }
    }
}