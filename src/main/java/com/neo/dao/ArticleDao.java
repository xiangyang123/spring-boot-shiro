package com.neo.dao;

import com.neo.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
//import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by zouxiang on 2017/10/26.
 * @author zouxiang
 */
public interface ArticleDao {

    Page<Article> findByTitle(String queryString, Pageable pageable);
}
