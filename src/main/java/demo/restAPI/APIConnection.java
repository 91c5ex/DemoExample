package demo.restAPI;

import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;

public class APIConnection {
    public static BaseBuilder  builder;

    public static ResponseOptions<Response > callAPI(APIParameter parameter){

        ResponseOptions <Response> response = null;

        builder = new BaseBuilder(parameter.getEndPoint());
        builder.setURLEncoding(false);
        builder.setHeaders(parameter.getHeaders());

        switch (parameter.getMethod())
        {
            case "GET":
                builder.setQueryParams(parameter.getQueryMap());
                response = builder.getRequest();
        }
        return response;
    }
}
