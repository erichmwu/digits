package views.formdata;

import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for form data.
 */
public class ContactFormData {
  private static final int TELEPHONE_NUMBER_LENGTH = 12;

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
    
    return errors.isEmpty() ? null : errors;
  }
}
