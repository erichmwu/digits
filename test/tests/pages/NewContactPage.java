package tests.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;

import static org.fest.assertions.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.withId;

/**
 * Provides testing support for the Index page.
 *
 * @author Philip Johnson
 */
public class NewContactPage extends FluentPage {
  private String url;

  /**
   * Create the NewContactPage.
   *
   * @param webDriver The driver.
   * @param port      The port.
   */
  public NewContactPage(WebDriver webDriver, int port) {
    super(webDriver);
    this.url = "http://localhost:" + port + "/newcontact";
  }

  @Override
  public String getUrl() {
    return this.url;
  }

  @Override
  public void isAt() {
    assertThat(title()).isEqualTo("NewContact (digits)");
  }

  /**
   * Creates a new contact.
   *
   * @param firstName The first name.
   * @param lastName The last name.
   * @param telephone The telephone number.
   * @param telephone The telephone type.
   */
  public void createNewContact(String firstName, String lastName, String telephone, String telephoneType) {
    fill("#firstName").with(firstName);
    fill("#lastName").with(lastName);
    fill("#telephone").with(telephone);
    find("select", withId("telephoneType")).find("option", withId(telephoneType)).click();
    submit("#submit");
  }

}
