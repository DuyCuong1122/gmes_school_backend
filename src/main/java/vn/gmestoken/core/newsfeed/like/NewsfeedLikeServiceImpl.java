package vn.gmestoken.core.newsfeed.like;
import java.util.List;

import javax.validation.OverridesAttribute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import vn.gmestoken.core.base.AbstractService;


@Service
public class NewsfeedLikeServiceImpl extends AbstractService<NewsfeedLike> implements INewsfeedLikeService {

    @Autowired NewsfeedLikeRepository repository;
    @Override
    protected JpaRepository<NewsfeedLike, Long> getRepository() {
        // TODO Auto-generated method stub
        return repository;
    }

    @Override
    public List<NewsfeedLike> findByUserId(long orgid_link) {
        // TODO Auto-generated method stub
        return repository.findByUserId(orgid_link);
    }

    @Override
    public List<NewsfeedLike> findByPostId(long postid_link) {
        // TODO Auto-generated method stub
        return repository.findByPostId(postid_link);
    }   
}
