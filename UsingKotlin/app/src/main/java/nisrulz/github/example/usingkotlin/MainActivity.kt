package nisrulz.github.example.usingkotlin

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import nisrulz.github.example.usingkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        with(binding) {
            setContentView(root)
            setupUi(this)
        }
    }

    private fun setupUi(binding: ActivityMainBinding) = with(binding) {

        var stringToDisplay = "Hello Kotlin World!"

        /* Raw string is delimited by using triple quote (""")
         * Raw strings can contain newlines and any other characters.
         */
        var rawStringToDisplay = """
        fun helloWorld(val name : String) {
          println("Hello, world!")
        }
       """

        //The null check can be simplified using safe call operator (?.)
        val number: Int? = null
        // This will be executed only if the number is not null
        number?.toString()

        // Explicitly throw a NullPointerException
        // number!!.toString()


        // Casting in done by using an 'as' keyword, here also using the Safe” cast operator '?' which
        // returns the null value instead of throwing an exception
        val x: String? = number as? String

        /* Static Layout Import
         Kotlin allows you to import all references to views from the layout with one import.

         The TextView from layout is imported as a TextView instance with the name equal to the ID of the view,
         with the name equal to the id in camelCase.

         Note: 1. You don’t need to write semicolons at the end of the lines in Kotlin because they are optional.
               2. When using fragments, make sure imported View references are used after the onCreateView() function call.
                  Import the layout in onCreateView() function and use the View references to setup the UI in onViewCreated().
                  The references won’t be assigned before the onCreateView() method has finished.
         */
        txtHelloworld.text = stringToDisplay


        // Using the kotlin pojo class
        // More info about properties at https://kotlinlang.org/docs/reference/properties.html

        // Initializing using the primary constructor
        val userName = User("Nishant", "Srivastava")

        // Using contructor to initialize the User object and get value using the custom getter
        stringToDisplay += "\n\nUsing primary constructor\n" + "Hello " + userName.fullName

        // Initialize using default setter
        userName.firstName = "Harsh"
        userName.lastName = "Singh"

        stringToDisplay += "\n\nUsing default setter\n" + "Hello " + userName.fullName

        // Create the operator class instance and display it in the activity
        val operator = Operator("John", "Doe")
        stringToDisplay += "\n\nUsing inheritance\n" + "Hello " + operator.fullName

        // Using member function
        stringToDisplay += "\n\nUsing member function of User object\n" + userName.sayHello(
            "Nishant"
        )

        stringToDisplay += "\n\nUsing local member function\n" + add(5, 10)

        // Using a defined kotlin extension
        stringToDisplay += "\n\nUsing kotlin extensions\n" + userName.getUserAge(22)

        stringToDisplay += "\n\nUsing raw string\n$rawStringToDisplay"


        // Set the value in textview
        txtHelloworld.text = stringToDisplay


        /* Using lambdas
           1. if parameters aren’t used, we can leave them out

              btn_toast.setOnClickListener({ toast("Click") })

           2. if the function is the last parameter, it can be moved out of the parentheses

              btn_toast.setOnClickListener() { toast("Click") }

           3. if the function has only one parameter that is a function, parentheses can be left out

              btn_toast.setOnClickListener { toast("Click") }

           More info : https://kotlinlang.org/docs/reference/lambdas.html
         */
        btnToast.setOnClickListener { toast("Click") }
    }


    //region Utility Function
    private fun toast(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
    }

    // Defining a kotlin extension
    // Extension functions don’t modify the original extended class,
    // but are a convenient way of writing utility methods.
    private fun User.getUserAge(age: Int): String {
        return "Age : $age"
    }

    // Defining a function in kotlin
    private fun add(x: Int, y: Int): Int {
        return x + y
    }
    //endregion

}




































