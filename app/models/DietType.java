package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Model for diet type for the database.
 */
public class DietType {
  private long id;
  private String dietType;
  private List<Contact> contacts = new ArrayList<>();

  /**
   * Constructs an instance of a diet type with the given parameter.
   *
   * @param dietType The diet type.
   */
  public DietType(String dietType) {
    this.dietType = dietType;
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
   * Gets the diet type.
   *
   * @return The diet type.
   */
  public String getDietType() {
    return dietType;
  }

  /**
   * Sets the diet type.
   *
   * @param dietType The new diet type.
   */
  public void setDietType(String dietType) {
    this.dietType = dietType;
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