package github.nisrulz.example.builderpattern

internal class User(builder: UserBuilder) {
    /**
     * Gets firstname.
     *
     * @return the firstname
     */
    val firstname: String = builder.firstname

    /**
     * Gets lastname.
     *
     * @return the lastname
     */
    val lastname: String = builder.lastname

    /**
     * Gets phone.
     *
     * @return the phone
     */
    val phone: String? = builder.phone

    /**
     * Gets address.
     *
     * @return the address
     */
    val address: String? = builder.address

    /**
     * Gets age.
     *
     * @return the age
     */
    val age: Int = builder.age

    /**
     * The type User builder.
     */
    class UserBuilder(val firstname: String, val lastname: String) {
        var phone: String? = null
        var address: String? = null
        var age = 0

        /**
         * Age user builder.
         *
         * @param age the age
         * @return the user builder
         */
        fun age(age: Int): UserBuilder {
            this.age = age
            return this
        }

        /**
         * Address user builder.
         *
         * @param address the address
         * @return the user builder
         */
        fun address(address: String?): UserBuilder {
            this.address = address
            return this
        }

        /**
         * Phone user builder.
         *
         * @param phone the phone
         * @return the user builder
         */
        fun phone(phone: String?): UserBuilder {
            this.phone = phone
            return this
        }

        /**
         * Build user.
         *
         * @return the user
         */
        fun build(): User {
            val user = User(this)
            require(user.age <= 25) { "Age cannot be more than 25!" }
            return user
        }
    }

    /**
     * Log user data string.
     *
     * @return the string
     */
    fun logUserData(): String {
        return ("First Name :" + firstname + ", Last Name :" + lastname + ", Age :" + age + ", Phone " + phone
                + ", Address :" + address)
    }
}