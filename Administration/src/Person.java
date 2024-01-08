public class Person {

    public String Firstname;
    public String Lastname;
    public String Email;

    public Person(String Lastname, String Firstname, String Email) {
        this.setFirstname(Firstname);
        this.setLastname(Lastname);
        this.setEmail(Email);
    }

    public String getFirstname() {
        return this.Firstname;
    }

    public void setFirstname(String Firstname) {
        this.Firstname = Firstname;
    }

    public String getLastname() {
        return this.Lastname;
    }

    public void setLastname(String Lastname) {
        this.Lastname = Lastname;
    }

    public String getEmail() {
        return this.Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    @Override
    public String toString() {
        return String.format("Person: Firstname=%s, Lastname=%s, Email=%s", this.Firstname, this.Lastname, this.Email);
    }

    public String writeEmail() {
        return "message body";
    }

}
