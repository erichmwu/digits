import models.ContactDB;
import play.Application;
import play.GlobalSettings;
import views.formdata.ContactFormData;

/**
 * Initialize with four contacts.
 */
public class Global extends GlobalSettings {
  @Override
  public void onStart(Application application) {
    super.onStart(application);
    ContactDB.addContacts(new ContactFormData("Philip", "Johnson", "123-456-7890", "Home"));
    ContactDB.addContacts(new ContactFormData("Jane", "Doe", "477-456-7890", "Work"));
    ContactDB.addContacts(new ContactFormData("Justin", "Verlander", "999-456-8888", "Home"));
    ContactDB.addContacts(new ContactFormData("Gordie", "Howe", "654-456-2345", "Mobile"));
  }
}
