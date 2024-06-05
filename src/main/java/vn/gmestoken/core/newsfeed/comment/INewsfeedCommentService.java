package vn.gmestoken.core.newsfeed.comment;

import java.util.List;

import vn.gmestoken.core.base.Operations;

/**
 * INewsfeedCommentService
 */
public interface INewsfeedCommentService extends Operations<NewsfeedComment> {
    public List<NewsfeedComment> findByUserId(long orgid_link);
    public List<NewsfeedComment> findByPostId(long postid_link);
}
