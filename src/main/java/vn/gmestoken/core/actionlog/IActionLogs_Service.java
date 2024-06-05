package vn.gmestoken.core.actionlog;

import java.util.List;

import vn.gmestoken.core.base.Operations;

public interface IActionLogs_Service extends Operations<ActionLogs>{

	List<ActionLogs> findUserByUser(String userid_link);

}
