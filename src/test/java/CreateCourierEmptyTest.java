import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.equalTo;

public class CreateCourierEmptyTest {
    private CourierClient courierClient;
    private Courier courier;

    private Courier courierWithoutLogin;
    private int id;

    @Before
    public void setUp(){
        courierClient = new CourierClient();
        courier = new Courier("Asas", "", "Asassin");
        courierWithoutLogin = new Courier("", "123456", "Asassin");
    }

    @After
    // Вызов метода удаления курьера по его id
    public void cleanUp(){

        courierClient.deleteCourier(id);
    }

    @Test
    public void courierEmptyPassword(){

        courierClient.createCourier(courier)
                .assertThat().body("message", equalTo("Недостаточно данных для создания учетной записи")).and().statusCode(400);
    }

    @Test
    public void courierEmptyLogin(){

        courierClient.createCourier(courierWithoutLogin)
                .assertThat().body("message", equalTo("Недостаточно данных для создания учетной записи")).and().statusCode(400);
    }
}
