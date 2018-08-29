package com.project.microservices.ToDoMicroservice;

import com.project.microservices.ToDoMicroservice.daos.*;
import com.project.microservices.ToDoMicroservice.entities.ToDo;
import com.project.microservices.ToDoMicroservice.entities.User;
import com.project.microservices.ToDoMicroservice.utilities.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;


@SpringBootApplication
public class ToDoMicroserviceApplication implements CommandLineRunner {

	@Autowired
	UserDao userDao;  //UserDaoImpl   UserDao userDao = new UserDaoImpl();

	@Autowired
	ToDoDao toDoDao;

	@Autowired
	EncryptionUtils encryptionUtils;

	private static final Logger log = LoggerFactory.getLogger(ToDoMicroserviceApplication.class);

	public static void main(String[] args) {



		SpringApplication.run(ToDoMicroserviceApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {

		log.info("lets fill H2 in-memory database");

		//everything here is implemented before our Microservice will be available for HTTP Requests

		String encryptedPwd;
		encryptedPwd = encryptionUtils.encrypt("Hello");
		userDao.save(new User("alex.alvisi.80@gmail.com", "Alessandro Alvisi", encryptedPwd));

		encryptedPwd = encryptionUtils.encrypt("Hello");
		userDao.save(new User("mark.anthony.80@gmail.com", "Mark Anthony", encryptedPwd));

		encryptedPwd = encryptionUtils.encrypt("Hello");
		userDao.save(new User("john.doe.80@gmail.com", "John Doe", encryptedPwd));

		toDoDao.save( new ToDo(1, "Learn Microservices", new Date(), "high", "alex.alvisi.80@gmail.com"));

		toDoDao.save( new ToDo(null, "Learn Spring boot", null, "low", "alex.alvisi.80@gmail.com"));

		toDoDao.save( new ToDo(3, "Feed the cat", new Date(), "high", "mark.anthony.80@gmail.com"));
		toDoDao.save( new ToDo(null, "Go to the bank", null, "low", "mark.anthony.80@gmail.com"));

		toDoDao.save( new ToDo(5, "Clean the Car", new Date(), "high", "john.doe.80@gmail.com"));
		toDoDao.save( new ToDo(null, "Go to the Gim", null, "low", "john.doe.80@gmail.com"));


		log.info("we've finished to fill our database");
	}
}
