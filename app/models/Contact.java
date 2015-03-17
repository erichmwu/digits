package models;

/**
 * Model for a contact for the database.
 */
public class Contact {
  private String firstName;
  private String lastName;
  private String telephone;
  private String address;
  private long id;

  /**
   * Creates an instance of a contact.
   *
   * @param id The id.
   * @param firstName The first name.
   * @param lastName  The last name.
   * @param telephone The telephone number.
   * @param address The address.
   */
  public Contact(long id, String firstName, String lastName, String telephone, String address) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.telephone = telephone;
    this.address = address;
  }

  /**
   * Returns the first name.
   *
   * @return The first name.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Returns the last name.
   *
   * @return The last name.
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Returns the telephone number.
   *
   * @return The telephone number.
   */
  public String getTelephone() {
    return telephone;
  }

  /**
   * Returns the id.
   *
   * @return The id.
   */
  public long getId() {
    return id;
  }

  /**
   * Returns the address.
   *
   * @return The address.
   */
  public String getAddress() {
    return address;
  }
}
