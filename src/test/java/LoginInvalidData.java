import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class LoginInvalidData {
    private CourierClient courierClient;
    private Courier courier;
    private Courier courierWrongPassword;
    private Courier courierEmptyPassword;
    private Courier courierEmptyLogin;
    private Courier courierWrongLogin;

    private int id;

    @Before
    public void setUp(){
        courierClient = new CourierClient();
        courier = new Courier("Asas6", "12345678", "Asassin");
        courierWrongPassword = new Courier("Asas6", "98765432321", "Asassin");
        courierWrongLogin = new Courier("Asa2222", "98765432321", "Asassin");
        courierEmptyPassword = new Courier("Asas6", "", "Asassin");
        courierEmptyLogin = new Courier("Asas6", "", "Asassin");
    }

    @After
    // Вызов метода удаления курьера по его id
    public void cleanUp(){

        courierClient.deleteCourier(id);
    }

    @Test
    public void cantBeLoginWrongPassword(){

        courierClient.createCourier(courier);
        Credentials credentials1 = Credentials.from(courier);
        id = courierClient.loginCourier(credentials1)
                .extract().path("id");


        Credentials credentials = Credentials.from(courierWrongPassword);
        courierClient.loginCourier(credentials)
                .assertThat().body("message", equalTo("Учетная запись не найдена")).and().statusCode(404);

    }

    @Test
    public void cantBeLoginEmptyPassword(){

        courierClient.createCourier(courier);
        Credentials credentials1 = Credentials.from(courier);
        id = courierClient.loginCourier(credentials1)
                .extract().path("id");


        Credentials credentials = Credentials.from(courierEmptyPassword);
        courierClient.loginCourier(credentials)
                .assertThat().body("message", equalTo("Недостаточно данных для входа")).and().statusCode(400);

    }

    @Test
    public void cantBeLoginEmptyLogin(){

        courierClient.createCourier(courier);
        Credentials credentials1 = Credentials.from(courier);
        id = courierClient.loginCourier(credentials1)
                .extract().path("id");


        Credentials credentials = Credentials.from(courierEmptyLogin);
        courierClient.loginCourier(credentials)
                .assertThat().body("message", equalTo("Недостаточно данных для входа")).and().statusCode(400);

    }

    @Test
    public void cantBeLoginWrongLogin(){

        courierClient.createCourier(courier);
        Credentials credentials1 = Credentials.from(courier);
        id = courierClient.loginCourier(credentials1)
                .extract().path("id");


        Credentials credentials = Credentials.from(courierWrongLogin);
        courierClient.loginCourier(credentials)
                .assertThat().body("message", equalTo("Учетная запись не найдена")).and().statusCode(404);

    }
}