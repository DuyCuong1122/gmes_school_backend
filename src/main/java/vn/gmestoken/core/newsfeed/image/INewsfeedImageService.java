package vn.gmestoken.core.newsfeed.image;
import java.util.List;
import vn.gmestoken.core.base.Operations;

/**
 * INewsfeedImageService
 */
public interface INewsfeedImageService extends Operations<NewsfeedImage> {
    public List<NewsfeedImage> findByPostId(long postid_link);
}
