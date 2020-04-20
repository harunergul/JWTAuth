package com.hergul.jwt;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;

//import com.auth0.jwt.JWT;
//import com.auth0.jwt.JWTVerifier;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.auth0.jwt.exceptions.JWTCreationException;
//import com.auth0.jwt.exceptions.JWTVerificationException;
//import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;



public class JWTTokenFactory {
//
//	private static String appSecret;
//
//	public static void loadAppSecret() {
//		try {
//
//			appSecret = new String(
//					Files.readAllBytes(Paths.get(JWTTokenFactory.class.getResource("secret.txt").toURI())));
//			// appSecret = "ABC";
//			System.out.println("App Secret Key : " + appSecret);
//		} catch (IOException | URISyntaxException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public static void main(String[] args) {
//		String token = generateToken();
//		System.out.println(token);
//
//
//		DecodedJWT verifiedToken = verifyToken(token);
//		if (verifiedToken != null) {
//			System.out.println("Valid Token");
//		}
//	}
//
//	public static String generateToken() {
//		ObjectMapper mapper = new ObjectMapper();
//		
//		
//		String token = null;
//		try {
//			if (JWTTokenFactory.getAppSecret() == null) {
//				JWTTokenFactory.loadAppSecret();
//			}
//			Algorithm algorithm = Algorithm.HMAC256(JWTTokenFactory.getAppSecret());
//			Calendar cal = Calendar.getInstance();
//			cal.setTime(new Date());
//			cal.add(Calendar.DATE, 1);
//			token = JWT.create().withIssuer("ERCGroupEngineering").withExpiresAt(cal.getTime()).sign(algorithm);
//		} catch (JWTCreationException exception) {
//			exception.printStackTrace();
//		}
//		return token;
//	}
//
//	public static DecodedJWT verifyToken(String token) {
//		try {
//			if (appSecret == null) {
//				loadAppSecret();
//			}
//			Algorithm algorithm = Algorithm.HMAC256(appSecret);
//			JWTVerifier verifier = JWT.require(algorithm).withIssuer("ERCGroupEngineering").build();
//			// Reusable verifier instance
//			DecodedJWT jwt = verifier.verify(token);
//			return jwt;
//		} catch (JWTVerificationException exception) {
//			// Invalid signature/claims
//			exception.printStackTrace();
//		}
//		return null;
//	}
//
//	public static String getAppSecret() {
//		return appSecret;
//	}
//
//	public static void setAppSecret(String appSecret) {
//		JWTTokenFactory.appSecret = appSecret;
//	}

}
