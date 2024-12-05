package qihui.sun.mapper;

import org.apache.ibatis.annotations.Select;

public interface CatMapper {
    @Select("select 'cat'")
    String select();
}
