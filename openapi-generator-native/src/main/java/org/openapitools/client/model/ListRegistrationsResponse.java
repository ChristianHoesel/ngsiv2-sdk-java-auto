/*
 * FIWARE-NGSI v2 Specification
 * TODO: Add a description
 *
 * The version of the OpenAPI document: 1.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.client.model;

import java.util.Objects;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * ListRegistrationsResponse
 */
@JsonPropertyOrder({
  ListRegistrationsResponse.JSON_PROPERTY_ID,
  ListRegistrationsResponse.JSON_PROPERTY_DESCRIPTION,
  ListRegistrationsResponse.JSON_PROPERTY_DATA_PROVIDED,
  ListRegistrationsResponse.JSON_PROPERTY_PROVIDER,
  ListRegistrationsResponse.JSON_PROPERTY_EXPIRES,
  ListRegistrationsResponse.JSON_PROPERTY_STATUS,
  ListRegistrationsResponse.JSON_PROPERTY_FORWARDING_INFORMATION
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-06-11T00:46:31.524327+03:00[Europe/Athens]")
public class ListRegistrationsResponse {
  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  private String description;

  public static final String JSON_PROPERTY_DATA_PROVIDED = "dataProvided";
  private Object dataProvided;

  public static final String JSON_PROPERTY_PROVIDER = "provider";
  private Object provider;

  public static final String JSON_PROPERTY_EXPIRES = "expires";
  private String expires;

  public static final String JSON_PROPERTY_STATUS = "status";
  private String status;

  public static final String JSON_PROPERTY_FORWARDING_INFORMATION = "forwardingInformation";
  private Object forwardingInformation;

  public ListRegistrationsResponse() { 
  }

  public ListRegistrationsResponse id(String id) {
    this.id = id;
    return this;
  }

   /**
   * 
   * @return id
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "abcdefg", required = true, value = "")
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getId() {
    return id;
  }


  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setId(String id) {
    this.id = id;
  }


  public ListRegistrationsResponse description(String description) {
    this.description = description;
    return this;
  }

   /**
   * 
   * @return description
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "Example Context Source", required = true, value = "")
  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getDescription() {
    return description;
  }


  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDescription(String description) {
    this.description = description;
  }


  public ListRegistrationsResponse dataProvided(Object dataProvided) {
    this.dataProvided = dataProvided;
    return this;
  }

   /**
   * 
   * @return dataProvided
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "{\"entities\":[{\"id\":\"Bcn_Welt\",\"type\":\"Room\"}],\"attrs\":[\"temperature\"]}", required = true, value = "")
  @JsonProperty(JSON_PROPERTY_DATA_PROVIDED)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Object getDataProvided() {
    return dataProvided;
  }


  @JsonProperty(JSON_PROPERTY_DATA_PROVIDED)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDataProvided(Object dataProvided) {
    this.dataProvided = dataProvided;
  }


  public ListRegistrationsResponse provider(Object provider) {
    this.provider = provider;
    return this;
  }

   /**
   * 
   * @return provider
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "{\"http\":{\"url\":\"http://contextsource.example.org\"},\"supportedForwardingMode\":\"all\"}", required = true, value = "")
  @JsonProperty(JSON_PROPERTY_PROVIDER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Object getProvider() {
    return provider;
  }


  @JsonProperty(JSON_PROPERTY_PROVIDER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setProvider(Object provider) {
    this.provider = provider;
  }


  public ListRegistrationsResponse expires(String expires) {
    this.expires = expires;
    return this;
  }

   /**
   * 
   * @return expires
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "10/31/2017 12:00:00 PM", required = true, value = "")
  @JsonProperty(JSON_PROPERTY_EXPIRES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getExpires() {
    return expires;
  }


  @JsonProperty(JSON_PROPERTY_EXPIRES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setExpires(String expires) {
    this.expires = expires;
  }


  public ListRegistrationsResponse status(String status) {
    this.status = status;
    return this;
  }

   /**
   * 
   * @return status
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "active", required = true, value = "")
  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getStatus() {
    return status;
  }


  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setStatus(String status) {
    this.status = status;
  }


  public ListRegistrationsResponse forwardingInformation(Object forwardingInformation) {
    this.forwardingInformation = forwardingInformation;
    return this;
  }

   /**
   * 
   * @return forwardingInformation
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "{\"timesSent\":12,\"lastForwarding\":\"2017-10-06T16:00:00Z\",\"lastSuccess\":\"2017-10-06T16:00:00Z\",\"lastFailure\":\"2017-10-05T16:00:00Z\"}", required = true, value = "")
  @JsonProperty(JSON_PROPERTY_FORWARDING_INFORMATION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Object getForwardingInformation() {
    return forwardingInformation;
  }


  @JsonProperty(JSON_PROPERTY_FORWARDING_INFORMATION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setForwardingInformation(Object forwardingInformation) {
    this.forwardingInformation = forwardingInformation;
  }


  /**
   * Return true if this ListRegistrationsResponse object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListRegistrationsResponse listRegistrationsResponse = (ListRegistrationsResponse) o;
    return Objects.equals(this.id, listRegistrationsResponse.id) &&
        Objects.equals(this.description, listRegistrationsResponse.description) &&
        Objects.equals(this.dataProvided, listRegistrationsResponse.dataProvided) &&
        Objects.equals(this.provider, listRegistrationsResponse.provider) &&
        Objects.equals(this.expires, listRegistrationsResponse.expires) &&
        Objects.equals(this.status, listRegistrationsResponse.status) &&
        Objects.equals(this.forwardingInformation, listRegistrationsResponse.forwardingInformation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, description, dataProvided, provider, expires, status, forwardingInformation);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListRegistrationsResponse {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    dataProvided: ").append(toIndentedString(dataProvided)).append("\n");
    sb.append("    provider: ").append(toIndentedString(provider)).append("\n");
    sb.append("    expires: ").append(toIndentedString(expires)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    forwardingInformation: ").append(toIndentedString(forwardingInformation)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

