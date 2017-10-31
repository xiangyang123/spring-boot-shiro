package com.neo.dao;

import com.neo.entity.SecKill;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

/**
 * Created by zouxiang on 2017/9/14.
 */
@CacheConfig(cacheNames = "secKill")
public interface SecKillDao extends JpaRepository<SecKill,Integer> {

    /**
     *
     * @param id
     * @return
     */
    @CacheEvict(value = "findOne",allEntries = true)
    @Query("update SecKill s set s.remainNum = s.remainNum - 1 where s.id = ?1 and s.remainNum > 0")
    @Modifying
    @Transactional
    int update(int id);


    @Cacheable(value = "findOne")
    @Override
    SecKill findOne(Integer id);

    @CacheEvict(value = "findOne",allEntries = true)
    @Override
    SecKill saveAndFlush(SecKill secKill);

}
