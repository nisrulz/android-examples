package github.nisrulz.example.basicmvp

/**
 * The type User.
 */
data class User(val fullName: String = "", val email: String = "") {
    override fun toString(): String {
        return """
            $fullName
            $email
            """.trimIndent()
    }
}