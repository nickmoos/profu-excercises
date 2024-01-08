public class Student extends Person {
    public int RegistrationNr;
    public int CurrentTerm;

    public Student(String lastname, String firstname, String email, int RegistrationNr, int CurrentTerm) {
        super(lastname, firstname, email);
        this.setRegistrationNr(RegistrationNr);
        this.setCurrentTerm(CurrentTerm);
    }

    public int getRegistrationNr() {
        return this.RegistrationNr;
    }

    public void setRegistrationNr(int RegistrationNr) {
        this.RegistrationNr = RegistrationNr;
    }

    public int getCurrentTerm() {
        return CurrentTerm;
    }

    public void setCurrentTerm(int CurrentTerm) {
        this.CurrentTerm = CurrentTerm;
    }

    @Override
    public String toString() {
        return String.format("Student: Firstname=%s, Lastname=%s, Email=%s, RegistrationNr=%d, CurrentTerm=%d", super.Firstname, super.Lastname, super.Email, this.RegistrationNr, this.CurrentTerm);
    }

    @Override
    public String writeEmail() {
        return String.format("TO: %s\n" +
                "Dear student %s %s,\n" +
                "You are registered under number %d and\n" +
                "you are in your %dth term.\n" +
                "Kind regards,\n" +
                "Your administration\n",
                this.Email,
                this.Firstname,
                this.Lastname,
                this.RegistrationNr,
                this.CurrentTerm);
    }
}
