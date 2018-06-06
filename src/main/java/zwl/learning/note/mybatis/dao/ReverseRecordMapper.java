package zwl.learning.note.mybatis.dao;

import zwl.learning.note.mybatis.ReverseRecord;

public interface ReverseRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ReverseRecord record);

    int insertSelective(ReverseRecord record);

    ReverseRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ReverseRecord record);

    int updateByPrimaryKey(ReverseRecord record);
}