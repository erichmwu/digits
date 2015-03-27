package controllers;

import models.ContactDB;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.formdata.ContactFormData;
import views.formdata.TelephoneTypes;
import views.html.Index;
import views.html.NewContact;

import java.util.Map;

/**
 * Provides controllers for this application.
 */
public class Application extends Controller {

  /**
   * Returns the home page.
   *
   * @return The resulting home page.
   */
  public static Result index() {
    return ok(Index.render(ContactDB.getContacts()));
  }

  /**
   * Returns the New Contact page.
   *
   * @param id The id.
   * @return The New Contact page.
   */
  public static Result newContact(long id) {
    ContactFormData data;
    if (id == 0) {
      data = new ContactFormData();
    }
    else {
      data = new ContactFormData(ContactDB.getContact(id));
    }
    Form<ContactFormData> formData = Form.form(ContactFormData.class).fill(data);
    Map<String, Boolean> telephoneTypeMap = TelephoneTypes.getTypes(data.telephoneType);
    return ok(NewContact.render(formData, telephoneTypeMap));
  }

  /**
   * Gets the form data from the New Contact page.
   *
   * @return The data from the form on the New Contact page.
   */
  public static Result postRequest() {
    Form<ContactFormData> formData = Form.form(ContactFormData.class).bindFromRequest();
    if (formData.hasErrors()) {
      System.out.println("Found errors");
      Map<String, Boolean> telephoneTypeMap = TelephoneTypes.getTypes();
      return badRequest(NewContact.render(formData, telephoneTypeMap));
    }
    else {
      ContactFormData data = formData.get();
      ContactDB.addContacts(data);
      System.out.println("Data " + data.firstName + ", " + data.lastName + ", " + data.telephone
          + ", " + data.telephoneType);
      Map<String, Boolean> telephoneTypeMap = TelephoneTypes.getTypes(data.telephoneType);
      return ok(NewContact.render(formData, telephoneTypeMap));
    }
  }

}
