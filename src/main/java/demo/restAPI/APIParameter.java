package demo.restAPI;

import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;

public class APIParameter {

    RequestSpecification specification;
    static BaseBuilder builder;
    ResponseOptions<Response> apiResponse;
    String endPoint;
    HashMap<String,String> headers;
    HashMap<String,Object> queryMap;
    HashMap<String,Object> bodyMap;
    String Method;

    public RequestSpecification getSpecification() {
        return specification;
    }

    public void setSpecification(RequestSpecification specification) {
        this.specification = specification;
    }

    public static BaseBuilder getBuilder() {
        return builder;
    }

    public static void setBuilder(BaseBuilder builder) {
        APIParameter.builder = builder;
    }

    public ResponseOptions<Response> getApiResponse() {
        return apiResponse;
    }

    public void setApiResponse(ResponseOptions<Response> apiResponse) {
        this.apiResponse = apiResponse;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public HashMap<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(HashMap<String, String> headers) {
        this.headers = headers;
    }

    public HashMap<String, Object> getQueryMap() {
        return queryMap;
    }

    public void setQueryMap(HashMap<String, Object> queryMap) {
        this.queryMap = queryMap;
    }

    public HashMap<String, Object> getBodyMap() {
        return bodyMap;
    }

    public void setBodyMap(HashMap<String, Object> bodyMap) {
        this.bodyMap = bodyMap;
    }

    public String getMethod() {
        return Method;
    }

    public void setMethod(String method) {
        Method = method;
    }
}
