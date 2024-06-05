package vn.gmestoken.core.api.users;

import java.util.List;

import vn.gmestoken.core.base.RequestBase;
import vn.gmestoken.core.security.GpayUser;

public class UserCreateRequest extends RequestBase{
	public GpayUser data;
	public List<MenuId> usermenu;
	public String firstname;
	public String middlename;
	public String lastname;
	public String username;
	public String email;
	public String phone;
	public Long orgrootid;
	public Integer status;
	
	public Long userid;
	public Boolean isrootadmin;
	public Boolean enable;
}
