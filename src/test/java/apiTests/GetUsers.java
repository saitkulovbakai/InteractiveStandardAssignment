package apiTests;

import apiMethods.GenderController;
import data_models.Gender;
import data_models.UserModel;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.List;
import static enums.Gender.*;

/**
 * @author Bakai Saitkulov
 */

public class GetUsers {

    private GenderController genderController;
    private Gender gender;
    private Response response;
    private List<Integer> listOfFemaleUsers;
    private List<Integer> listOfMaleUsers;
    private UserModel user;

    @BeforeTest
    public void setUpForFemaleUsers(){
        genderController = new GenderController(BASE_URL.getValue());
        response = genderController.get(FEMALE.getValue());
        gender = response.getBody().as(Gender.class);
        listOfFemaleUsers = gender.getIdList();
    }

    @BeforeTest
    public void setUpForMaleUsers(){
        genderController = new GenderController(BASE_URL.getValue());
        response = genderController.get(MALE.getValue());
        gender = response.getBody().as(Gender.class);
        listOfMaleUsers = gender.getIdList();
    }


    @Test
    @Description("Verify correctness and completeness of response data for female users")
    public void verifyResponseDataForFemaleUsers() {
        setUpForFemaleUsers();
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(gender.isSuccess());
        Assert.assertEquals(gender.getErrorCode(), 0);
        Assert.assertNull(gender.getErrorMessage());
        Assert.assertNotNull(gender.getIdList());
    }

    @Test
    @Description("Verify correctness and completeness of response data for male users")
    public void verifyResponseDataForMaleUsers() {
        setUpForMaleUsers();
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(gender.isSuccess());
        Assert.assertEquals(gender.getErrorCode(), 0);
        Assert.assertNull(gender.getErrorMessage());
        Assert.assertNotNull(gender.getIdList());
    }

    @Test
    @Description("Verify the correctness of details of each female by user ID")
    public void testGetFemaleUsersInfo() {
        SoftAssert softAssert = new SoftAssert();

        for (int id : listOfFemaleUsers){
            response = genderController.get(ID.getValue().replace("{id}",String.valueOf(id)));
            user = response.getBody().as(UserModel.class);

            softAssert.assertEquals(user.getUsers().getId(), id, "id#" + String.valueOf(id));
            softAssert.assertNotNull(user.getUsers().getName(), "id#" + String.valueOf(id));
            softAssert.assertEquals(user.getUsers().getGender(),"female", "id#" + String.valueOf(id));
            softAssert.assertNotNull(String.valueOf(user.getUsers().getAge()), "id#" + String.valueOf(id));
            softAssert.assertNotNull(user.getUsers().getCity(), "id#" + String.valueOf(id));
            softAssert.assertNotNull(user.getUsers().getRegistrationDate(), "id#" + String.valueOf(id));
        }
        softAssert.assertAll();
    }

    @Test
    @Description("Verify the correctness of details of each male by user ID")
    public void testGetMaleUsersInfo() {
        SoftAssert softAssert = new SoftAssert();

        for (int id : listOfMaleUsers){
            response = genderController.get(ID.getValue().replace("{id}",String.valueOf(id)));
            user = response.getBody().as(UserModel.class);

            softAssert.assertEquals(user.getUsers().getId(), id, "id#" + String.valueOf(id));
            softAssert.assertNotNull(user.getUsers().getName(), "id#" + String.valueOf(id));
            softAssert.assertEquals(user.getUsers().getGender(),"male", "id#" + String.valueOf(id));
            softAssert.assertNotNull(String.valueOf(user.getUsers().getAge()), "id#" + String.valueOf(id));
            softAssert.assertNotNull(user.getUsers().getCity(), "id#" + String.valueOf(id));
            softAssert.assertNotNull(user.getUsers().getRegistrationDate(), "id#" + String.valueOf(id));
        }
        softAssert.assertAll();
    }
}
