package com.fpi.test.mapper;

import com.fpi.test.model.Role;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

public interface UserInfoMapper {

//    @Select("select * from user limit #{offset},#{limit}")
//    @SelectProvider(type= SqlProvider.class,method = "test")
    @Select("<script> select * from user <if test='offset!=null and limit!=null'>limit #{offset},#{limit}</if></script>")
    public List<Map<String, Object>> listUserInfo(@Param("offset")Integer offset,@Param("limit")Integer limit);

    @Select("select * from role")
    public List<Role> listRole();

    class SqlProvider{
        public String test(Integer offset,Integer limit){
            StringBuilder sql = new StringBuilder("SELECT * FROM user ");
            if (offset!=null&&limit!=null){
                sql.append("LIMIT #{offset},#{limit}");
            }
            return sql.toString();
        }
    }
}

