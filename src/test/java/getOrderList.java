import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class getOrderList {
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
