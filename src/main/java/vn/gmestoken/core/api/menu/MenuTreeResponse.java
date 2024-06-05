package vn.gmestoken.core.api.menu;

import java.util.List;

import vn.gmestoken.core.base.ResponseBase;
import vn.gmestoken.core.menu.MenuTree;
import vn.gmestoken.core.security.GpayUser;

public class MenuTreeResponse extends ResponseBase{
	public List<MenuTree> children;
	public GpayUser data;
	public String listorg;
//	public MenuTree data;
}
