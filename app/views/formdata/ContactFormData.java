package views.formdata;

import models.Contact;
import play.data.validation.ValidationError;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for form data.
 */
public class ContactFormData {
  private static final int TELEPHONE_NUMBER_LENGTH = 12;
  private static final int DIET_NUMBER_LENGTH = 5;

  /**
   * First name.
   */
  public String firstName = "";
  /**
   * Last name.
   */
  public String lastName = "";
  /**
   * Telephone number.
   */
  public String telephone = "";
  /**
   * Id number.
   */
  public long id;
  /**
   * Telephone type.
   */
  public String telephoneType = "";
  /**
   * Diet types.
   */
  public ArrayList<String> dietTypes = new ArrayList<String>();

  /**
   * No-arg constructor.
   */
  public ContactFormData() {
    //no arg constructor
  }

  /**
   * Constructs a ContactFormData from a contact instance.
   *
   * @param contact The contact.
   */
  public ContactFormData(Contact contact) {
    this.id = contact.getId();
    this.firstName = contact.getFirstName();
    this.lastName = contact.getLastName();
    this.telephone = contact.getTelephone();
    this.telephoneType = contact.getTelephoneType();
    this.dietTypes = contact.getDietTypes();
  }

  /**
   * Creates default contacts during loading.
   *
   * @param firstName The first name.
   * @param lastName The last name.
   * @param telephone The telephone number.
   * @param telephoneType The telephone type.
   */
  public ContactFormData(String firstName, String lastName, String telephone, String telephoneType, ArrayList<String> dietTypes) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.telephone = telephone;
    this.telephoneType = telephoneType;
    this.dietTypes = dietTypes;
  }

  /**
   * Validate all fields that are empty and enforces 12 characters for the telephone number.
   *
   * @return null if all input is valid or a list of Validation Errors.
   */
  public List<ValidationError> validate() {
    List<ValidationError> errors = new ArrayList<>();

    if (firstName == null || firstName.length() == 0) {
      errors.add(new ValidationError("firstName", "First name is required."));
    }

    if (lastName == null || lastName.length() == 0) {
      errors.add(new ValidationError("lastName", "Last name is required."));
    }

    if (telephone == null || telephone.length() == 0) {
      errors.add(new ValidationError("telephone", "Telephone number is required."));
    }

    if (telephone != null && telephone.length() != TELEPHONE_NUMBER_LENGTH) {
      errors.add(new ValidationError("telephone", "Telephone number must be in the format xxx-xxx-xxxx."));
    }

    if (!TelephoneTypes.isType(telephoneType)) {
      errors.add(new ValidationError("telephoneType", "Telephone type is not valid."));
    }

    if (dietTypes.size() > 0) {
      for (String dietType : dietTypes) {
        if (DietTypes.findDietTypes(dietType) == null) {
          errors.add(new ValidationError("dietTypes", "Diet type is not valid."));
        }
      }
    }

    return errors.isEmpty() ? null : errors;
  }
}
