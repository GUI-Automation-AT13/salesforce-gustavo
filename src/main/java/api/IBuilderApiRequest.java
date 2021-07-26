package api;

public interface IBuilderApiRequest {
    ApiRequest build();

    ApiRequestBuilder body(String body);

    ApiRequestBuilder method(Enum<ApiMethod> method);

    ApiRequestBuilder headers(String header, String value);

    ApiRequestBuilder pathParams(String param, String value);

    ApiRequestBuilder endpoint(String endpoint);
}
