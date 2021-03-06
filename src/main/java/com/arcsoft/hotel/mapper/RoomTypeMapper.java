package com.arcsoft.hotel.mapper;

import com.arcsoft.hotel.pojo.RoomType;
import com.arcsoft.hotel.pojo.RoomTypeExample;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface RoomTypeMapper {
    @SelectProvider(type = RoomTypeSqlProvider.class, method = "countByExample")
    int countByExample(RoomTypeExample example);

    @DeleteProvider(type = RoomTypeSqlProvider.class, method = "deleteByExample")
    int deleteByExample(RoomTypeExample example);

    @Delete({
            "delete from room_type",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
            "insert into room_type (id, price, ",
            "name)",
            "values (#{id,jdbcType=INTEGER}, #{price,jdbcType=DOUBLE}, ",
            "#{name,jdbcType=VARCHAR})"
    })
    int insert(RoomType record);

    @InsertProvider(type = RoomTypeSqlProvider.class, method = "insertSelective")
    int insertSelective(RoomType record);

    @SelectProvider(type = RoomTypeSqlProvider.class, method = "selectByExample")
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "price", property = "price", jdbcType = JdbcType.DOUBLE),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR)
    })
    List<RoomType> selectByExample(RoomTypeExample example);

    @Select({
            "select",
            "id, price, name",
            "from room_type",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "price", property = "price", jdbcType = JdbcType.DOUBLE),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR)
    })
    RoomType selectByPrimaryKey(Integer id);

    @UpdateProvider(type = RoomTypeSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") RoomType record, @Param("example") RoomTypeExample example);

    @UpdateProvider(type = RoomTypeSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") RoomType record, @Param("example") RoomTypeExample example);

    @UpdateProvider(type = RoomTypeSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RoomType record);

    @Update({
            "update room_type",
            "set price = #{price,jdbcType=DOUBLE},",
            "name = #{name,jdbcType=VARCHAR}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(RoomType record);
}