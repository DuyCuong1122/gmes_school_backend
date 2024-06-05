package vn.gmestoken.core.api.users.User;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import vn.gmestoken.core.api.users.UserLoginRequest;
import vn.gmestoken.core.api.users.UserLoginResponse;
import vn.gmestoken.core.menu.IUserMenuService;
import vn.gmestoken.core.menu.MenuServiceImpl;
import vn.gmestoken.core.security.GpayUser;
import vn.gmestoken.core.security.IGpayUserOrgService;
import vn.gmestoken.core.security.IGpayUserService;
import vn.gmestoken.core.security.TQueue;
import vn.gmestoken.core.utils.AtributeFixValues;
import vn.gmestoken.core.utils.BCrypt;
import vn.gmestoken.core.utils.ResponseMessage;


@RestController
@RequestMapping("/api/v1/users")
public class UserAPI {
	private static int workload = 10;

	private PasswordEncoder passwordEncoder;
	@Autowired IGpayUserService  userDetailsService ;
	@Autowired IUserMenuService  userMenuService ;
	@Autowired MenuServiceImpl menuService;
	@Autowired IGpayUserOrgService userOrgService;
	
	
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public ResponseEntity<UserLoginResponse> login( @RequestBody UserLoginRequest entity,HttpServletRequest request ) {
		UserLoginResponse response = new UserLoginResponse();
		try {
			String username = entity.username;
			String password = entity.password;
			
			Integer errCode = 200;
			Integer type = checkUserType(username);
			
			GpayUser user = null;
			List<GpayUser> listGpayUser = new ArrayList<GpayUser>();
			switch (type) {
				case 1:
					// email
					listGpayUser = userDetailsService.getUserListByEmail(username);
					break;
				default:
					// username
					listGpayUser = userDetailsService.getUserListByUsername(username);
					break;
			}
			
			if(listGpayUser.size() > 0) {
				for(GpayUser gpayUser : listGpayUser) {
					String stored_pwd = gpayUser.getPassword().substring(8);
					if(gpayUser.getEnabled()) {
	                    if(checkPassword(password, stored_pwd)) {
	                        // login sucess
	                    	errCode = 200;
	                    } else {
	                        // login error
	                    	errCode = 401;
	                    }
	                } else {
	                	// login error
	                	errCode = 401;
	                }
					
					if(errCode == 200) {
//			            json = genLoginSuccess(gpayUser.getId(), gpayUser.getFullname(), oa2user.getCounter(), oa2user.getOrgid(),
//			                    OA2Config.appid, OA2Config.url_image+"user_man.png", oa2user.isIsrootadmin());
			            
			            
			            // UserLoginResponse userLoginResponse, int userid, String username, int orgid, int appid, String avatar, boolean isadmin
			            response = genLoginSuccess(
			            		response, gpayUser.getId(), gpayUser.getFullname(), gpayUser.getOrgid_link(), AtributeFixValues.appid, AtributeFixValues.url_image+"user_man.png", 
			            		false
//			            		gpayUser.getIsrootadmin()
			            		);
			        } else {
//			            json = genLoginError(errCode);
			            response = genLoginError(response, errCode);
			        }
				}
			}
			
			response.setRespcode(ResponseMessage.KEY_RC_SUCCESS);
			response.setMessage(ResponseMessage.getMessage(ResponseMessage.KEY_RC_SUCCESS));
			return new ResponseEntity<UserLoginResponse>(response,HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			response.setRespcode(ResponseMessage.KEY_RC_EXCEPTION);
			response.setMessage(ResponseMessage.getMessage(ResponseMessage.KEY_RC_EXCEPTION));
		    return new ResponseEntity<UserLoginResponse>(response,HttpStatus.OK);
		}
	}
	
	public static int checkUserType(String username) {
        String regex4phone = "^[0-9]{10}$";
        String regex4email = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        if(username.matches(regex4phone)) {
            return 2;/*phone*/
        }
        if(username.matches(regex4email)) {
            return 1;/*email*/
        }
        return 0;
    }
	
	public static boolean checkPassword(String password_plaintext, String stored_hash) {
		boolean password_verified = false;

		if(null == stored_hash || !stored_hash.startsWith("$2a$"))
			throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");

		password_verified = BCrypt.checkpw(password_plaintext, stored_hash);

		return(password_verified);
    }
	
	private UserLoginResponse genLoginSuccess(UserLoginResponse userLoginResponse, Long userid, String username, Long orgid, int appid, String avatar, boolean isadmin) {
//        String json;
        Random r = new Random();
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode rootNode = objectMapper.createObjectNode();
        try {
            Date now = new Date();
            long validity = now.getTime() + AtributeFixValues.validityInMilliseconds;
//            System.out.println("expire validity:" + validity);
            Algorithm algorithm = Algorithm.HMAC256(AtributeFixValues.tkkey);
            String token = JWT.create()
                    .withIssuer("auth0")
                    .withClaim("orgid", orgid)
                    .withClaim("appid", appid)
                    .withClaim("userid", userid)
                    .withClaim("isadmin",isadmin)
                    .withClaim("exp", validity/*r.nextInt(9999)*/)
                    //.withClaim("ext", "Pham Viet Hung")
                    .sign(algorithm);

            String pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String strDate = simpleDateFormat.format(new Date(validity));
//            rootNode.put("user", String.valueOf(userid));
//            //rootNode.put("fname", URLEncoder.encode("Phạm Việt Hùng", "UTF-8"));
//            rootNode.put("fname", username);
//            rootNode.put("avatar", avatar);
//            rootNode.put("token", token);
//            rootNode.put("expires", strDate);
//            rootNode.put("isadmin", isadmin);
//            json = objectMapper.writeValueAsString(rootNode);
            
            userLoginResponse.user = String.valueOf(userid);
            userLoginResponse.fname = username;
            userLoginResponse.avatar = avatar;
            userLoginResponse.token = token;
            userLoginResponse.expires = strDate;
            userLoginResponse.isadmin = isadmin;
            
            TQueue.addToken(String.valueOf(appid), String.valueOf(userid), token);
            
        } catch(Exception ex) {
        	ex.printStackTrace();
//            json = "";
        }
        return userLoginResponse;
	}
	
	private UserLoginResponse genLoginError(UserLoginResponse userLoginResponse,int errorcode) {
//        String json;
        ObjectMapper objectMapper = new ObjectMapper();
        
        try {
//            ObjectNode rootNode = objectMapper.createObjectNode();
//            rootNode.put("description", "Invalid username and/or password");
//            rootNode.put("code", "Unauthorized");
//            rootNode.put("status", errorcode);
//            json = objectMapper.writeValueAsString(rootNode);
            
            userLoginResponse.description = "Invalid username and/or password";
            userLoginResponse.code = "Unauthorized";
            userLoginResponse.status = errorcode;
//        } catch(JsonProcessingException ex) {
        } catch(Exception ex) {
        	ex.printStackTrace();
//            json = "";
        }
        return userLoginResponse;
	}
	
//	private String genLoginSuccess(UserLoginResponse userLoginResponse, int userid, String username, int orgid, int appid, String avatar, boolean isadmin) {
////    String json;
//    Random r = new Random();
//    ObjectMapper objectMapper = new ObjectMapper();
//    ObjectNode rootNode = objectMapper.createObjectNode();
//    try {
//        Date now = new Date();
//        Date expiryDate = new Date(now.getTime() + AtributeFixValues.validityInMilliseconds);
//        long validity = now.getTime() + AtributeFixValues.validityInMilliseconds;
////        System.out.println("expire validity:" + validity);
//        
//        String token = Jwts.builder()
//        .setSubject(Long.toString(userid))
//        .setIssuedAt(now)
//        .setExpiration(expiryDate)
//        .signWith(SignatureAlgorithm.HS256, AtributeFixValues.tkkey)
//        .compact();
//        
////        Algorithm algorithm = Algorithm.HMAC256(AtributeFixValues.tkkey);
////        String token = JWT.create()
////                .withIssuer("auth0")
////                .withClaim("orgid", orgid)
////                .withClaim("appid", appid)
////                .withClaim("userid", userid)
////                .withClaim("isadmin",isadmin)
////                .withClaim("exp", validity/*r.nextInt(9999)*/)
////                //.withClaim("ext", "Pham Viet Hung")
////                .sign(algorithm);
//
//        String pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//        String strDate = simpleDateFormat.format(new Date(validity));
//        rootNode.put("user", String.valueOf(userid));
//        //rootNode.put("fname", URLEncoder.encode("Phạm Việt Hùng", "UTF-8"));
//        rootNode.put("fname", username);
//        rootNode.put("avatar", avatar);
//        rootNode.put("token", token);
//        rootNode.put("expires", strDate);
//        rootNode.put("isadmin", isadmin);
//        json = objectMapper.writeValueAsString(rootNode);
//        TQueue.addToken(String.valueOf(appid), String.valueOf(userid), token);
//        
//    } catch(Exception ex) {
//        json = "";
//    }
//    return json;
//}
}
