package vn.gmestoken.core.api.users;

import java.util.List;

import vn.gmestoken.core.base.ResponseBase;
import vn.gmestoken.core.security.GpayUserOrg;

public class User_OrgView_Response extends ResponseBase{
	public List<GpayUserOrg> data;
}
