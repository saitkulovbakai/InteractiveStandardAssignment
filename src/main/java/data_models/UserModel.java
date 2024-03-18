package data_models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Bakai Saitkulov
 */


@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class UserModel {

    @JsonProperty("isSuccess")
    private boolean isSuccess;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("errorCode")
    private int errorCode;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("errorMessage")
    private String errorMessage;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("user")
    private User users;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class User {

        @JsonProperty("id")
        private int id;

        @JsonProperty("name")
        private String name;

        @JsonProperty("gender")
        private String gender;

        @JsonProperty("age")
        private int age;

        @JsonProperty("city")
        private String city;

        @JsonProperty("registrationDate")
        private String registrationDate;
    }

}

