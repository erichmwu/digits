import models.Contact;
import models.ContactDB;
import models.DietType;
import models.TelephoneType;
import play.Application;
import play.GlobalSettings;
import views.formdata.ContactFormData;

import java.util.ArrayList;
import java.util.List;

/**
 * Initialize with four contacts.
 */
public class Global extends GlobalSettings {
  @Override
  public void onStart(Application application) {
    super.onStart(application);
    if (TelephoneType.find().all().isEmpty()) {
      ContactDB.addTelephoneType(new TelephoneType("Mobile"));
      ContactDB.addTelephoneType(new TelephoneType("Home"));
      ContactDB.addTelephoneType(new TelephoneType("Work"));
    }
    if (DietType.find().all().isEmpty()) {
      ContactDB.addDietType(new DietType("Chicken"));
      ContactDB.addDietType(new DietType("Fish"));
      ContactDB.addDietType(new DietType("Beef"));
      ContactDB.addDietType(new DietType("Dairy"));
      ContactDB.addDietType(new DietType("Gluten"));
    }
    if (Contact.find().all().isEmpty()) {
      List<String> chickenDiet = new ArrayList<String>();
      ContactDB.addContacts(new ContactFormData("Philip", "Johnson", "123-456-7890", "Home", chickenDiet));
      ContactDB.addContacts(new ContactFormData("Jane", "Doe", "477-456-7890", "Work", chickenDiet));
      ContactDB.addContacts(new ContactFormData("Justin", "Verlander", "999-456-8888", "Home", chickenDiet));
      ContactDB.addContacts(new ContactFormData("Gordie", "Howe", "654-456-2345", "Mobile", chickenDiet));
    }
  }
}
