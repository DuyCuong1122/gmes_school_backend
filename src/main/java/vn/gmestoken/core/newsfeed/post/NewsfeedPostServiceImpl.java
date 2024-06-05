package vn.gmestoken.core.newsfeed.post;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import vn.gmestoken.core.base.AbstractService;

@Service
public class NewsfeedPostServiceImpl extends AbstractService<NewsfeedPost> implements INewsfeedPostService{
    @Autowired NewsfeedPostRepository repository;
	@Override
	protected JpaRepository<NewsfeedPost, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}

    @Override
	public NewsfeedPost findByUserId(long orgid_link) {
		// TODO Auto-generated method stub
		return repository.findByUserId(orgid_link);
	}
}
