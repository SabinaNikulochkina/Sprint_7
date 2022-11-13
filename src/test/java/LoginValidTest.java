import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.*;

public class LoginValidTest {
    private CourierClient courierClient;
    private Courier courier;
    private int id;

    @Before
    public void setUp(){
        courierClient = new CourierClient();
        courier = new Courier("Asas8", "12345678", "Asassin");
    }

    @After
    // Вызов метода удаления курьера по его id
    public void cleanUp(){

        courierClient.deleteCourier(id);
    }

    @Test
    public void canBeLogin(){

        courierClient.createCourier(courier);

        Credentials credentials = Credentials.from(courier);
        id = courierClient.loginCourier(credentials)
                .assertThat().body("id", notNullValue()).and().statusCode(200)
                .extract().path("id");

            }

  }
