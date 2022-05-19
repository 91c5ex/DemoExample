package demo.restAPI;

import demo.util.LoggerHelper;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.apache.logging.log4j.Logger;

public class RequestFilter implements Filter {

    @Override
    public Response filter(FilterableRequestSpecification filterableRequestSpecification, FilterableResponseSpecification filterableResponseSpecification, FilterContext filterContext) {
       Response response = filterContext.next(filterableRequestSpecification,filterableResponseSpecification);
        Logger logger;


        logger = LoggerHelper.getLogger(RequestFilter.class);
        logger.info(filterableRequestSpecification.getMethod()+
                "" + filterableRequestSpecification.getURI() +"\n Request header" +
                filterableRequestSpecification.getHeaders() +
                "\n Request Body" + filterableRequestSpecification.getBody()+
        "\n response status" + filterableResponseSpecification.getStatusCode()+
                "Response Body" + filterableResponseSpecification.response());
        return response;
    }
}
