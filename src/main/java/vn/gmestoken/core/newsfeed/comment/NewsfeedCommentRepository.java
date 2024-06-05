package vn.gmestoken.core.newsfeed.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
@Transactional

/**
 * NewsfeedCommentRepository
 */
public interface NewsfeedCommentRepository extends JpaRepository<NewsfeedComment, Long>{
    @Query(value = "Select a from NewsfeedComment a where a.createdby_idlink=:org_link")
    public List<NewsfeedComment>findByUserId(@Param("org_link") final Long org_link);

    @Query(value = "Select a from NewsfeedComment a where a.post_idlink=:post_link")
    public List<NewsfeedComment>findByPostId(@Param("post_link") final Long post_link);
}
