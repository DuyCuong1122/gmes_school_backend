package vn.gmestoken.core.api.users;

import java.util.List;

import vn.gmestoken.core.security.GpayUser;

public class UserListReqResponse {
	public List<GpayUser> listData;
	public Integer respcode;
	public String message;
}
