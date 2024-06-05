package vn.gmestoken.core.security;

import java.util.HashMap;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import vn.gmestoken.core.utils.AtributeFixValues;

public class TQueue {
	static HashMap<String,String> tokMap;
    static {
        tokMap = new HashMap<>();
    }
    // key user-appid, value=token
    public static boolean checkToken(String appid, String userid, String token) {
        String _token = tokMap.remove(appid+"|"+userid);
        return token.equals(_token);
    }
    public static boolean checkTokenByToken(String token) {
        return tokMap.containsValue(token);
    }
    public static synchronized void addToken(String appid, String userid, String token) {
        tokMap.put(appid+"|"+userid, token);
    } 
    public static synchronized String delToken(String appid, String userid) {
        return tokMap.remove(appid+"|"+userid);
    } 
    public static synchronized void delTokenByToken(String token) {
        if(tokMap.containsValue(token)) {
            try {
                Algorithm algorithm = Algorithm.HMAC256(AtributeFixValues.tkkey);
                JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(AtributeFixValues.issuer)
                    .build(); //Reusable verifier instance
                DecodedJWT jwt = verifier.verify(token);
                int appid = jwt.getClaim("appid").asInt();
                int userid = jwt.getClaim("userid").asInt();
                tokMap.remove(appid+"|"+userid);
                System.out.println("Remove token for " + appid+"|"+userid);
            } catch (JWTVerificationException exception){
                //Invalid signature/claims
            }
        }
    }
}
