package vn.gmestoken.core.api.users.User;

import java.util.List;

import vn.gmestoken.core.base.ResponseBase;
import vn.gmestoken.core.security.GpayUser;


public class UserResponse extends ResponseBase{
	public List<GpayUser> data;
}
