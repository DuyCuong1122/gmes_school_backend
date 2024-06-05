package vn.gmestoken.core.newsfeed.image;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * NewsfeedImageRepository
 */

@Repository
@Transactional
public interface NewsfeedImageRepository extends JpaRepository<NewsfeedImage,Long> {
    @Query(value = "Select a from NewsfeedImage a where a.post_idlink=:post_link")
    public List<NewsfeedImage>findByPostId(@Param("post_link") final Long post_link);
}