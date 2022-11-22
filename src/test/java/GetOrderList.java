import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.notNullValue;

public class GetOrderList {
    private OrderClient orderClient;

    @Before
    public void setUp(){
        orderClient = new OrderClient();

    }

    @Test
    public void getOrderListTest(){
        orderClient.getListOfOrder()
                .assertThat().body("orders", notNullValue()).and().statusCode(200);

    }
}
