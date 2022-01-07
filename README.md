# avro-example
Apache avro serialization and deserialization example for generic and specific record in java

# To generate  Avro classes for a given schema(eg:emp.avsc)
Download avro-tools jar (avro-tools-1.8.2.jar) and execute the following command
java -jar avro-tools-1.7.7.jar compile schema emp.avsc ./generatedavroclass

# What is avro?
Apache Avro is a language-neutral data serialization system which is used in big data ecosystem. The serialized data is stored in birary format

# Advantages of avro over JOSN
It has a direct mapping to and from JSON. It has a very compact format. The bulk of JSON, repeating every field name with every single record, is what makes JSON inefficient for high-volume usage.

# Why we need serialization?
 We need to serialize data for persistant storage and transporting over network

# What is Serialization?
Serialization is the process of translating data structures or objects state into binary or textual form to transport the data over network or to store on some persisten storage. Once the data is transported over network or retrieved from the persistent storage, it needs to be deserialized again.

# Schema
Avro schema  data definition  in JSON format. It contain all the infomation about the data

# Schema sample
{"namespace": "com.jinu.avro.dto",<br />
 "type": "record",<br />
 "name": "User",<br />
 "fields": [<br />
     {"name": "name", "type": "string"},<br />
     {"name": "userId",  "type": ["null", "int"],"default": null},<br />
     {"name": "email", "type": ["null", "string"],"default": null}<br />
 ]<br />
}<br />

# Schema fields

type − This field comes under the document as well as the under the field named fields.
In case of document, it shows the type of the document, generally a record because there are multiple fields.
When it is field, the type describes data type.

namespace − This field describes the name of the namespace in which the object resides(package name)

name − This field comes under the document as well as the under the field named fields.
In case of document, it describes the schema name. This schema name together with the namespace, uniquely identifies the schema within the store . 
In case of fields, it describes name of the field.

fields − This field holds a JSON array, which have the list of all of the fields in the schema, each having name and the type attributes.

# Types
# 1 Primitive Data Types of Avro

null,int,long,float,double,bytes,string

# 2 Complex Data Types of Avro

Along with primitive data types, Avro provides six complex data types namely Records, Enums, Arrays, Maps, Unions, and Fixed.

# Enum
An enumeration is a list of items in a collection
symbols − The value of this field holds the enum's symbols as an array of names.

Example

Given below is the example of an enumeration.

{<br />
   "type" : "enum",<br />
   "name" : "Numbers", <br />
   "namespace": "data", <br />
   "symbols" : [ "ONE", "TWO", "THREE", "FOUR" ] <br />
}<br />

Arrays
This data type defines an array field having a single attribute items. This items attribute specifies the type of items in the array.

Example

{ " type " : " array ", " items " : " int " }<br />
Maps
The map data type is an array of key-value pairs, it organizes data as key-value pairs. The key for an Avro map must be a string. The values of a map hold the data type of the content of map.

Example

{"type" : "map", "values" : "int"}<br />
Unions
A union datatype is used whenever the field has one or more datatypes. They are represented as JSON arrays. For example, if a field that could be either an int or null, then the union is represented as ["int", "null"].

Example

Given below is an example document using unions −

{  <br />
   "type" : "record",  <br />
   "namespace" : "tutorialspoint",  <br /> 
   "name" : "empdetails ",  <br />
   "fields" :  <br />
   [  <br />
      { "name" : "experience", "type": ["int", "null"] }, { "name" : "age", "type": "int" }  <br />
   ]  <br />
} <br />

Note : for union datatype if dafault value is setting , then it should be of first data type of union datatype

 {"name": "email", "type": ["null", "string"],"default": null} <br /> 





