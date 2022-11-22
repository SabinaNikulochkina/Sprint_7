import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.hamcrest.Matchers.equalTo;

public class CreateCourierSameTest {
    private CourierClient courierClient;
    private Courier courier;
    private int id;

    @Before
    public void setUp(){
        courierClient = new CourierClient();
        courier = new Courier("Asas", "12345678", "Asassin");

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
    public void sameCourierTest(){
         courierClient.createSameCourier(courier)
                .assertThat().body("message", equalTo("Этот логин уже используется. Попробуйте другой.")).and().statusCode(409);

    }
}
