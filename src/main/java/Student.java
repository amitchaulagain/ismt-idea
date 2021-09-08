public class Student {
    int id ;
    String firstName;
    String lastName;
    String email;
    String phone;

    public int getId() {
        return id;
    }

    public Student setId(int id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Student setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Student setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Student setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Student setPhone(String phone) {
        this.phone = phone;
        return this;
    }
}
