package com.hergul.jwt;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTTokenGenerator {

	private static String appSecret;

	public static void loadAppSecret() {
		try {
			URL url = JWTTokenGenerator.class.getClassLoader().getResource("avicennakimoerc.txt");
			appSecret = new String(Files.readAllBytes(Paths.get(url.toURI())));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

	}

	public static String generateToken(TokenClaimer tokenClaimer, Date date, String appId) {
		JwtBuilder builder = Jwts.builder()
				// .setSubject("users/" + tokenClaimer.getAppointmentId())
				.setExpiration(date);
		builder.claim("appId", appId);
		builder.claim("claimers", tokenClaimer);
		// builder.claim("scope", "This is scope value");

		String jwt = builder.signWith(SignatureAlgorithm.HS256, getSigningKey()).compact();
		return jwt;
	}

	public static boolean isTokenValid(String jwt) {
		try {
			Jws<Claims> claims = Jwts.parser().setSigningKey(getSigningKey()).parseClaimsJws(jwt);
			String scope = (String) claims.getBody().get("scope");
			// System.out.println(scope);

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
	
	public static Date getDateFromSeconds(Long seconds ) {
		return  new Date(seconds * 1000);
	}

	public static void main(String... strings) {
		TokenClaimer claimer = new TokenClaimer();

		String appId = "avicennakimoerc";
		
		claimer.setSessionId("1");
		claimer.setRoomName("SazakAilesi");
		claimer.setAttenderType("Genel");
		claimer.setModeratorNo("1");
		claimer.setModeratorName("Emin Sazak");
		claimer.setAttenderNo("2");
		claimer.setAttenderName("Aile");
		claimer.setActivateDate(getDateFromSeconds(1587600000L));
		
		
		//activate Date 

	//	Calendar cal = Calendar.getInstance();
	//	cal.add(Calendar.DAY_OF_MONTH, 1); // same with c.add(Calendar.DAY_OF_MONTH, 1);

 
//		cal.set(Calendar.HOUR_OF_DAY, 1);
//		cal.set(Calendar.MINUTE, 18);
//		cal.set(Calendar.SECOND, 0);
		
//		claimer.setActivateDate(cal.getTime());
//
//		cal.set(Calendar.HOUR_OF_DAY, 12);
//		cal.set(Calendar.MINUTE, 25);
//		cal.set(Calendar.SECOND, 0);
//
//		claimer.setMeetingStartDate(cal.getTime());
//
//		cal.set(Calendar.HOUR_OF_DAY, 15);
//		cal.set(Calendar.MINUTE, 20);
//		cal.set(Calendar.SECOND, 0);

		
//		cal.add(Calendar.DAY_OF_MONTH, 10); // same with c.add(Calendar.DAY_OF_MONTH, 1);
//		claimer.setMeetingEndDate(cal.getTime());

		
//		String jwt = generateToken(claimer, cal.getTime(), appId);
		String jwt = generateToken(claimer, getDateFromSeconds(2534284800L), appId);
		System.out.println(jwt);
		// System.out.println(isTokenValid(jwt));

	}

}
