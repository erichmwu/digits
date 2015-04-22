package views.formdata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Utility class to manipulate diet types.
 */
public class DietTypes {
  private static ArrayList<String> dietTypes = new ArrayList<String>();

  static {
    dietTypes.add("Chicken");
    dietTypes.add("Fish");
    dietTypes.add("Beef");
    dietTypes.add("Dairy");
    dietTypes.add("Gluten");
  }

  /**
   * Builds a map of telephone types set to false.
   *
   * @return A map of telephone types
   */
  public static Map<String, Boolean> getTypes() {
    Map<String, Boolean> typeMap = new HashMap<String, Boolean>();
    for (String type : dietTypes) {
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
    for (String legalType : dietTypes) {
      if (type.equals(legalType)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Builds a map of telephones types, where the type is set to true.
   *
   * @param types The type to be set to true.
   * @return A map of telephone types.
   */
  public static Map<String, Boolean> getTypes(List<String> types) {
    Map<String, Boolean> typeMap = getTypes();
    for (String type : types) {
      if (isType(type)) {
        typeMap.put(type, true);
      }
    }
    return typeMap;
  }

}
