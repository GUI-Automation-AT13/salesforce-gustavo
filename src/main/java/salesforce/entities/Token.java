package salesforce.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Token {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String accessToken;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String instanceUrl;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String tokenType;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String issuedAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String signature;

    @JsonProperty("access_token")
    public String getAccessToken() {
        return accessToken;
    }

    @JsonProperty("access_token")
    public void setAccessToken(final String accessToken) {
        this.accessToken = accessToken;
    }

    @JsonProperty("instance_url")
    public String getInstanceUrl() {
        return instanceUrl;
    }

    @JsonProperty("instance_url")
    public void setInstanceUrl(final String instanceUrl) {
        this.instanceUrl = instanceUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    @JsonProperty("token_type")
    public String getTokenType() {
        return tokenType;
    }

    @JsonProperty("token_type")
    public void setTokenType(final String tokenType) {
        this.tokenType = tokenType;
    }

    @JsonProperty("issued_at")
    public String getIssuedAt() {
        return issuedAt;
    }

    @JsonProperty("issued_at")
    public void setIssuedAt(final String issuedAt) {
        this.issuedAt = issuedAt;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(final String signature) {
        this.signature = signature;
    }
}
