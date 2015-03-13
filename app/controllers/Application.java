package controllers;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.formdata.ContactFormData;
import views.html.Index;
import views.html.NewContact;

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
    return ok(Index.render("Welcome to the home page."));
  }

  /**
   * Returns the New Contact page.
   *
   * @return The New Contact page.
   */
  public static Result newContact() {
    Form<views.formdata.ContactFormData> formData = Form.form(ContactFormData.class);
    return ok(NewContact.render(formData));
  }

  /**
   * Gets the form data from the New Contact page.
   *
   * @return The data from the form on the New Contact page.
   */
  public static Result postRequest() {
    Form<views.formdata.ContactFormData> formData = Form.form(ContactFormData.class).bindFromRequest();
    ContactFormData data = formData.get();
    System.out.println("Data " + data.firstName + ", " + data.lastName + ", " + data.telephone);
    return ok(NewContact.render(formData));
  }

}
