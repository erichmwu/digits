package models;

import views.formdata.ContactFormData;

import java.util.ArrayList;
import java.util.List;

/**
 * Internal in-memory repository for Contacts.
 */
public class ContactDB {
  private static List<Contact> contacts = new ArrayList<>();

  /**
   * Creates an instance of a contact using the data from the form and adds it to the DB.
   *
   * @param formData The form data.
   */
  public static void addContacts(ContactFormData formData) {
    Contact contact = new Contact(formData.firstName, formData.lastName, formData.telephone);
    contacts.add(contact);
  }

  /**
   * Returns the list of contacts from the DB.
   *
   * @return The contact list.
   */
  public static List<Contact> getContacts() {
    return contacts;
  }

}
