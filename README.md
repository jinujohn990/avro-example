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




