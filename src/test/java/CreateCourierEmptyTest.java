import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.equalTo;

public class CreateCourierEmptyTest {
    private CourierClient courierClient;
    private Courier courier;
    private int id;

    @Before
    public void setUp(){
        courierClient = new CourierClient();
        courier = new Courier("Asas", "", "Asassin");
    }

    @After
    // Вызов метода удаления курьера по его id
    public void cleanUp(){
        courierClient.deleteCourier(id);
    }

    @Test
    public void courierEmptyData(){

        courierClient.createCourier(courier)
                .assertThat().body("message", equalTo("Недостаточно данных для создания учетной записи")).and().statusCode(400);

        /* Credentials credentials = Credentials.from(courier);
        id = courierClient.loginCourier(credentials)
                .extract().path("id"); */

        /* // Получить ответ из body по ручке создание курьера
        ValidatableResponse responseCreate = courierClient.createCourier(courier);

        // Получить ответ из body по ручке логин курьера
        ValidatableResponse responseLogin = courierClient.loginCourier(Credentials.from(courier));

        // Получить значение id из body по ручке логин курьера
        id = responseLogin.extract().path("id");

        responseCreate.assertThat().body("message", equalTo("Недостаточно данных для создания учетной записи"));
        responseCreate.assertThat().statusCode(400);*/

    }
}
