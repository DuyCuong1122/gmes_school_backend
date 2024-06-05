package vn.gmestoken.core.newsfeed.post;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional

public interface NewsfeedPostRepository extends JpaRepository<NewsfeedPost, Long> {
    
    @Query(value = "Select a from NewsfeedPost a where a.createdby_idlink=:org_link")
	public NewsfeedPost findByUserId(@Param ("org_link")final Long org_link);
}
