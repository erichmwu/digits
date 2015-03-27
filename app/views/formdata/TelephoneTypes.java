package views.formdata;

import java.util.HashMap;
import java.util.Map;

/**
 * Utility class to manipulate telephone types.
 */
public class TelephoneTypes {
  private static String[] telephoneTypes = {"Mobile", "Work", "Home"};

  /**
   * Builds a map of telephone types set to false.
   *
   * @return A map of telephone types
   */
  public static Map<String, Boolean> getTypes() {
    Map<String, Boolean> typeMap = new HashMap<String, Boolean>();
    for (String type : telephoneTypes) {
      typeMap.put(type, false);
    }
    return typeMap;
  }

  /**
   * Checks if the type passed is a legal telephone type.
   *
   * @param type The telephone type.
   * @return True if the type is legal, or else return false.
   */
  public static boolean isType(String type) {
    for (String legalType : telephoneTypes) {
      if (type.equals(legalType)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Builds a map of telephones types, where the type is set to true.
   *
   * @param type The type to be set to true.
   * @return A map of telephone types.
   */
  public static Map<String, Boolean> getTypes(String type) {
    Map<String, Boolean> typeMap = getTypes();
    if (isType(type)) {
      typeMap.put(type, true);
    }
    return typeMap;
  }
}
