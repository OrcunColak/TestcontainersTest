package com.colak.testcontainerstest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Testcontainers
class TestcontainerstestApplicationTests {

	// will be started before and stopped after each test method
	@Container
	private PostgreSQLContainer postgresqlContainer = new PostgreSQLContainer("postgres:11.1")
			.withDatabaseName("test_database")
			.withUsername("user")
			.withPassword("password");

	@Autowired
	DataSource dataSource;

	@Test
	void contextLoads() throws SQLException {

//		assertTrue(postgresqlContainer.isRunning());

		Connection connection = dataSource.getConnection();
		assertNotNull(connection);
	}

}
