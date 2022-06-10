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
 * UpdateAttributeValueRequest
 */
@JsonPropertyOrder({
  UpdateAttributeValueRequest.JSON_PROPERTY_ADDRESS,
  UpdateAttributeValueRequest.JSON_PROPERTY_ZIP_CODE,
  UpdateAttributeValueRequest.JSON_PROPERTY_CITY,
  UpdateAttributeValueRequest.JSON_PROPERTY_COUNTRY
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-06-11T00:46:31.524327+03:00[Europe/Athens]")
public class UpdateAttributeValueRequest {
  public static final String JSON_PROPERTY_ADDRESS = "address";
  private String address;

  public static final String JSON_PROPERTY_ZIP_CODE = "zipCode";
  private Integer zipCode;

  public static final String JSON_PROPERTY_CITY = "city";
  private String city;

  public static final String JSON_PROPERTY_COUNTRY = "country";
  private String country;

  public UpdateAttributeValueRequest() { 
  }

  public UpdateAttributeValueRequest address(String address) {
    this.address = address;
    return this;
  }

   /**
   * 
   * @return address
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "Ronda de la Comunicacion s/n", required = true, value = "")
  @JsonProperty(JSON_PROPERTY_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getAddress() {
    return address;
  }


  @JsonProperty(JSON_PROPERTY_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setAddress(String address) {
    this.address = address;
  }


  public UpdateAttributeValueRequest zipCode(Integer zipCode) {
    this.zipCode = zipCode;
    return this;
  }

   /**
   * 
   * @return zipCode
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "28050", required = true, value = "")
  @JsonProperty(JSON_PROPERTY_ZIP_CODE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Integer getZipCode() {
    return zipCode;
  }


  @JsonProperty(JSON_PROPERTY_ZIP_CODE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setZipCode(Integer zipCode) {
    this.zipCode = zipCode;
  }


  public UpdateAttributeValueRequest city(String city) {
    this.city = city;
    return this;
  }

   /**
   * 
   * @return city
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "Madrid", required = true, value = "")
  @JsonProperty(JSON_PROPERTY_CITY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getCity() {
    return city;
  }


  @JsonProperty(JSON_PROPERTY_CITY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCity(String city) {
    this.city = city;
  }


  public UpdateAttributeValueRequest country(String country) {
    this.country = country;
    return this;
  }

   /**
   * 
   * @return country
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "Spain", required = true, value = "")
  @JsonProperty(JSON_PROPERTY_COUNTRY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getCountry() {
    return country;
  }


  @JsonProperty(JSON_PROPERTY_COUNTRY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCountry(String country) {
    this.country = country;
  }


  /**
   * Return true if this UpdateAttributeValueRequest object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateAttributeValueRequest updateAttributeValueRequest = (UpdateAttributeValueRequest) o;
    return Objects.equals(this.address, updateAttributeValueRequest.address) &&
        Objects.equals(this.zipCode, updateAttributeValueRequest.zipCode) &&
        Objects.equals(this.city, updateAttributeValueRequest.city) &&
        Objects.equals(this.country, updateAttributeValueRequest.country);
  }

  @Override
  public int hashCode() {
    return Objects.hash(address, zipCode, city, country);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateAttributeValueRequest {\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    zipCode: ").append(toIndentedString(zipCode)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
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

