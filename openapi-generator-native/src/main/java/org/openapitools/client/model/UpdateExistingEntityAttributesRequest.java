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
 * UpdateExistingEntityAttributesRequest
 */
@JsonPropertyOrder({
  UpdateExistingEntityAttributesRequest.JSON_PROPERTY_TEMPERATURE,
  UpdateExistingEntityAttributesRequest.JSON_PROPERTY_SEAT_NUMBER
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-06-11T00:46:31.524327+03:00[Europe/Athens]")
public class UpdateExistingEntityAttributesRequest {
  public static final String JSON_PROPERTY_TEMPERATURE = "temperature";
  private Object temperature;

  public static final String JSON_PROPERTY_SEAT_NUMBER = "seatNumber";
  private Object seatNumber;

  public UpdateExistingEntityAttributesRequest() { 
  }

  public UpdateExistingEntityAttributesRequest temperature(Object temperature) {
    this.temperature = temperature;
    return this;
  }

   /**
   * 
   * @return temperature
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "{\"value\":25.5}", required = true, value = "")
  @JsonProperty(JSON_PROPERTY_TEMPERATURE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Object getTemperature() {
    return temperature;
  }


  @JsonProperty(JSON_PROPERTY_TEMPERATURE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setTemperature(Object temperature) {
    this.temperature = temperature;
  }


  public UpdateExistingEntityAttributesRequest seatNumber(Object seatNumber) {
    this.seatNumber = seatNumber;
    return this;
  }

   /**
   * 
   * @return seatNumber
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "{\"value\":6}", required = true, value = "")
  @JsonProperty(JSON_PROPERTY_SEAT_NUMBER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Object getSeatNumber() {
    return seatNumber;
  }


  @JsonProperty(JSON_PROPERTY_SEAT_NUMBER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setSeatNumber(Object seatNumber) {
    this.seatNumber = seatNumber;
  }


  /**
   * Return true if this UpdateExistingEntityAttributesRequest object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateExistingEntityAttributesRequest updateExistingEntityAttributesRequest = (UpdateExistingEntityAttributesRequest) o;
    return Objects.equals(this.temperature, updateExistingEntityAttributesRequest.temperature) &&
        Objects.equals(this.seatNumber, updateExistingEntityAttributesRequest.seatNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(temperature, seatNumber);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateExistingEntityAttributesRequest {\n");
    sb.append("    temperature: ").append(toIndentedString(temperature)).append("\n");
    sb.append("    seatNumber: ").append(toIndentedString(seatNumber)).append("\n");
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

