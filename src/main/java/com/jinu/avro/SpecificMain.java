package com.jinu.avro;

import java.io.File;
import java.io.IOException;

import org.apache.avro.Schema;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.reflect.ReflectData;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;

import com.jinu.avro.dto.User;

public class SpecificMain {
	public static void main(String[] args) {

		User user1 = new User();
		user1.setName("user1");
		user1.setUserId(1001);
		user1.setEmail("user1@gmail.com");

		User user2 = User.newBuilder().setName("user2").setUserId(1002).setEmail("user2@gmail.com").build();
		User user3 = User.newBuilder().setName("user3").setUserId(1003).build();
		User user4 = User.newBuilder().setName("user4").setEmail("user4@gmail.com").build();

		File file = new File("userspecific.avro");
		DatumWriter<User> datumWritter = new SpecificDatumWriter<>();
		try (DataFileWriter<User> dataFileWritter = new DataFileWriter<User>(datumWritter)) {
			dataFileWritter.create(user1.getSchema(), file);
			dataFileWritter.append(user1);
			dataFileWritter.append(user2);
			dataFileWritter.append(user3);
			dataFileWritter.append(user4);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Serialization completed.....");

		// Deserialize users from disk
		System.out.println("Deserialization started.....");

		DatumReader<User> datumReader = new SpecificDatumReader<>(User.class);
		User user = null;
		try (DataFileReader<User> dataFileReader = new DataFileReader<>(file, datumReader)) {
			while (dataFileReader.hasNext()) {
				user = dataFileReader.next();
				System.out.println(user);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Deserialization completed.....");

	}
}
