package com.marketplace;

import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnvironmentController {

	protected Logger logger = Logger.getLogger(EnvironmentController.class.getName());

	@Autowired
	Environment environment;

	@Value("${user_profile}")
	private String profile;

	@Value("${project_id}")
	private String projectId;

	@Value("${spring_cloud_gcp_sql_database_name}")
	private String databaseName;

	@Value("${spring_cloud_gcp_sql_instance_connection_name}")
	private String connectionName;

	@Value("${spring_datasource_username}")
	private String username;

	@Value("${spring_datasource_password}")
	private String password;

	@RequestMapping(value = "/envVars", method = RequestMethod.GET)
	public Map<String, String> envVars() {
		logger.info("microservice envVars() invoked");
		return System.getenv();
	}

	@RequestMapping(value = "/activeProfiles", method = RequestMethod.GET)
	public String[] activeProfiles() {
		logger.info("microservice activeProfiles() invoked");
		return environment.getActiveProfiles();
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String profile() {
		logger.info(profile);
		return profile;
	}

	@RequestMapping(value = "/projectId", method = RequestMethod.GET)
	public String projectId() {
		logger.info(projectId);
		return projectId;
	}

	@RequestMapping(value = "/databaseName", method = RequestMethod.GET)
	public String databaseName() {
		logger.info(databaseName);
		return databaseName;
	}

	@RequestMapping(value = "/connectionName", method = RequestMethod.GET)
	public String connectionName() {
		logger.info(connectionName);
		return connectionName;
	}

	@RequestMapping(value = "/username", method = RequestMethod.GET)
	public String username() {
		logger.info(username);
		return username;
	}

	@RequestMapping(value = "/password", method = RequestMethod.GET)
	public String password() {
		logger.info(password);
		return password;
	}

}
