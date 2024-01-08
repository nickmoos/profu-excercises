import java.util.ArrayList;

public class AdministrationMain {

    public ArrayList<Person> persList;

    public AdministrationMain(){
        this.persList = AdministrationInit.createTestPersonList();
    }

    public static void main(String[] args) {
        AdministrationMain administrationMain = new AdministrationMain();

        System.out.println(administrationMain.persList);
    }
}
