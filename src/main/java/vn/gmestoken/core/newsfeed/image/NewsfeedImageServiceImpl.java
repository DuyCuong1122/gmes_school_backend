package vn.gmestoken.core.newsfeed.image;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import vn.gmestoken.core.base.AbstractService;

@Service
public class NewsfeedImageServiceImpl extends AbstractService<NewsfeedImage> implements INewsfeedImageService{

    @Autowired NewsfeedImageRepository repository;

    @Override
    protected JpaRepository<NewsfeedImage, Long> getRepository() {
        // TODO Auto-generated method stub
        return repository;
    }

    @Override
    public List<NewsfeedImage> findByPostId(long postid_link) {
        // TODO Auto-generated method stub
        return repository.findByPostId(postid_link);
    }
}
