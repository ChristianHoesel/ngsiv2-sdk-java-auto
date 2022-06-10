
# Getting Started with FIWARE-NGSI v2 Specification

## Introduction

This specification defines the FIWARE-NGSI version 2 API. FIWARE-NGSI v2 is intended to manage
the entire lifecycle of context information, including updates, queries, registrations,
and subscriptions.

### Preface

#### Editors

José Manuel Cantera Fonseca (FIWARE Foundation e.V., formerly with Telefónica I+D),
Fermín Galán Márquez (Telefónica España, formerly with Telefónica I+D),
Tobias Jacobs (NEC).

#### Acknowledgements

The editors would like to express their gratitude to the following people who actively
contributed to this specification:
Juan José Hierro (FIWARE Foundation e.V., formerly with Telefónica I+D),
Marcos Reyes (Telefónica España, formerly with Telefónica I+D),
Ken Zangelin (APInf, formerly with Telefónica I+D),
Iván Arias León (Telefónica I+D), Carlos Romero Brox (Telefónica I+D),
Antonio José López Navarro (Telefónica I+D),  Marc Capdevielle (Orange), Gilles Privat (Orange),
Sergio García Gómez (Telefónica I+D), Martin Bauer (NEC).

#### Status

This specification is the final and stable version of NGSIv2 API specification (v2.0).

### Changelog

Changes since RC-2018.07:

* None

Changes since RC-2018.04:

* Section "System/builtin Attributes" renamed to "Builtin Attributes"

* Section "System/builtin Metadata" renamed to "Builtin Metadata"

* Added new builtin attribute: `dateExpires`

* Improved description in "Error Response" section

* Added new option for `POST /v2/entities` operation: `upsert`

* Clarification about forwarding compliance in "Group Registrations"

* `actionType` values for `POST /v2/op/update` operation are now in camelCase

* Renamed field `attributes` to `attrs` in `POST /v2/op/query` operation

* Added new field in `POST /v2/op/query` operation: `expression` (old `scope` field has been removed)

* Added new operation `POST /v2/op/notify`

Changes since RC-2017.11:

* `orderBy` may include also `id` and `type` as ordering fields

* Included `registrations_url` in `GET /v2` response

* Added registration management operations
  
  * `GET /v2/registrations`
  * `POST /v2/registrations`
  * `GET /v2/registrations/{id}`
  * `PATCH /v2/registrations/{id}`
  * `DELETE /v2/registrations/{id}`

Changes since RC-2016.10:

* New "System/builtin Metadata" section (using partially former "Special metadata in notifications" section)

* New "Filtering out attributes and metadata" section

* Section "Virtual Attributes" renamed to "System/builtin Attributes"

* New system/builtin metadata: `dateCreated` and `dateModified`

* Added `*` in "Attribute names restrictions" section

* Added `lastFailure` and `lastSuccess` to subscription information

* Added `failed` value for subscription `status` field

* Added `REPLACE` as `actionType` for `POST /v2/op/update` operation, along with a clearer explanation
  of the different action types

* Added `metadata` field to `POST /v2/op/query` operation

* Added `metadata` URI parameter to the following operations:
  
  * `GET /v2/entities`
  * `GET /v2/entities/{entityId}`
  * `GET /v2/entities/{entityId}/attrs`
  * `GET /v2/entities/{entityId}/attrs/{attrName}`

Changes since RC-2016.05:

* Default typing for entities, attributes and metadata aligned with schema.org

* `typePattern` (similar to `idPattern`)

* Simple Query Language: metadata filters (`mq`)

* Simple Query Language: Sub-key filtering (both attribute and metadata values, i.e. `q` and `mq`)

* Notification metadata filtering

* System/builtin metadata in notifications: `previousValue` and `actionType`

#### Copyright

Copyright (c) 2011-2018 Telecom Italia, Telefónica I+D and NEC.

#### License

