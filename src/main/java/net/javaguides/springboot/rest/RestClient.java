package net.javaguides.springboot.rest;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import net.javaguides.springboot.entity.User;

public class RestClient {

	private static final String GET_ALL_USERS_API = "http://localhost:8080/api/users";
	private static final String GET_USER_BY_ID_API = "http://localhost:8080/api/users/{id}";
	private static final String CREATE_USER_API = "http://localhost:8080/api/users";
	private static final String DELETE_USER_API = "http://localhost:8080/api/users/{id}";
	
	static RestTemplate restTemplate = new RestTemplate();
	
	public static void main(String[] args) {
		
		//callGetAllUsersAPI();
		//callGetUserByIdAPI();
		callCreateUserAPI();
	}
	
	private static void callGetAllUsersAPI() {
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
		
		ResponseEntity<String> result = restTemplate.exchange(GET_ALL_USERS_API, HttpMethod.GET, entity, String.class);
		
		System.out.println(result);
	}
	
	private static void callGetUserByIdAPI() {
		Map<String, Integer> param = new HashMap<>();
		param.put("id", 2);
		
		User user = restTemplate.getForObject(GET_USER_BY_ID_API, User.class, param);
		
		System.out.println(user.getFirstName());
		System.out.println(user.getLastName());
		System.out.println(user.getEmail());
	}
	
	private static void callCreateUserAPI() {
		User user = new User("Kelson", "Anthony", "k.thony@mail.com");
		ResponseEntity<User> user2 = restTemplate.postForEntity(CREATE_USER_API, user, User.class);
		
		System.out.println(user2);
	}
	
	public static void callUpdateuserAPI() {
		Map<String, Integer> param = new HashMap<>();
		param.put("id", 1);
		
		User userUpdate = new User("Jose", "Silva", "jose@email.com");
		restTemplate.put(GET_USER_BY_ID_API, userUpdate, param);
		
	}
	
}



























