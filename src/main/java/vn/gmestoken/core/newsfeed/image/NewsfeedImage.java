package vn.gmestoken.core.newsfeed.image;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "newsfeed_image")
@Entity
public class NewsfeedImage implements  Serializable{
    private static final long serialVersionUID = 1L;

    @Id   
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "newsfeed_image_generator")
	@SequenceGenerator(name = "newsfeed_image_generator", sequenceName = "newsfeed_image_id_seq", allocationSize = 1)
    protected Long id;

    @Column(name = "image_url")
    private String image_url;

    @Column(name = "postid_link")
    private Long postid_link;

    @Column(name = "created_date")
    private Long created_date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Long getPostid_link() {
        return postid_link;
    }

    public void setPostid_link(Long postid_link) {
        this.postid_link = postid_link;
    }

    public Long getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Long created_date) {
        this.created_date = created_date;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    
}
