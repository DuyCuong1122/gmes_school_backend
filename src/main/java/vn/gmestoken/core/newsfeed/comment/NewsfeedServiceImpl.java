package vn.gmestoken.core.newsfeed.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import vn.gmestoken.core.base.AbstractService;

@Service
public class NewsfeedServiceImpl extends AbstractService<NewsfeedComment> implements INewsfeedCommentService {
    @Autowired NewsfeedCommentRepository repository;

    @Override
    protected JpaRepository<NewsfeedComment, Long> getRepository() {
        return repository;
    }

    @Override
    public List<NewsfeedComment> findByUserId(long orgid_link) {
        // TODO Auto-generated method stub
        return repository.findByUserId(orgid_link);
    }

    @Override
    public List<NewsfeedComment> findByPostId(long postid_link) {
        // TODO Auto-generated method stub
        return repository.findByPostId(postid_link);
    }   
}
