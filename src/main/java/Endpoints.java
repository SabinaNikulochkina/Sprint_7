import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Endpoints {
    public static final String COURIER_CREATION = "/api/v1/courier";
    public static final String COURIER_LOGIN = "/api/v1/courier/login";
    public static final String ORDER_CREATION = "/api/v1/orders";
    public static final String ORDER_LIST = "/api/v1/orders";

    public static final String BASE_URL = "http://qa-scooter.praktikum-services.ru/";

    protected RequestSpecification getSpec(){
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(BASE_URL)
                .build();

    }

}
