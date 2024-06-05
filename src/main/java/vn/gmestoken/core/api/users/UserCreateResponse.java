package vn.gmestoken.core.api.users;

import java.util.List;

import vn.gmestoken.core.base.ResponseBase;
import vn.gmestoken.core.security.GpayUser;

public class UserCreateResponse extends ResponseBase{
	public GpayUser data;
	public List<GpayUser> listData;
	public Long userId;
	public Integer status;
}
