package com.project.wwg.plan.dao;

import com.project.wwg.plan.dto.PageInfo;
import com.project.wwg.plan.dto.Spot;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MybatisSpotsDao implements SpotsDao {

    private SqlSession sqlSession;

    @Autowired
    public MybatisSpotsDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<Spot> getSpotsList(int startRow, int endRow) {
        return null;
    }

    @Override
    public Spot searchSpotOne(String title){
        return sqlSession.selectOne("spot.searchSpotOne", title);
    }

    /**
     * 검색어로 Spot 검색하여 리스트 반환
     *
     * @return
     */
    @Override
    public List<Spot> searchSpots(PageInfo pageInfo) {
        return sqlSession.selectList("spot.searchSpots", pageInfo);
    }

    @Override
    public List<Spot> searchSpotsByTitles(List<String> titleList) {
        return sqlSession.selectList("spot.searchSpotsByTitles", titleList);
    }

    @Override
    public int getSearchSpotsCount(String keyword) {
        return sqlSession.selectOne("spot.getSearchSpotsCount", keyword);
    }

    /**
     * Spot 1개 insert
     *
     * @param spot
     * @return
     */
    @Override
    public int insertSpot(Spot spot) {
        return sqlSession.insert("spot.insertSpot", spot);
    }

    /**
     * Spot 여러 개 insert
     *
     * @param spots
     * @return
     */
    @Override
    public int insertSpots(List<Spot> spots) {
        return sqlSession.insert("spot.insertSpots", spots);
    }

    /**
     * id로 Spot 삭제
     *
     * @param id
     */
    @Override
    public int deleteSpot(String id) {
        return sqlSession.delete("spot.deleteSpot", id);
    }

    /**
     * 모든 Spot 삭제
     *
     * @return
     */
    @Override
    public int deleteAllSpots() {
        return sqlSession.delete("spot.deleteAllSpots");
    }
}
