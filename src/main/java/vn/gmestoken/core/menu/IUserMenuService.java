package vn.gmestoken.core.menu;

import java.util.List;

import vn.gmestoken.core.base.Operations;

public interface IUserMenuService extends Operations<UserMenu>{

	public List<UserMenu>findByUserid(long userid);
}
