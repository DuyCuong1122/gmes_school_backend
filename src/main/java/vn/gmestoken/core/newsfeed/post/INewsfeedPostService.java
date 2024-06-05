package vn.gmestoken.core.newsfeed.post;

import vn.gmestoken.core.base.Operations;

/**
 * INewsfeedPostService
 */
public interface INewsfeedPostService extends Operations<NewsfeedPost> {
    public NewsfeedPost findByUserId(long orgid_link);
    
}
