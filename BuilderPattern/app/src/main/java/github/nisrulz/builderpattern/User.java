package github.nisrulz.builderpattern;

class User {

    private String firstname;
    private String lastname;
    private String phone;
    private String address;
    private int age;

    /**
     * Instantiates a new User.
     *
     * @param builder the builder
     */
    public User(UserBuilder builder) {
        this.firstname = builder.firstname;
        this.lastname = builder.lastname;
        this.age = builder.age;
        this.phone = builder.phone;
        this.address = builder.address;
    }

    /**
     * Gets address.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Gets age.
     *
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * Gets firstname.
     *
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Gets lastname.
     *
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Gets phone.
     *
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }


    /**
     * The type User builder.
     */
    public static class UserBuilder {
        private String firstname;
        private String lastname;
        private String phone;
        private String address;
        private int age;

        /**
         * Instantiates a new User builder.
         *
         * @param firstname the firstname
         * @param lastname  the lastname
         */
        public UserBuilder(String firstname, String lastname) {
            this.firstname = firstname;
            this.lastname = lastname;
        }

        /**
         * Age user builder.
         *
         * @param age the age
         * @return the user builder
         */
        public UserBuilder age(int age) {
            this.age = age;
            return this;
        }

        /**
         * Address user builder.
         *
         * @param address the address
         * @return the user builder
         */
        public UserBuilder address(String address) {
            this.address = address;
            return this;
        }

        /**
         * Phone user builder.
         *
         * @param phone the phone
         * @return the user builder
         */
        public UserBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        /**
         * Build user.
         *
         * @return the user
         */
        public User build() {
            User user = new User(this);
            if (user.getAge() > 25) {
                throw new IllegalArgumentException("Age cannot be more than 25!");
            }
            return user;
        }
    }

    /**
     * Log user data string.
     *
     * @return the string
     */
    public String logUserData() {
        return "First Name :" + firstname + ", Last Name :" + lastname + ", Age :" + age + ", Phone " + phone
                + ", Address :" + address;
    }
}
