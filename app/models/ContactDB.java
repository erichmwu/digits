package models;

import views.formdata.ContactFormData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Internal in-memory repository for Contacts.
 */
public class ContactDB {
  private static Map<Long, Contact> contacts = new HashMap<>();
  private static Map<String, TelephoneType> telephoneTypes = new HashMap<>();
  private static Map<String, DietType> dietTypes = new HashMap<>();
  private static long currentIdValue = 1;

  /**
   * Creates an instance of a contact using the data from the form and adds it to the DB.
   * If the id is 0, create a new id for the contact.  Or else we update an existing contact.
   *
   * @param formData The form data.
   */
  public static void addContacts(ContactFormData formData) {
    long idValue = formData.id;
    if (formData.id == 0) {
      idValue = ++currentIdValue;
    }
    TelephoneType telephoneType = getTelephoneType(formData.telephoneType);
    List<DietType> dietTypes = new ArrayList<>();
    for (String dietString : formData.dietTypes) {
      dietTypes.add(getDietTypes(dietString));
    }
    Contact contact = new Contact(idValue, formData.firstName, formData.lastName,
        formData.telephone, telephoneType, dietTypes);
    contacts.put(idValue, contact);
  }

  /**
   * Updates the database with a new telephone type.
   *
   * @param telephoneType The telephone type to add.
   */
  public static void addTelephoneType(TelephoneType telephoneType) {
    telephoneTypes.put(telephoneType.getTelephoneType(), telephoneType);
  }

  /**
   * Updates the database with a new diet type.
   *
   * @param dietType The diet type to add.
   */
  public static void addDietType(DietType dietType) {
    dietTypes.put(dietType.getDietType(), dietType);
  }

  /**
   * Returns the TelephoneType associated with typeString, or throws RuntimeException if not found.
   *
   * @param typeString The telephone type.
   * @return The instance if found.
   */
  public static TelephoneType getTelephoneType(String typeString) {
    TelephoneType telephoneType = telephoneTypes.get(typeString);
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
    DietType dietType = dietTypes.get(typeString);
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
    Contact contact = contacts.get(id);
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
    return new ArrayList<>(contacts.values());
  }

}
