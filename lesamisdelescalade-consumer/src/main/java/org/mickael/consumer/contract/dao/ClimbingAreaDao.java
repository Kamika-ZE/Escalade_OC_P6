package org.mickael.consumer.contract.dao;

import org.mickael.model.bean.ClimbingArea;

import java.util.List;

public interface ClimbingAreaDao {
    void createClimbingArea(ClimbingArea climbingArea);
    ClimbingArea findClimbingArea(Integer id);
    List<ClimbingArea> findClimbingAreaByMemberId(Integer id);
    void updateClimbingArea(ClimbingArea climbingArea);
    void deleteClimbingArea(Integer id);
    List<ClimbingArea> findAllClimbingArea ();
    void deleteTag(Integer id);
    void addTag(Integer id);
}
