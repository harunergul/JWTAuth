package com.hergul.jwt;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Calendar;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTTokenGenerator {

	private static String appSecret;

	public static void loadAppSecret() {
		try {
			URL url = JWTTokenGenerator.class.getClassLoader().getResource("secret.txt");
			appSecret = new String(Files.readAllBytes(Paths.get(url.toURI())));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

	}

	public static String generateToken(TokenClaimer tokenClaimer) {
		JwtBuilder builder = Jwts.builder().setSubject("users/" + tokenClaimer.getAppointmentId())
				.setExpiration(tokenClaimer.getExpireDate());
		builder.claim("claimers", tokenClaimer);
		builder.claim("scope", "This is scope value");

		String jwt = builder.signWith(SignatureAlgorithm.HS256, getSigningKey()).compact();
		return jwt;
	}

	public static boolean isTokenValid(String jwt) {
		try {
			Jws<Claims> claims = Jwts.parser().setSigningKey(getSigningKey()).parseClaimsJws(jwt);
			String scope = (String) claims.getBody().get("scope");
			System.out.println(scope);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public static byte[] getSigningKey() {
		try {
			if (appSecret == null) {
				loadAppSecret();
			}
			return appSecret.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String... strings) {
		TokenClaimer claimer = new TokenClaimer();
		claimer.setAppointmentId(445454454L);
		claimer.setPatientName("Hasan Akarca");
		claimer.setPatientNo("5454546");
		claimer.setRoomName("Roomname");

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 23);

		claimer.setExpireDate(cal.getTime());
		String jwt = generateToken(claimer);
		System.out.println(jwt);
		System.out.println(isTokenValid(jwt));

	}
	
	
}
