package com.brillio.RegisterAndLogin.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.brillio.RegisterAndLogin.model.User;
import com.brillio.RegisterAndLogin.repository.UserRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class UserServiceImpl implements UserService {

	static final long EXPIRATIONTIME = 300000;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	public User save(User user) {
		user.setPassword(bcryptEncoder.encode(user.getPassword()));
		userRepository.save(user);
		return user;
	}

	public boolean delete(User user) {

		userRepository.delete(user);
		if (userRepository.findById(user.getEmail()).isPresent()) {
			return false;
		} else
			return true;
	}

	public String getToken(String email, String password) throws Exception {
		if (email == null || password == null) {
			throw new ServletException("Please fill in email and password");
		}
		boolean flag = this.validate(email, password);
		if (!flag) {
			throw new ServletException("Invalid credentials.");
		}

		String jwtToken = Jwts.builder().setSubject(email).setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
				.signWith(SignatureAlgorithm.HS256, "secretkey").compact();

		return jwtToken;
	}

	public boolean validate(String email, String password) {
		User userFromDb = userRepository.validate(email, password);
		System.out.println("Validated user" + userFromDb);
		if (userFromDb != null) {
			if (bcryptEncoder.matches(password, userFromDb.getPassword())) {
				System.out.println("Matchhhhhhhhhh " + bcryptEncoder.matches(password, userFromDb.getPassword()));
				return true;
			}
		}
		return false;
	}

	public User getUser(String email) {
//		System.out.println("get User - " + userRepository.findById(email));
//		List<User> allUser = (List<User>) userRepository.findAll();
//		List<User> getUserDetail = allUser.stream()
//				.filter(f -> f.getEmail().equalsIgnoreCase(email)).collect(Collectors.toList());
//		return getUserDetail;

		Optional<User> user = userRepository.findById(email);
		return user.isPresent() ? user.get() : null;

	}

}
