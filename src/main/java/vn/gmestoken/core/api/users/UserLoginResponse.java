package vn.gmestoken.core.api.users;

import java.util.Date;

import vn.gmestoken.core.base.ResponseBase;

public class UserLoginResponse extends ResponseBase{
	public String avatar;
	public String expires;
	public String fname;
	public Boolean isadmin;
	public String token;
	public String user;
	
	public String description;
	public String code;
	public Integer status;
}
