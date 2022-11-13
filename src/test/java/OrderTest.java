import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

@RunWith(Parameterized.class)
public class OrderTest {

    private OrderClient orderClient;
    private Order order;
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String metroStation;
    private final String phone;
    private final int rentTime;
    private final String deliveryDate;
    private final String comment;
    private final List<String> color;

    public OrderTest(String firstName, String lastName, String address, String metroStation, String phone, int rentTime, String deliveryDate, String comment, List<String> color) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.rentTime = rentTime;
        this.deliveryDate = deliveryDate;
        this.comment = comment;
        this.color = color;
    }

    @Before
    public void setUp(){
        orderClient = new OrderClient();
        order = new Order(firstName, lastName, address, metroStation, phone, rentTime, deliveryDate, comment, color);

    }

    @Parameters
    public static Object[][] OrderParameters() {
        return new Object[][]{
                {"Sabina", "Nik", "Видное, солнечная", "4", "+7 800 355 35 35", 5, "2022-11-20", "azaza", null},
                {"Sabina", "Nik", "Видное, солнечная", "4", "+7 800 355 35 35", 5, "2022-11-20", "azaza", List.of("BLACK")},
                {"Sabina", "Nik", "Видное, солнечная", "4", "+7 800 355 35 35", 5, "2022-11-20", "azaza", List.of("GREY")},
                {"Sabina", "Nik", "Видное, солнечная", "4", "+7 800 355 35 35", 5, "2022-11-20", "azaza", List.of("BLACK", "GREY")},
        };
    }

    @Test
    public void createOrderTest(){
        orderClient.createOrder(order)
                .assertThat().body("track", notNullValue()).and().statusCode(201);

    }
}
