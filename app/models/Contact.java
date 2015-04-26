package models;

import play.db.ebean.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

/**
 * Model for a contact for the database.
 */
@Entity
public class Contact extends Model {
  private String firstName;
  private String lastName;
  private String telephone;
  @Id
  private long id;
  @ManyToOne(cascade = CascadeType.PERSIST)
  private TelephoneType telephoneType;
  @ManyToMany(cascade = CascadeType.PERSIST)
  private List<DietType> dietTypes;

  /**
   * Creates an empty instance of a contact.
   */
  public Contact() {
    this.firstName = "";
    this.lastName = "";
    this.telephone = "";
    this.telephoneType = null;
    this.dietTypes = null;
  }

  /**
   * Creates an instance of a contact.
   *
   * @param firstName The first name.
   * @param lastName  The last name.
   * @param telephone The telephone number.
   * @param telephoneType The telephone type.
   * @param dietTypes The diet types.
   */
  public Contact(String firstName, String lastName, String telephone,
                 TelephoneType telephoneType, List<DietType> dietTypes) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.telephone = telephone;
    this.telephoneType = telephoneType;
    this.dietTypes = dietTypes;
  }

  /**
   * The EBean ORM finder method for database queries.
   * @return The finder method.
   */
  public static Finder<Long, Contact> find() {
    return new Finder<Long, Contact>(Long.class, Contact.class);
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
   * Returns the telephone type.
   *
   * @return The telephone type.
   */
  public TelephoneType getTelephoneType() {
    return telephoneType;
  }

  /**
   * Returns the diet types.
   *
   * @return The diet types.
   */
  public List<DietType> getDietTypes() {
    return dietTypes;
  }

  /**
   * Sets the first name.
   *
   * @param firstName The first name.
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * Sets the last name.
   *
   * @param lastName The last name.
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * Sets the telephone type.
   *
   * @param telephone The telephone type.
   */
  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  /**
   * Sets the id.
   *
   * @param id The id.
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Sets the telephone type.
   *
   * @param telephoneType The telephone type.
   */
  public void setTelephoneType(TelephoneType telephoneType) {
    this.telephoneType = telephoneType;
  }

  /**
   * Sets the diet types.
   *
   * @param dietTypes The diet types.
   */
  public void setDietTypes(List<DietType> dietTypes) {
    this.dietTypes = dietTypes;
  }

  /**
   * Returns the diet types.
   *
   * @return The diet types.
   */
  public String printDietTypes() {
    StringBuilder sb = new StringBuilder();
    for   (int i = 0; i < dietTypes.size(); i++) {
      if (i == dietTypes.size() - 1) {
        sb.append(dietTypes.get(i).getDietType());
      }
      else {
        sb.append(dietTypes.get(i).getDietType() + ", ");
      }
    }
    return sb.toString();
  }

  /**
   * Returns a list of DietType strings for this Contact.
   *
   * @return The list of diet type strings.
   */
  public List<String> getDietTypeList() {
    List<String> dietList = new ArrayList<>();
    for (DietType dietType : this.dietTypes) {
      dietList.add(dietType.getDietType());
    }
    return dietList;
  }
}
