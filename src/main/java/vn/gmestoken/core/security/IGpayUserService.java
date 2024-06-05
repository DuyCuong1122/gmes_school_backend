package vn.gmestoken.core.security;

import java.util.List;

import vn.gmestoken.core.base.Operations;

public interface IGpayUserService extends Operations<GpayUser>{

	public GpayUser findByUsername(String username);

	public GpayUser findByEmail(String email);
	
	public GpayUser findById(long userid);
//    public List<GpayUser> getUserList(long orgid_link,String textsearch,int status);
//    public List<GpayUser> getUserList_page(String firstname, String middlename, String lastname,
//    		String username, Long groupuserid_link);
//	//lấy danh sách user theo mã nhân viên, không chứa id truyền vào
//	public  List<GpayUser> getUserBycode_Personel(String personnel_code, Long id);
//	List<GpayUser> getUserList_search(String firstname, String middlename, String lastname, String username, Long groupuserid_link);
//
//	List<GpayUser> getByPersonnelId(Long personnelid_link);
	List<GpayUser> getUserListByEmail(String email);
	List<GpayUser> getUserListByUsername(String username);
}
