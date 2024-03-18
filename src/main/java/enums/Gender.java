package enums;

/**
 * @author Bakai Saitkulov
 */


public enum Gender {

    BASE_URL("https://hr-challenge.dev.tapyou.com/api/test"),
    FEMALE("/users?gender=female"),
    MALE("/users?gender=male"),
    ID("/user/{id}");


   private String value;

    Gender (String value){ this.value = value; }

    public String getValue (){ return this.value; }
}
