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
    Contact contact = new Contact(idValue, formData.firstName, formData.lastName,
        formData.telephone, formData.telephoneType);
    contacts.put(idValue, contact);
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