This specification is licensed under the
[FIWARE Open Specification License (implicit patent license)](https://forge.fiware.org/plugins/mediawiki/wiki/fiware/index.php/Implicit_Patents_License).

#### Conformance

This specification describes the "full" compliance level.

#### Conventions

NGSI version 2 uses camel case (camelCase) syntax for naming properties and related artifacts used
by the API. When  referring to URIs, as part of HATEOAS patterns, and to mark them appropriately,
the suffix `_url` is added.

#### Reference Implementations

* NGISv2 Context Brokers
  * [Orion Context Broker](http://catalogue.fiware.org/enablers/publishsubscribe-context-broker-orion-context-broker) - [Implementation Notes](https://fiware-orion.readthedocs.io/en/master/user/ngsiv2_implementation_notes/index.html)

### Specification

#### Introduction

The FIWARE NGSI (Next Generation Service Interface) API defines

* a **data model** for context information, based on a simple information model using the notion of
  *context entities*

* a **context data interface** for exchanging information by means of query, subscription, and
  update operations

* a **context availability interface** for exchanging information on how to obtain context
  information (whether to separate the two interfaces is currently under discussion).

#### Terminology

##### Context data modelling and exchange

The main elements in the NGSI data model are context entities, attributes and metadata,
as shown in the figure below.

![NGSI data model](https://raw.githubusercontent.com/telefonicaid/fiware-orion/master/doc/apiary/v2/Ngsi-data-model.png)

###### Context Entities

Context entities, or simply entities, are the center of gravity in the FIWARE NGSI information
model. An entity represents a thing, i.e., any physical or logical object (e.g., a sensor, a person,
a room, an issue in a ticketing system, etc.). Each entity has an **entity id**.

Furthermore, the type system of FIWARE NGSI enables entities to have
an **entity type**. Entity types are semantic types; they are intended
to describe the type of thing represented by the entity.
For example, a context entity with id *sensor-365* could have the
type *temperatureSensor*.

Each entity is uniquely identified by the combination of its id and type.

###### Context Attributes

Context attributes are properties of context entities.
For example, the current speed of a car could be modeled as
attribute *current_speed* of entity *car-104*.

In the NGSI data model, attributes have an *attribute name*,
an *attribute type*, an *attribute value* and *metadata*.

* The attribute name describes what kind of property the attribute value represents of the entity,
  for example *current_speed*.

* The attribute type represents the NGSI value type of the attribute value.
  Note that FIWARE NGSI has its own type system for attribute values, so NGSI value types are not
  the same as JSON types.

* The attribute value finally contains
  
  * the actual data
  * optional **metadata** describing properties of the attribute value like e.g. accuracy, provider,
    or a timestamp

###### Context Metadata

Context metadata is used in FIWARE NGSI in several places, one of
them being an optional part of the attribute value as described
above. Similar to attributes, each piece of metadata has:

* **a metadata name**, describing the role of the metadata in the
  place where it occurs; for example, the metadata name *accuracy*
  indicates that the metadata value describes how accurate a given
  attribute value is

* a **metadata type**, describing the NGSI value type of the metadata value

* a **metadata value** containing the actual metadata

Note that in NGSI it is not foreseen that metadata may contain nested metadata.

#### MIME Types

The API response payloads in this specification are based on `application/json` and  (for attribute value
type operation) `text/plain` MIME types. Clients issuing HTTP requests with accept types different
than those will get a `406 Not Acceptable` error.

#### JSON Entity Representation

An entity is represented by a JSON object with the following syntax:

* The entity id is specified by the object's `id` property, whose value is a string containing the
  entity id.

* The entity type is specified by the object's `type` property, whose value is a string containing
  the entity's type name.

* Entity attributes are specified by additional properties, whose names are the `name` of the
  attribute and whose representation is described in the "JSON Attribute Representation" section
  below. Obviously, `id` and `type` are not allowed to be used as attribute names.

An example of this syntax in shown below:

```
{
  "id": "entityID",
  "type": "entityType",
  "attr_1": <val_1>,
  "attr_2": <val_2>,
  ...
  "attr_N": <val_N>
}
```

The normalized representation of entities always include `id`, `type` and the properties that
represent attributes. However, simplified or partial representations
(see the "Partial Representations" section below) may leave some of them out.
The specification of each operation includes details about what representation is expected as input
or what representation will be provided (rendered) as output.

#### JSON Attribute Representation

An attribute is represented by a JSON object with the following syntax:

* The attribute value is specified by the `value` property, whose value may be any JSON datatype.

* The attribute NGSI type is specified by the `type` property, whose value is a string containing
  the NGSI type.

* The attribute metadata is specified by the `metadata` property. Its value is another JSON object
  which contains a property per metadata element defined (the name of the property is the `name` of
  the metadata element). Each metadata element, in turn, is represented by a JSON object containing
  the following properties:
  
  * `value`: Its value contains the metadata value, which may correspond to any JSON datatype.
  
  * `type`: Its value contains a string representation of the metadata NGSI type.

An example of this syntax in shown below:

```
{
  "value": <...>,
  "type": <...>,
  "metadata": <...>
}
```

#### Simplified Entity Representation

There are two representation modes that must be supported by implementations. These representation
modes allow to generate simplified representations of entities.

* *keyValues* mode. This mode represents the entity attributes by their values only, leaving out the
  information about type and metadata.
  See example below.

```
{
  "id": "R12345",
  "type": "Room",
  "temperature": 22
}
```

* *values mode*. This mode represents the entity as an array of attribute values.
  Information about id and type is left out.
  See example below.
  The order of the attributes in the array is specified by the `attrs` URI param
  (e.g. `attrs=branch,colour,engine`). If `attrs` is not used, the order is arbitrary.

```
[ 'Ford', 'black', 78.3 ]
```

* *unique mode*. This mode is just like *values mode*, except that values are not repeated.

#### Partial Representations

Some operations use partial representation of entities:

* `id` and `type` are not allowed in update operations, as they are immutable properties.

* In requests where entity `type` is allowed, it may be omitted. When omitted in entity
  creation operations, the default string value `Thing` is used for the type.

* In some cases, not all the attributes of the entity are shown, e.g. a query selecting a subset
  of the entity attributes.

* Attribute/metadata `value` may be omitted in requests, meaning that the attribute/metadata has
  `null` value. In responses, the value is always present.

* Attribute/metadata `type` may be omitted in requests. When omitted in attribute/metadata creation
  or in update operations, a default is used for the type depending on the value:
  
  * If value is a string, then type `Text` is used
  * If value is a number, then type `Number` is used.
  * If value is a boolean, then type `Boolean` is used.
  * If value is an object or array, then `StructuredValue` is used.
  * If value is null, then `None` is used.

* Attribute `metadata` may be omitted in requests, meaning that there are no metadata elements
  associated to the attribute. In responses, this property is set to
  `{}` if the attribute doesn't have any metadata.

#### Special Attribute Types

Generally speaking, user-defined attribute types are informative; they are processed by the NGSIv2
server in an opaque way. Nonetheless, the types described below are used to convey a special
meaning:

* `DateTime`:  identifies dates, in ISO8601 format. These attributes can be used with the query
  operators greater-than, less-than, greater-or-equal, less-or-equal and range. For instance
  (only the referred entity attribute is shown):

```
{
  "timestamp": {
    "value": "2017-06-17T07:21:24.238Z",
    "type: "DateTime"
  }
}
```

* `geo:point`, `geo:line`, `geo:box`, `geo:polygon` and `geo:json`. They have special semantics
  related with entity location. See "Geospatial properties of entities" section.

#### Builtin Attributes

There are entity properties that are not directly modifiable by NGSIv2 clients, but that can be
rendered by NGSIv2 servers to provide extra information. From a representation point of view, they
are just like regular attributes, with name, value and type.

Builtin attributes are not rendered by default. In order to render a specific attribute, add its
name to the `attrs` parameter in URLs (or payload field in POST /v2/op/query operation) or
subscription (`attrs` sub-field within `notification`).

The list of builtin attributes is as follows:

* `dateCreated` (type: `DateTime`): entity creation date as an ISO 8601 string.

* `dateModified` (type: `DateTime`): entity modification date as an ISO 8601 string.

* `dateExpires` (type: `DateTime`): entity expiration date as an ISO 8601 string. How the server
  controls entity expiration is an implementation specific aspect.

Like regular attributes, they can be  used in `q` filters and in `orderBy`.
However, they cannot be used in resource URLs.

#### Builtin Metadata

Some attribute properties are not directly modifiable by NGSIv2 clients, but they can be
rendered by NGSIv2 servers to provide extra information. From a representational point of view, they
are just like regular metadata, with name, value, and type.

Builtin metadata are not rendered by default. In order to render a specific metadata, add its
name to the `metadata` URL parameter (or payload field in POST /v2/op/query operation) or
subscription (`metadata` sub-field within `notification`).

The list of builtin metadata is as follows:

* `dateCreated` (type: `DateTime`): attribute creation date as an ISO 8601 string.

* `dateModified` (type: `DateTime`): attribute modification date as an ISO 8601 string.

* `previousValue` (type: any): only in notifications. The value of this metadata is the previous
  value (to the request triggering the notification) of the associated attribute. The type of this metadata
  must be the previous type of the associated attribute. If the type/value of `previousValue` is the same
  type/value as in the associated attribute, then the attribute has not actually changed its value.

* `actionType` (type: `Text`): only in notifications.  It is included if the attribute to which it is attached
  was included in the request that triggered the notification. Its value depends on the request operation
  type: `update` for updates, `append` for creation and `delete` for deletion. Its type is always `Text`.

Like regular metadata, they can be  used in `mq` filters. However, they cannot be used in resource URLs.

#### Field syntax restrictions

Fields used as identifiers in the NGSIv2 API follow special rules regarding allowed syntax.
These rules apply to:

* Entity id

* Entity type

* Attribute name

* Attribute type

* Metadata name

* Metadata type

The rules are:

* Allowed characters are the ones in the plain ASCII set, except the following ones:
  control characters, whitespace, `&`, `?`, `/` and `#`.

* Maximum field length is 256 characters.

* Minimum field length is 1 character.

In addition to the above rules, given NGSIv2 server implementations could add additional syntactical
restrictions in those or other fields, e.g., to avoid cross script injection attacks.

In case a client attempts to use a field that is invalid from a syntax point of view, the client
gets a "Bad Request" error response, explaining the cause.

#### Attribute names restrictions

The following strings must not be used as attribute names:

* `id`, as it would conflict with the field used to represent entity id.

* `type`, as it would conflict with the field used to represent entity type.

* `geo:distance`, as it would conflict with the string used in `orderBy` for proximity to
  center point.

* Builtin attribute names (see specific section on "Builtin Attributes")

* `*`, as it has a special meaning as "all the custom/user attributes" (see section on
  "Filtering out attributes and metadata").

#### Metadata names restrictions

The following strings must not be used as metadata names:

* Builtin metadata names (see specific section on "Builtin Metadata")

* `*`, as it has a special meaning as "all the custom/user metadata" (see section on
  "Filtering out attributes and metadata").

#### Ordering Results

Operations that retrieve lists of entities permit the `orderBy` URI parameter to specify the
attributes or properties to be be used as criteria when ordering results.
The value of `orderBy` can be:

* The keyword `geo:distance` to order results by distance to a reference geometry when a "near"
  (`georel=near`) spatial relationship is used.

* A comma-separated list of attributes (including builtin attributes), `id` (for entity
  ID), and `type` (for entity type), e.g. `temperature,!humidity`. Results are ordered by the first
  field. On ties, the results are ordered by the second field and so on. A "!" before
  the field name means that the order is reversed.

#### Error Responses

If present, the error payload is a JSON object including the following fields:

+ `error` (required, string): a textual description of the error.

+ `description` (optional, string): additional information about the error.

All NGSIv2 server implementations must use the following HTTP status codes and `error` texts
described in this section. However, the particular text used for `description` field is
an implementation specific aspect.

NGSIv2 `error` reporting is as follows:

+ If the incoming JSON payload cannot be parsed then `ParseError` (`400`) is returned.

+ Errors which are only caused by request itself (i.e. they do not depend on the NGSIv2 server status),
  either in the URL parameters or in the payload, results in `BadRequest`(`400`).
  
  + Exception: incoming JSON payload errors, which have another `error` message (see previous bullet).

+ Attemp to exceed spatial index limit results in `NoResourceAvailable` (`413`). See "Geospatial properties of entities"
  section for details.

+ Ambiguity due to the request may refer to several resources, e.g. attempt to update an entity providing only its ID
  and several entities with that ID exist, results in `TooManyResults` (`409`).

+ If the resource identified by the request is not found then `NotFound` (`404`) is returned.

+ Errors due to the request plus state combination but not exclusively from the request
  (e.g. POST with `options=append` on an existing attribute) results in `Unprocessable` (`422`).
  
  + Exception: the request plus state conditions that lead to 404, 409 or 413 errors, as described in previous bullets.

+ HTTP layer errors use the following:
  
  + HTTP 405 Method Not Allowed corresponds to `MethodNotAlowed` (`405`)
  + HTTP 411 Length Required corresponds to `ContentLengthRequired` (`411`)
  + HTTP 413 Request Entity Too Large corresponds to `RequestEntityTooLarge` (`413`)
  + HTTP 415 Unsupported Media Type corresponds to `UnsupportedMediaType` (`415`)

#### Geospatial properties of entities

The geospatial properties of a context entity can be represented by means of regular
context attributes.
The provision of geospatial properties enables the resolution of geographical queries.

Two different syntaxes must be supported by compliant implementations:

* *Simple Location Format*. It is meant as a very lightweight format for developers and users to
  quickly and easily add to their existing entities.

* *GeoJSON*.  [GeoJSON](https://tools.ietf.org/html/draft-butler-geojson-06) is a geospatial data
  interchange format based on the JavaScript Object Notation (JSON).
  GeoJSON provides greater flexibility allowing the representation of point altitudes or even more
  complex geospatial shapes, for instance
  [multi geometries](http://www.macwright.org/2015/03/23/geojson-second-bite.html#multi-geometries).

Client applications are responsible for defining which entity attributes convey geospatial
properties (by providing an appropriate NGSI attribute type). Typically this is an entity attribute
named `location`, but nothing prevents use cases where an entity contains more than one geospatial
attribute. For instance, locations specified at different granularity levels or provided by
different location methods with different accuracy.
Nonetheless, it is noteworthy that spatial properties
need special indexes which can be under resource constraints imposed by backend databases.
Thus, implementations may raise errors when spatial index limits are exceeded.
The recommended HTTP status code for those situations is `413`, *Request entity too large*, and
the reported error on the response payload must be `NoResourcesAvailable`.

##### Simple Location Format

Simple Location Format supports basic geometries ( *point*, *line*, *box*, *polygon* ) and covers
the typical use cases when encoding geographical locations. It has been inspired by
[GeoRSS Simple](http://www.georss.org/simple.html).

It is noteworthy that the Simple Location Format is not intended to represent complex positions on
Earth surface.
For instance, applications that require to capture altitude coordinates will have to use GeoJSON as
representation format for the geospatial properties of their entities.

A context attribute representing a location encoded with the Simple Location Format
must conform to the following syntax:

* The attribute type must be one of the following values: (`geo:point`, `geo:line`, `geo:box` or
  `geo:polygon`).

* The attribute value must be a list of coordinates. By default, coordinates are defined
  using the [WGS84 Lat Long](https://en.wikipedia.org/wiki/World_Geodetic_System#WGS84),
  [EPSG::4326](http://www.opengis.net/def/crs/EPSG/0/4326) coordinate reference system (CRS),
  with latitude and longitude units of decimal degrees. Such coordinate list allow to encode
  the geometry specified by the `type` attribute and are encoded according to the specific
  rules defined below:
  
  * Type `geo:point`:   the attribute value must contain a string containing a
    valid latitude-longitude pair, separated by comma.
  * Type `geo:line`:    the attribute value must contain a string array of
    valid latitude-longitude pairs. There must be at least two pairs.
  * Type `geo:polygon`: the attribute value must contain a string array
    of valid latitude-longitude pairs.
    There must be at least four pairs, with the last being identical to the first
    (so a polygon has a minimum of three actual points).
    Coordinate pairs should be properly ordered so that the line segments
    that compose the polygon remain on the outer edge of the defined area.
    For instance, the following path, `[0,0], [0,2], [2,0], [2, 2]`, is an example of an invalid
    polygon definition.
    Implementations should raise an error when none of the former conditions are met by input data.
  * Type `geo:box`:     A bounding box is a rectangular region, often used to define the extents of
    a map or a rough area of interest. A box is represented by a two-length string array of
    latitude-longitude pairs.
    The first pair is the lower corner, the second is the upper corner.

Note: Circle geometries are not supported, as the [literature](https://github.com/geojson/geojson-spec/wiki/Proposal---Circles-and-Ellipses-Geoms#discussion-notes)
describes different shortcomings for implementations.

The examples below illustrate the referred syntax:

```
{
  "location": {
    "value": "41.3763726, 2.186447514",
    "type": "geo:point"
  }
}
```

```
{
  "location": {
    "value": [
      "40.63913831188419, -8.653321266174316",
      "40.63881265804603, -8.653149604797363"
    ],
    "type": "geo:box"
  }
}
```

##### GeoJSON

A context attribute representing a location encoded using GeoJSON must conform to the following
syntax:

* The NGSI type of the attribute must be `geo:json`.

* The attribute value must be a valid GeoJSON object. It is noteworthy that longitude comes before
  latitude in GeoJSON coordinates.

The example below illustrates the usage of GeoJSON.
More GeoJSON examples can be found in [GeoJSON IETF Spec](https://tools.ietf.org/html/draft-butler-geojson-06#page-14).
Additionally, the following
[GeoJSON Tutorial](http://www.macwright.org/2015/03/23/geojson-second-bite.html)
might be useful in understanding the format.

```
{
  "location": {
    "value": {
      "type": "Point",
      "coordinates": [2.186447514, 41.3763726]
    },
    "type": "geo:json"
  }
}
```

#### Simple Query Language

The Simple Query Language provides a simplified syntax to retrieve entities which match a set of
conditions.
A query is composed by a list of statements separated by the ';' character.
Each statement expresses a matching condition.
The query returns all the entities that match all the matching conditions (AND logical operator).

There are two kinds of statements: *unary statements* and *binary statements*.

Binary statements are composed by an attribute path (e.g. `temperature` or `brand.name`), an operator
and a value (whose format depends on the operator), e.g.:

```
temperature==50
temperature<=20
```

The syntax of an attribute path consists of a list of tokens separated by the `.` character. This list of tokens
addresses a JSON property name, in accordance with the following rules:

* The first token is the name of an NGSI attribute (*target NGSI attribute*) of an entity.

* If filtering by attribute value (i.e. the expression is used in a `q` query), the rest of tokens (if present)
  represent the path to a sub-property of the *target NGSI attribute value* (which should be a JSON object).
  Such sub-property is defined as the *target property*.

* If filtering by metadata (i.e. the expression is used in a `mq` query), the second token represents a metadata
  name associated to the target NGSI attribute, *target metadata*, and the rest of tokens
  (if present) represent the path to a sub-property of the *target metadata value* (which should be a
  JSON object). Such sub-property is defined as the *target property*.

The *target property value* is defined as the value of the JSON property addressed by the list of tokens described
above i.e. the value of the *target property*.

In case only one token is provided (two in case of filtering by metadata), then the *target property* will
be the *target NGSI attribute* itself (or the *target metadata* in case of filtering by metadata) and the
*target property value* will be the *target NGSI attribute* value (or the *target metadata* value in case
of filtering by metadata). The value of the *target NGSI attribute* (or the *target metadata*
in case of filtering by metadata) should not be a JSON object in this case.

In case some of the tokens include `.`, you can use single quote (`'`) as separator. For example, the following
attribute path `'a.b'.w.'x.y'` is composed by three tokens: the first token is `a.b`, the second token is `w` and
the third token is `x.y`.

The list of operators (and the format of the values they use) is as follows:

+ **Equal**: `==`. This operator accepts the following types of right-hand side:
  
  + Single element, e.g. `temperature==40`. For an entity to match, it must contain the *target
    property* (temperature) and the *target property value* must be the query value (40)
    (or include the value, in case the *target property value* is an array).
  + A list of comma-separated values, e.g. `color==black,red`. For an entity to match, it must
    contain the *target property* and the *target property value* must be **any** of the values
    in the list (OR clause) (or include **any** of the values in the list in case the *target
    property value* is an array).
    E.g. entities with an attribute named `color`, whose value is `black` are a match, while
    entities with an attribute named `color` but whose value is `white` do not match.
  + A range, specified as a minimum and a maximum, separated by `..`, e.g. `temperature==10..20`.
    For an entity to match, it must contain the *target property* (temperature),
    and the *target property value* must be between the upper and lower limits
    of the range (both included). Ranges can only be used with *target properties* that represent
    dates (in ISO8601 format), numbers or strings.

+ **Unequal**: `!=`. This operator accepts the following types of right-hand side:
  
  + Single element, e.g. `temperature!=41`. For an entity to match, it must contain the *target
    property* (temperature) and the *target property value* must **not** be the query value (41).
  + A list of comma-separated values, e.g. `color!=black,red`. For an entity to match, it must
    contain the *target property* and the *target property value* must **not** be any of the values
    in the list (AND clause) (or not include **any** of the values in the list in case the *target
    property value* is an array).
    Eg. entities whose attribute `color` is set to `black` will not match, while entities whose
    attribute `color` is set to `white` will match.
  + A range, specified as a minimum and maximum separated by `..`, e.g. `temperature!=10..20`.
    For an entity to match, it must contain the *target property* (temperature) and the
    *target property value* must **not** be between the upper and lower limits
    (both included). Ranges can only be used with elements *target properties* that represent dates
    (in ISO8601 format), numbers or strings.

+ **Greater than**: `>`. The right-hand side must be a single element, e.g. `temperature>42`.
  For an entity to match, it must contain the *target property* (temperature)
  and the *target property value* must be strictly greater than the query value (42).
  This operation is only valid for *target properties* of type date, number or string (used with
  *target properties* of other types may lead to unpredictable results).

+ **Less than**: `<`. The right-hand side must be a single element, e.g. `temperature<43`.
  For an entity to match, it must contain the *target property* (temperature)
  and the *target property value* must be strictly less than the value (43).
  This operation is only valid for *target properties* of type date, number or string (used with
  *target properties* of other types may lead to unpredictable results).

+ **Greater or equal than**: `>=`. The right-hand side must be a single element, e.g. `temperature>=44`.
  For an entity to match, it must contain the *target property* (temperature)
  and the *target property value* must be greater than or equal to that value (44).
  This operation is only valid for *target properties* of type date, number or string (used with
  *target properties* of other types may lead to unpredictable results).

+ **Less or equal than**: `<=`. The right-hand side must be a single element, e.g. `temperature<=45`.
  For an entity to match, it must contain the *target property* (temperature)
  and the *target property value* must be less than or equal to that value (45).
  This operation is only valid for *target properties* of type date, number or string (used with
  *target properties* of other types may lead to unpredictable results).

+ **Match pattern**: `~=`. The value matches a given pattern, expressed as a regular expression, e.g.
  `color~=ow`. For an entity to match, it must contain the *target property* (color)
  and the *target property value* must match the string in the right-hand side,
  'ow' in this example (`brown` and `yellow` would match, `black` and `white` would not).
  This operation is only valid for *target properties* of type string.

The symbol `:` can be used instead of `==`.

In case of equal or unequal, if the string to match includes a `,`, you can use single quote
(`'`) to disable the special meaning of the comma,  e.g: `color=='light,green','deep,blue'`.
The first example would match a color with the exact value 'light,green' OR 'deep,blue'. The
simple quote syntax can be also used to force string interpretation in filters, e.g.
`q=title=='20'` will match string "20" but not number 20.

Unary negatory statements use the unary operator `!`, while affirmative unary statements use no
operator at all.
The unary statements are used to check for the existence of the *target property*.
E.g. `temperature` matches entities that have an attribute called 'temperature' (no matter its
value), while `!temperature` matches entities that do not have an attribute called 'temperature'.

#### Geographical Queries

Geographical queries are specified using the following parameters:

`georel` is intended to specify a spatial relationship (a predicate)
between matching entities and a reference shape (`geometry`).
It is composed of a token list separated by ';'.
The first token is the relationship name, the rest of the tokens (if any) are modifiers which
provide more information about the relationship. The following values are recognized:

+ `georel=near`. The `near` relationship means that matching entities must be located at a certain
  threshold distance to the reference geometry. It supports the following modifiers:
  
  + `maxDistance`.  Expresses, in meters, the maximum distance at which matching entities must be
    located.
  + `minDistance`.  Expresses, in meters, the minimum distance at which matching entities must be
    located.

+ `georel=coveredBy`. Denotes that matching entities are those that exist entirely within the
  reference geometry.
  When resolving a query of this type, the border of the shape must be considered to be part of the
  shape.

+ `georel=intersects`. Denotes that matching entities are those intersecting with the reference
  geometry.

+ `georel=equals`. The geometry associated to the position of matching entities and the reference
  geometry must be exactly the same.

+ `georel=disjoint`. Denotes that matching entities are those **not** intersecting with the
  reference geometry.

`geometry` allows to define the reference shape to be used when resolving the query.
The following geometries (see Simple Location Format) must be supported:

+ `geometry=point`, defines a point on the Earth surface.

+ `geometry=line`, defines a polygonal line.

+ `geometry=polygon`, defines a polygon.

+ `geometry=box`, defines a bounding box.

**coords** must be a string containing a semicolon-separated list of pairs of geographical
coordinates in accordance with the geometry specified and the rules mandated by the Simple Location
Format:

* `geometry=point`.   `coords` contains a pair of WGS-84 geo-coordinates.

* `geometry=line`.    `coords` contains a list of pairs of WGS-84 geo-coordinates.

* `geometry=polygon`. `coords` is composed by at least four pairs of WGS-84 geo-coordinates.

* `geometry=box`.     `coords` is composed by two pairs of WGS-84 geo-coordinates.

Examples:

`georel=near;maxDistance:1000&geometry=point&coords=-40.4,-3.5`.
Matching entities must be located (at most) 1000 meters from the reference point.

`georel=near;minDistance:5000&geometry=point&coords=-40.4,-3.5`.
Matching entities must be (at least) 5000 meters from the reference point.

`georel=coveredBy&geometry=polygon&coords=25.774,-80.190;18.466,-66.118;32.321,-64.757;25.774,-80.190`
Matching entities are those located within the referred polygon.

##### Query Resolution

If an implementation is not able to resolve a geographical query, the HTTP Status code of the
response must be `422`, *Unprocessable Entity*. The error name, present in the error payload,
must be `NotSupportedQuery`.

When resolving geographical queries, through the Simple Query Language,
the API implementation is responsible for determining which entity attribute
contains the geographical location to be used for matching purposes.
To this aim, the following rules must be followed:

* If an entity has no attribute corresponding to a location (encoded as GeoJSON or the
  Simple Location Format), then such an entity has not declared any geospatial property and will not
  match any geographical query.

* If an entity only exposes one attribute corresponding to a location, then such an attribute will
  be used when resolving geographical queries.

* If an entity exposes more than one location, then the attribute containing a metadata property
  named `defaultLocation`, with boolean value `true` will be taken as the reference location
  used for resolving geographical queries.

* If there is more than one attribute exposing location but none of them is labeled as default
  location, then the query will be declared ambiguous and an HTTP error response with a `409` code
  must be sent.

* If there is more than one attribute exposing location labeled as *default location*, then the
  query is declared ambiguous and an HTTP error response with a `409` code must be sent.

#### Filtering out attributes and metadata

The `attrs` URL parameter (or field in POST /v2/op/query) can be used in retrieve operations
to specify the list of attributes that must be included in the response. In a similar way, the
`metadata` URL parameter (or field in POST /v2/op/query) can be used to specify the list of metadata
that must be included in the response.

By default, if `attrs` is omitted (or `metadata` is omitted) then all the attributes (all the
metadata) are included, except builtin attributes (metadata). In order to include
builtin attributes (metadata) they have to be explicitly included in `attrs` (`metadata`).

E.g. to include only attributes A and B:

`attrs=A,B`

Note that including *only* builtin attributes (metadata) will avoid any user-defined
attribute (metadata). If you want to include builtin attributes (metadata) *and* user-defined
attributes (metadata) at the same time then

* The user-defined attributes (metadata) have to be explictly included, e.g. to include the user-defined
  attributes A and B along with the builtin attribute `dateModified`, use: `attrs=dateModified,A,B`.

* The special value `*` can be used as an alias meaning "all user-defined attributes (metadata)", e.g.,
  to include all the user-defined attributes along with the builtin attribute `dateModified`
  use: `attrs=dateModified,*`.

Note that the `attrs` and `metadata` fields can be used also in subscriptions (as sub-fields of `notification`)
with the same meaning to specify which attributes (metadata) to include in notifications associated
to that subscription.

#### Notification Messages

Notifications include two fields:

* `subscriptionId` represents the concerned subscription that originates the notification

* `data` is an array with the notification data itself which includes the entity and all concerned
  attributes. Each element in the array corresponds to a different entity. By default, the entities
  are represented in `normalized` mode. However, using the `attrsFormat` modifier, a simplified
  representation mode can be requested.

If `attrsFormat` is `normalized` (or if `attrsFormat` is omitted) then default entity representation
is used:

```
{
  "subscriptionId": "12345",
  "data": [
    {
      "id": "Room1",
      "type": "Room",
      "temperature": {
        "value": 23,
        "type": "Number",
        "metadata": {}
      },
      "humidity": {
        "value": 70,
        "type": "percentage",
        "metadata": {}
      }
    },
    {
      "id": "Room2",
      "type": "Room",
      "temperature": {
        "value": 24,
        "type": "Number",
        "metadata": {}
      }
    }
  ]
}
```

If `attrsFormat` is `keyValues` then keyValues partial entity representation mode is used:

```
{
  "subscriptionId": "12345",
  "data": [
    {
      "id": "Room1",
      "type": "Room",
      "temperature": 23,
      "humidity": 70
    },
    {
      "id": "Room2",
      "type": "Room",
      "temperature": 24
    }
  ]
}
```

If `attrsFormat` is `values` then values partial entity representation mode is used:

```
{
  "subscriptionId": "12345",
  "data": [ [23, 70], [24] ]
}
```

Notifications must include the `Ngsiv2-AttrsFormat` HTTP header with the value of the format of the
associated subscription, so that notification receivers are aware of the format without
needing to process the notification payload.

#### Custom Notifications

NGSIv2 clients can customize HTTP notification messages using a simple template mechanism. The
`notification.httpCustom` property of a subscription allows to specify the following fields
to be templatized:

* `url`

* `headers` (both header name and value can be templatized)

* `qs` (both parameter name and value can be templatized)

* `payload`

The fifth field `method`, lets the NGSIv2 clients select the HTTP method to be used for delivering
the notification, but note that only valid HTTP verbs can be used: GET, PUT, POST, DELETE, PATCH,
HEAD, OPTIONS, TRACE, and CONNECT.

Macro substitution for templates is based on the syntax `${..}`. In particular:

* `${id}` is replaced by the `id` of the entity

* `${type}` is replaced by the `type` of the entity

* Any other `${token}` is replaced by the value of the attribute whose name is `token` or with
  an empty string if the attribute is not included in the notification. If the value is a number,
  a bool or null then its string representation is used. If the value is a JSON array or object
  then its JSON representation as string is used.

Example:

Let's consider the following `notification.httpCustom` object in a given subscription.

```
"httpCustom": {
  "url": "http://foo.com/entity/${id}",
  "headers": {
    "Content-Type": "text/plain"
  },
  "method": "PUT",
  "qs": {
    "type": "${type}"
  },
  "payload": "The temperature is ${temperature} degrees"
}
```

Now let's assume that a notification associated to this subscription is triggered, and that the
notification data is for an entity with id "DC_S1-D41" and type "Room", and including an attribute
named "temperature" with the value 23.4.
The resulting notification after applying the template would be:

```
PUT http://foo.com/entity/DC_S1-D41?type=Room
Content-Type: text/plain
Content-Length: 31

The temperature is 23.4 degrees
```

Some considerations to take into account:

* It is the NGSIv2 client's responsability to ensure that after substitution, the notification is a
  correct HTTP message (e.g. if the Content-Type header is application/xml, then the payload must
  correspond to a well-formed XML document). Specifically, if the resulting URL after applying the
  template is malformed, then no notification is sent.

* In case the data to notify contains more than one entity, a separate notification (HTTP message)
  is sent for each of the entities (contrary to default behaviour, which is to send all entities in
  the same HTTP message).

Note that if a custom payload is used for the notification (the field `payload` is given in the
corresponding subscription), then a value of `custom` is used for the `Ngsiv2-AttrsFormat` header
in the notification.

## Building

The generated code uses a few Maven dependencies e.g., Jackson, OkHttp,
and Apache HttpClient. The reference to these dependencies is already
added in the pom.xml file will be installed automatically. Therefore,
you will need internet access for a successful build.

* In order to open the client library in Eclipse click on `File -> Import`.

![Importing SDK into Eclipse - Step 1](https://apidocs.io/illustration/java?workspaceFolder=FIWARE-NGSI%20v2%20Specification-Java&workspaceName=FIWARENGSIV2Specification&projectName=FIWARENGSIV2SpecificationLib&rootNamespace=org.fiware.lab.orion&groupId=FIWARENGSIV2SpecificationLib&artifactId=fiwarengsiv2-specification-lib&version=2.0.0&step=import0)

* In the import dialog, select `Existing Java Project` and click `Next`.

![Importing SDK into Eclipse - Step 2](https://apidocs.io/illustration/java?workspaceFolder=FIWARE-NGSI%20v2%20Specification-Java&workspaceName=FIWARENGSIV2Specification&projectName=FIWARENGSIV2SpecificationLib&rootNamespace=org.fiware.lab.orion&groupId=FIWARENGSIV2SpecificationLib&artifactId=fiwarengsiv2-specification-lib&version=2.0.0&step=import1)

* Browse to locate the folder containing the source code. Select the detected location of the project and click `Finish`.

![Importing SDK into Eclipse - Step 3](https://apidocs.io/illustration/java?workspaceFolder=FIWARE-NGSI%20v2%20Specification-Java&workspaceName=FIWARENGSIV2Specification&projectName=FIWARENGSIV2SpecificationLib&rootNamespace=org.fiware.lab.orion&groupId=FIWARENGSIV2SpecificationLib&artifactId=fiwarengsiv2-specification-lib&version=2.0.0&step=import2)

* Upon successful import, the project will be automatically built by Eclipse after automatically resolving the dependencies.

![Importing SDK into Eclipse - Step 4](https://apidocs.io/illustration/java?workspaceFolder=FIWARE-NGSI%20v2%20Specification-Java&workspaceName=FIWARENGSIV2Specification&projectName=FIWARENGSIV2SpecificationLib&rootNamespace=org.fiware.lab.orion&groupId=FIWARENGSIV2SpecificationLib&artifactId=fiwarengsiv2-specification-lib&version=2.0.0&step=import3)

## Installation

The following section explains how to use the FIWARENGSIV2SpecificationLib library in a new project.

### 1. Starting a new project

For starting a new project, click the menu command `File > New > Project`.

![Add a new project in Eclipse](https://apidocs.io/illustration/java?workspaceFolder=FIWARE-NGSI%20v2%20Specification-Java&workspaceName=FIWARENGSIV2Specification&projectName=FIWARENGSIV2SpecificationLib&rootNamespace=org.fiware.lab.orion&groupId=FIWARENGSIV2SpecificationLib&artifactId=fiwarengsiv2-specification-lib&version=2.0.0&step=createNewProject0)

Next, choose `Maven > Maven Project` and click `Next`.

![Create a new Maven Project - Step 1](https://apidocs.io/illustration/java?workspaceFolder=FIWARE-NGSI%20v2%20Specification-Java&workspaceName=FIWARENGSIV2Specification&projectName=FIWARENGSIV2SpecificationLib&rootNamespace=org.fiware.lab.orion&groupId=FIWARENGSIV2SpecificationLib&artifactId=fiwarengsiv2-specification-lib&version=2.0.0&step=createNewProject1)

Here, make sure to use the current workspace by choosing `Use default Workspace location`, as shown in the picture below and click `Next`.

![Create a new Maven Project - Step 2](https://apidocs.io/illustration/java?workspaceFolder=FIWARE-NGSI%20v2%20Specification-Java&workspaceName=FIWARENGSIV2Specification&projectName=FIWARENGSIV2SpecificationLib&rootNamespace=org.fiware.lab.orion&groupId=FIWARENGSIV2SpecificationLib&artifactId=fiwarengsiv2-specification-lib&version=2.0.0&step=createNewProject2)

Following this, select the *quick start* project type to create a simple project with an existing class and a `main` method. To do this, choose `maven-archetype-quickstart` item from the list and click `Next`.

![Create a new Maven Project - Step 3](https://apidocs.io/illustration/java?workspaceFolder=FIWARE-NGSI%20v2%20Specification-Java&workspaceName=FIWARENGSIV2Specification&projectName=FIWARENGSIV2SpecificationLib&rootNamespace=org.fiware.lab.orion&groupId=FIWARENGSIV2SpecificationLib&artifactId=fiwarengsiv2-specification-lib&version=2.0.0&step=createNewProject3)

In the last step, provide a `Group Id` and `Artifact Id` as shown in the picture below and click `Finish`.

![Create a new Maven Project - Step 4](https://apidocs.io/illustration/java?workspaceFolder=FIWARE-NGSI%20v2%20Specification-Java&workspaceName=FIWARENGSIV2Specification&projectName=FIWARENGSIV2SpecificationLib&rootNamespace=org.fiware.lab.orion&groupId=FIWARENGSIV2SpecificationLib&artifactId=fiwarengsiv2-specification-lib&version=2.0.0&step=createNewProject4)

### 2. Add reference of the library project

The created Maven project manages its dependencies using its `pom.xml` file. In order to add a dependency on the *FIWARENGSIV2SpecificationLib* client library, double click on the `pom.xml` file in the `Package Explorer`. Opening the `pom.xml` file will render a graphical view on the canvas. Here, switch to the `Dependencies` tab and click the `Add` button as shown in the picture below.

![Adding dependency to the client library - Step 1](https://apidocs.io/illustration/java?workspaceFolder=FIWARE-NGSI%20v2%20Specification-Java&workspaceName=FIWARENGSIV2Specification&projectName=FIWARENGSIV2SpecificationLib&rootNamespace=org.fiware.lab.orion&groupId=FIWARENGSIV2SpecificationLib&artifactId=fiwarengsiv2-specification-lib&version=2.0.0&step=testProject0)

Clicking the `Add` button will open a dialog where you need to specify FIWARENGSIV2SpecificationLib in `Group Id`, fiwarengsiv2-specification-lib in `Artifact Id` and 2.0.0 in the `Version` fields. Once added click `OK`. Save the `pom.xml` file.

![Adding dependency to the client library - Step 2](https://apidocs.io/illustration/java?workspaceFolder=FIWARE-NGSI%20v2%20Specification-Java&workspaceName=FIWARENGSIV2Specification&projectName=FIWARENGSIV2SpecificationLib&rootNamespace=org.fiware.lab.orion&groupId=FIWARENGSIV2SpecificationLib&artifactId=fiwarengsiv2-specification-lib&version=2.0.0&step=testProject1)

![Adding sample code](https://apidocs.io/illustration/java?workspaceFolder=FIWARE-NGSI%20v2%20Specification-Java&workspaceName=FIWARENGSIV2Specification&projectName=FIWARENGSIV2SpecificationLib&rootNamespace=org.fiware.lab.orion&groupId=FIWARENGSIV2SpecificationLib&artifactId=fiwarengsiv2-specification-lib&version=2.0.0&step=testProject2)

### 3. Write sample code

Once the `SimpleConsoleApp` is created, a file named `App.java` will be visible in the *Package Explorer* with a `main` method. This is the entry point for the execution of the created project.
Here, you can add code to initialize the client library and instantiate a *Controller* class. Sample code to initialize the client library and using controller methods is given in the subsequent sections.

## Test the SDK

The generated code and the server can be tested using automatically generated test cases.
JUnit is used as the testing framework and test runner.

In Eclipse, for running the tests do the following:

1. Select the project FIWARENGSIV2SpecificationLib from the package explorer.
2. Select `Run -> Run as -> JUnit Test` or use `Alt + Shift + X` followed by `T` to run the Tests.

## Initialize the API Client

**_Note:_** Documentation for the client can be found [here.](doc/client.md)

The following parameters are configurable for the API Client:

| Parameter | Type | Description |
|  --- | --- | --- |
| `httpClientConfig` | `ReadonlyHttpClientConfiguration` | Http Client Configuration instance. |

The API client can be initialized as follows:

```java
FIWARENGSIV2SpecificationClient client = new FIWARENGSIV2SpecificationClient.Builder()
    .httpClientConfig(configBuilder -> configBuilder
            .timeout(0))
    .build();
```

## List of APIs

* [API Entry Point](doc/controllers/api-entry-point.md)
* [Entities](doc/controllers/entities.md)
* [Attributes](doc/controllers/attributes.md)
* [Attribute Value](doc/controllers/attribute-value.md)
* [Types](doc/controllers/types.md)
* [Subscriptions](doc/controllers/subscriptions.md)
* [Registrations](doc/controllers/registrations.md)
* [Batch Operations](doc/controllers/batch-operations.md)

## Classes Documentation

* [Utility Classes](doc/utility-classes.md)
* [HttpRequest](doc/http-request.md)
* [HttpResponse](doc/http-response.md)
* [HttpStringResponse](doc/http-string-response.md)
* [HttpContext](doc/http-context.md)
* [HttpBodyRequest](doc/http-body-request.md)
* [HttpCallback Interface](doc/http-callback-interface.md)
* [Headers](doc/headers.md)
* [ApiException](doc/api-exception.md)
* [Configuration Interface](doc/configuration-interface.md)
* [HttpClientConfiguration](doc/http-client-configuration.md)
* [HttpClientConfiguration.Builder](doc/http-client-configuration-builder.md)

