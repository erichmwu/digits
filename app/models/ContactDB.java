package models;

import views.formdata.ContactFormData;

import java.util.ArrayList;
import java.util.List;

/**
 * Internal in-memory repository for Contacts.
 */
public class ContactDB {
  //private static Map<Long, Contact> contacts = new HashMap<>();
  //private static Map<String, TelephoneType> telephoneTypes = new HashMap<>();
  //private static Map<String, DietType> dietTypes = new HashMap<>();
  //private static long currentIdValue = 1;

  /**
   * Creates an instance of a contact using the data from the form and adds it to the DB.
   * If the id is 0, create a new id for the contact.  Or else we update an existing contact.
   *
   * @param formData The form data.
   */
  public static void addContacts(ContactFormData formData) {

    TelephoneType telephoneType = getTelephoneType(formData.telephoneType);
    List<DietType> dietTypes = new ArrayList<>();
    for (String dietString : formData.dietTypes) {
      dietTypes.add(getDietTypes(dietString));
    }

    Contact contact = (formData.id == 0) ? new Contact() : Contact.find().byId(formData.id);
    contact.setFirstName(formData.firstName);
    contact.setLastName(formData.lastName);
    contact.setTelephone(formData.telephone);
    contact.setTelephoneType(telephoneType);
    contact.setDietTypes(dietTypes);

    // Make relationships bi-directional.
    telephoneType.addContacts(contact);
    for (DietType dietType : dietTypes) {
      dietType.addContacts(contact);
    }
    contact.save();
  }

  /**
   * Updates the database with a new telephone type.
   *
   * @param telephoneType The telephone type to add.
   */
  public static void addTelephoneType(TelephoneType telephoneType) {
    telephoneType.save();
  }

  /**
   * Updates the database with a new diet type.
   *
   * @param dietType The diet type to add.
   */
  public static void addDietType(DietType dietType) {
    dietType.save();
  }

  /**
   * Returns the TelephoneType associated with typeString, or throws RuntimeException if not found.
   *
   * @param typeString The telephone type.
   * @return The instance if found.
   */
  public static TelephoneType getTelephoneType(String typeString) {
    TelephoneType telephoneType = TelephoneType.find().where().eq("telephoneType", typeString).findUnique();
    if (telephoneType == null) {
      throw new RuntimeException("Illegal telephone type: " + typeString);
    }
    return telephoneType;
  }

  /**
   * Returns the DietType associated with typeString, or throws RuntimeException if not found.
   *
   * @param typeString The diet type.
   * @return The instance if found.
   */
  public static DietType getDietTypes(String typeString) {
    DietType dietType = DietType.find().where().eq("dietType", typeString).findUnique();
    if (dietType == null) {
      throw new RuntimeException("Illegal diet type " + typeString);
    }
    return dietType;
  }

  /**
   * Returns the contact with the given id or throws a RuntimeException if not found.
   *
   * @param id The id.
   * @return The contact.
   */
  public static Contact getContact(long id) {
    Contact contact = Contact.find().byId(id);
    if (contact == null) {
      throw new RuntimeException("Can't find contact with given id.");
    }
    return contact;
  }

  /**
   * Returns the list of contacts from the DB.
   *
   * @return The contact list.
   */
  public static List<Contact> getContacts() {
    return Contact.find().all();
  }

}
