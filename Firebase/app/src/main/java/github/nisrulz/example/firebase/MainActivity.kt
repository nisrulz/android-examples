package github.nisrulz.example.firebase

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*
import github.nisrulz.example.firebase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var rootRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.apply {
            setContentView(root)
            setSupportActionBar(toolbar)
        }

        setupFirebase()
        setupClickListener()
        setupFirebaseDatabaseListener()
    }

    private fun setupFirebase() {
        FirebaseDatabase.getInstance().setPersistenceEnabled(true)
        rootRef = FirebaseDatabase.getInstance().reference
    }

    private fun setupClickListener() {
        binding.fab.setOnClickListener { // On Click
            // Write data to Firebase Database
            rootRef.child("message").setValue("Do you have data? You'll love Firebase.")
        }
    }

    private fun setupFirebaseDatabaseListener() {
        // Read data from Firebase Database
        rootRef.child("message").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                println(dataSnapshot.value) //prints "Do you have data? You'll love Firebase."
                binding.container.messageTextView.text = dataSnapshot.value.toString()
            }

            override fun onCancelled(databaseError: DatabaseError) {}
        })
    }
}
