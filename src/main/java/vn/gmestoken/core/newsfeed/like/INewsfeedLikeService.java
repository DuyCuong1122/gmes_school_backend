package vn.gmestoken.core.newsfeed.like;
import java.util.List;
import vn.gmestoken.core.base.Operations;

/**
 * INewsfeedLikeService
 */
public interface INewsfeedLikeService  extends Operations<NewsfeedLike>{
    public List<NewsfeedLike> findByUserId(long orgid_link);
    public List<NewsfeedLike> findByPostId(long postid_link);
    
}
