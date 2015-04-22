import models.ContactDB;
import play.Application;
import play.GlobalSettings;
import views.formdata.ContactFormData;

import java.util.ArrayList;

/**
 * Initialize with four contacts.
 */
public class Global extends GlobalSettings {
  @Override
  public void onStart(Application application) {
    super.onStart(application);
    ArrayList<String> chickenDiet = new ArrayList<String>();
    chickenDiet.add("Chicken");
    ContactDB.addContacts(new ContactFormData("Philip", "Johnson", "123-456-7890", "Home", chickenDiet));
    ContactDB.addContacts(new ContactFormData("Jane", "Doe", "477-456-7890", "Work", chickenDiet));
    ContactDB.addContacts(new ContactFormData("Justin", "Verlander", "999-456-8888", "Home", chickenDiet));
    ContactDB.addContacts(new ContactFormData("Gordie", "Howe", "654-456-2345", "Mobile", chickenDiet));
  }
}
