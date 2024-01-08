public class Lecturer extends Person{
    public int EmployYear;
    public double Salary;

    public Lecturer(String lastname, String firstname, String email, double Salary, int EmployYear) {
        super(lastname, firstname, email);
        this.setSalary(Salary);
        this.setEmployYear(EmployYear);
    }

    public int getEmployYear() {
        return this.EmployYear;
    }

    public void setEmployYear(int EmployYear) {
        this.EmployYear = EmployYear;
    }

    public double getSalary() {
        return this.Salary;
    }

    public void setSalary(double Salary) {
        this.Salary = Salary;
    }

    @Override
    public String toString() {
        return String.format("Lecturer: Firstname=%s, Lastname=%s, Email=%s, Salary=%f, EmployYear=%d", super.Firstname, super.Lastname, super.Email, this.Salary, this.EmployYear);
    }

    @Override
    public String writeEmail(){
        return String.format("TO: %s\n" +
                "Dear lecturer %s %s,\n" +
                "You are employed since %d and earn %f per year.\n" +
                "Kind regards,\n" +
                "Your administration",
                this.Email,
                this.Firstname,
                this.Lastname,
                this.EmployYear,
                this.Salary
                );
    }
}
