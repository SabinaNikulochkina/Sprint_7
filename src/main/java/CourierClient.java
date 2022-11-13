import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.*;


public class CourierClient extends Endpoints {
    @Step("Создание нового курьера")
    public ValidatableResponse createCourier(Courier courier){
        return given()
                .spec(getSpec())
                .body(courier)
                .when()
                .post(Endpoints.COURIER_CREATION)
                .then().log().all();


    }


    @Step("Создание того же курьера")
    public ValidatableResponse createSameCourier(Courier courier){
                given()
                .spec(getSpec())
                .body(courier)
                .when()
                .post(Endpoints.COURIER_CREATION)
                .then();
        return given()
                .spec(getSpec())
                .body(courier)
                .when()
                .post(Endpoints.COURIER_CREATION)
                .then().log().all();


    }
    @Step("Логин курьера")
    public ValidatableResponse loginCourier(Credentials credentials) {
        return given()
                .spec(getSpec())
                .body(credentials)
                .when()
                .post(Endpoints.COURIER_LOGIN)
                .then().log().all();
    }


    @Step("Получение ID курьера")
    public String getCourierId(Courier courier) {
        return loginCourier(Credentials.from(courier)).extract().path("id");
    }

    @Step("Удаление курьера")
    public Response deleteCourier(int courierId){
        return given()
                .spec(getSpec())
                .when()
                .delete(Endpoints.COURIER_CREATION + "/" + courierId);
    }
}
