package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Model for telephone type for the database.
 */
public class TelephoneType {
  private long id;
  private String telephoneType;
  private List<Contact> contacts = new ArrayList<>();

  /**
   * Constructs an instance of a telephone type with the given parameter.
   *
   * @param telephoneType The telephone type.
   */
  public TelephoneType(String telephoneType) {
    this.telephoneType = telephoneType;
  }

  /**
   * Gets the id.
   *
   * @return The id.
   */
  public long getId() {
    return id;
  }

  /**
   * Sets the id.
   *
   * @param id The new id.
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Gets the telephone type.
   *
   * @return The telephone type.
   */
  public String getTelephoneType() {
    return telephoneType;
  }

  /**
   * Sets the telephone type.
   *
   * @param telephoneType The new telephone type.
   */
  public void setTelephoneType(String telephoneType) {
    this.telephoneType = telephoneType;
  }

  /**
   * Gets the list of contacts.
   *
   * @return The list of contacts.
   */
  public List<Contact> getContacts() {
    return contacts;
  }

  /**
   * Sets the list of contacts.
   *
   * @param contacts The contacts.
   */
  public void setContacts(List<Contact> contacts) {
    this.contacts = contacts;
  }

  /**
   * Adds the contact.
   *
   * @param contact The contact.
   */
  public void addContacts(Contact contact) {
    this.contacts.add(contact);
  }
}