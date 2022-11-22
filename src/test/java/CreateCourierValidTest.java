import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;


public class CreateCourierValidTest {

    private CourierClient courierClient;
    private Courier courier;
    private int id;

    @Before
    public void setUp(){
        courierClient = new CourierClient();
        courier = new Courier("Asas7", "12345678", "Asassin");
    }

    @After
    // Вызов метода удаления курьера по его id
    public void cleanUp(){

        courierClient.deleteCourier(id);

        Credentials credentials = Credentials.from(courier);
        id = courierClient.loginCourier(credentials)
                .extract().path("id");
    }

    @Test
    public void courierCanBeCreatedValidData(){

        courierClient.createCourier(courier)
                .assertThat().body("ok", equalTo(true)).and().statusCode(201);


        }


}
