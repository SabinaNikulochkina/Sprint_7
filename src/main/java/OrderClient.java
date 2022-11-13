import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class OrderClient extends Endpoints {
    @Step("Создание заказа")
    public ValidatableResponse createOrder(Order order){
        return given()
                .spec(getSpec())
                .body(order)
                .when()
                .post(Endpoints.ORDER_CREATION)
                .then().log().all();

    }

    @Step("Получение списка заказов")
    public ValidatableResponse getListOfOrder(){
        return given()
                .spec(getSpec())
                .when()
                .get(Endpoints.ORDER_LIST)
                .then().log().all();

    }

}
