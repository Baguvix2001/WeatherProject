package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;


public class Specifications {
    public static RequestSpecification requestSpec(String url) {
        return new RequestSpecBuilder()
          .setBaseUri(url)
          .setContentType(ContentType.JSON)
          .build();
    }

}
