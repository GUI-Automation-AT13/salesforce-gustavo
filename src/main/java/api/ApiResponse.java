package api;

import io.restassured.response.Response;

public class ApiResponse {
    private Response response;

    public ApiResponse(final Response response) {
        this.response = response;
    }

    /**
     * Gets the response.
     *
     * @return a Response.
     */
    public Response getResponse() {
        return response;
    }

    /**
     * Gets status code to response.
     *
     * @return a status code.
     */
    public int getStatusCode() {
        return response.getStatusCode();
    }

    /**
     * Gets the response in a object.
     *
     * @param cls is type of class.
     * @param <T> is type of class.
     * @return the response in a object.
     */
    public <T> T getBody(final Class<T> cls) {
        return response.getBody().as(cls);
    }

//    public <T> List<T> getBody(Class <T> cls){
//        return response.getBody().as(cls);
//    }

//    /**
//     * Verifies schema with Path setting in String schema.
//     *
//     * @param schema is path to schema type json
//     */
//    public void validateBodySchema(final String schema) {
//        response.then().log().body().assertThat().body(matchesJsonSchemaInClasspath(schema));
//    }
}
