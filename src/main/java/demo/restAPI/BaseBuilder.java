package demo.restAPI;

import demo.util.LoggerHelper;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class BaseBuilder {
    private RequestSpecBuilder builder = null;
    private String endpoint;
    private RequestSpecification request;

    private final static Logger logger = LoggerHelper.getLogger(BaseBuilder.class);

    public  BaseBuilder (String endpoint){
        this.builder = new RequestSpecBuilder();
        this.endpoint = endpoint;
        builder.setBaseUri(this.endpoint);
        logger.info("Calling base builder");
    }

    public  void setHeaders(Map<String,String> headers)
    {
     this.builder.addHeaders(headers);
    }
    public void setBody(Object object)
    {
        this.builder.setBody(object);
    }
    public ResponseOptions<Response> getRequest()
    {
        getRequestInstance();
        return request.get();
    }

    public ResponseOptions<Response> putRequest()
    {
        getRequestInstance();
        return request.put();
    }

    public ResponseOptions<Response> postRequest()
    {
        getRequestInstance();
        return request.post();
    }

    private void getRequestInstance()
    {
        RestAssured.defaultParser = Parser.JSON;
        RequestSpecification requestSpec = builder.addFilter(new RequestFilter()).build();
        request = RestAssured.given();
        request.contentType(ContentType.JSON);
        request.spec(requestSpec);
    }

    public void setURLEncoding(boolean val) {
        this.builder.setUrlEncodingEnabled(val);
    }

    public void setQueryParams(HashMap<String, ?> queryMap) {
        this.builder.addQueryParams(queryMap);
    }

}

