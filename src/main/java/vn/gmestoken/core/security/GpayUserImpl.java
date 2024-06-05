package vn.gmestoken.core.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.github.wenhao.jpa.Sorts;
import com.github.wenhao.jpa.Specifications;

import vn.gmestoken.core.base.AbstractService;

@Service
public class GpayUserImpl extends AbstractService<GpayUser> implements IGpayUserService{

	@Autowired
	GpayUserRepository repository; 
	@Override
	protected JpaRepository<GpayUser, Long> getRepository() {
		return repository;
	}
	@Override
	public GpayUser findByUsername(String username) {
		return repository.findByUsername(username);
	}
	@Override
	public GpayUser findByEmail(String email) {
		return repository.findByEmail(email);
	}
	@Override
	public GpayUser findById(long id) {
		return repository.findById(id);
	}
//	@Override
//	public List<GpayUser> getUserList(long orgid_link, String textsearch, int status) {
//		Specification<GpayUser> specification = Specifications.<GpayUser>and()
//	            .eq( status!=-1,"status", status)
//	            .eq(orgid_link > 1 ,"orgid_link", orgid_link)
//	            .predicate(Specifications.or()
//	            		.like("useremail","%"+textsearch+"%")
//	            		.like("firstname","%"+textsearch+"%")
//	            		.like("lastname","%"+textsearch+"%")
//	            		.build())
//	            .build();
//		Sort sort = Sorts.builder()
//		        .desc("id")
//		        .build();
//	    return repository.findAll(specification,sort);
//	}
//	
//	@Override
//	public List<GpayUser> getUserBycode_Personel(String personnel_code, Long id) {
//		return repository.getUserBycode_Personel(personnel_code, id);
//	}
//	@Override
//	public List<GpayUser> getUserList_search(String firstname, String middlename, String lastname, String username,
//			Long groupuserid_link) {
//		return repository.getUserList_search(firstname, middlename, lastname, username, groupuserid_link);
//	}
	@Override
	public List<GpayUser> getUserListByEmail(String email) {
		return repository.getUserListByEmail(email);
	}
	@Override
	public List<GpayUser> getUserListByUsername(String username) {
		return repository.getUserListByUsername(username);
	}
//	@Override
//	public List<GpayUser> getByPersonnelId(Long personnelid_link) {
//		return repository.getByPersonnelId(personnelid_link);
//	}
//	@Override
//	public List<GpayUser> getUserList_page(String firstname, String middlename, String lastname, String username,
//			Long groupuserid_link) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
