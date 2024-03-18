package data_models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

/**
 * @author Bakai Saitkulov
 */


@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class Gender {

    @JsonProperty("isSuccess")
    private boolean isSuccess;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("errorCode")
    private int errorCode;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("errorMessage")
    private String errorMessage;

    @JsonProperty("idList")
    private List<Integer> idList;

}
