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
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * UpdateRequest
 */
@JsonPropertyOrder({
  UpdateRequest.JSON_PROPERTY_ACTION_TYPE,
  UpdateRequest.JSON_PROPERTY_ENTITIES
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-06-11T00:46:31.524327+03:00[Europe/Athens]")
public class UpdateRequest {
  public static final String JSON_PROPERTY_ACTION_TYPE = "actionType";
  private String actionType;

  public static final String JSON_PROPERTY_ENTITIES = "entities";
  private List<Object> entities = new ArrayList<>();

  public UpdateRequest() { 
  }

  public UpdateRequest actionType(String actionType) {
    this.actionType = actionType;
    return this;
  }

   /**
   * 
   * @return actionType
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "append", required = true, value = "")
  @JsonProperty(JSON_PROPERTY_ACTION_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getActionType() {
    return actionType;
  }


  @JsonProperty(JSON_PROPERTY_ACTION_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setActionType(String actionType) {
    this.actionType = actionType;
  }


  public UpdateRequest entities(List<Object> entities) {
    this.entities = entities;
    return this;
  }

  public UpdateRequest addEntitiesItem(Object entitiesItem) {
    this.entities.add(entitiesItem);
    return this;
  }

   /**
   * 
   * @return entities
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "[{type=Room, id=Bcn-Welt, temperature={value=21.7}, humidity={value=60}}, {type=Room, id=Mad_Aud, temperature={value=22.9}, humidity={value=85}}]", required = true, value = "")
  @JsonProperty(JSON_PROPERTY_ENTITIES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<Object> getEntities() {
    return entities;
  }


  @JsonProperty(JSON_PROPERTY_ENTITIES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setEntities(List<Object> entities) {
    this.entities = entities;
  }


  /**
   * Return true if this UpdateRequest object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateRequest updateRequest = (UpdateRequest) o;
    return Objects.equals(this.actionType, updateRequest.actionType) &&
        Objects.equals(this.entities, updateRequest.entities);
  }

  @Override
  public int hashCode() {
    return Objects.hash(actionType, entities);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateRequest {\n");
    sb.append("    actionType: ").append(toIndentedString(actionType)).append("\n");
    sb.append("    entities: ").append(toIndentedString(entities)).append("\n");
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

