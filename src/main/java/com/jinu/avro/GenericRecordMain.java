package com.jinu.avro;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.avro.Schema;
import org.apache.avro.Schema.Parser;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;

public class GenericRecordMain {
	public static void main(String[] args) throws IOException {
		//Parsing avro schema
		//Schema schema = new Schema.Parser().parse(new File("D:\\JAVA_WORLD\\Projects\\Avro\\user.avsc"));
		GenericRecordMain genericRecordMain = new GenericRecordMain();
		InputStream inputStream = genericRecordMain.getClass().getResourceAsStream("/user.avsc");
		Schema schema = new Parser().parse(inputStream);
		
		//Creating and populating Generic record data
		GenericRecord user1 = new GenericData.Record(schema);
		user1.put("name", "user1");
		user1.put("userId", 1001);
		user1.put("email", "user1@gmail.com");
		GenericRecord user2 = new GenericData.Record(schema);
		user2.put("name", "user2");
		user2.put("userId", 1002);
		user2.put("email", "user2@gmail.com");
		
		GenericRecord user3 = new GenericData.Record(schema);
		user3.put("name", "user3");
		user3.put("userId", 1003);
		
		GenericRecord user4 = new GenericData.Record(schema);
		user4.put("name", "user4");
		user4.put("email", "user4@gmail.com");

		File file = new File("D:\\JAVA_WORLD\\Projects\\Avro\\users.avro");
		DatumWriter<GenericRecord> datumWriter = new GenericDatumWriter<GenericRecord>(schema);
		try (DataFileWriter<GenericRecord> dataFileWriter = new DataFileWriter<GenericRecord>(datumWriter)) {
			dataFileWriter.create(schema, file);
			dataFileWriter.append(user1);
			dataFileWriter.append(user2);
			dataFileWriter.append(user3);
			dataFileWriter.append(user4);
		} catch (IOException e) {
			e.printStackTrace();			
		}
		System.out.println("Serialization completed.....");
		
		//Deserialize users from disk
		System.out.println("Deserialization started.....");
		DatumReader<GenericRecord> datumReader = new GenericDatumReader<GenericRecord>(schema);
		GenericRecord user = null;
		try(DataFileReader<GenericRecord> datafileReader = new DataFileReader<GenericRecord>(file, datumReader)) {
			while(datafileReader.hasNext()) {
				user = datafileReader.next();
				System.out.println(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Deserialization completed.....");

	}
}
