package org.studyMybatisByMaven.converter;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BooleanAndInteger extends BaseTypeHandler<Boolean> {//在<>里面放java类中类型

    public void setNonNullParameter(PreparedStatement ps, int i, Boolean parameter, JdbcType jdbcType) throws SQLException {
        if (parameter == false) {
            ps.setInt(i, 0);
        } else {
            ps.setInt(i, 1);
        }
    }

    public Boolean getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return rs.getInt(columnName) == 0 ? false : true;
    }

    public Boolean getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return rs.getInt(columnIndex) == 0 ? false : true;
    }

    public Boolean getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return cs.getInt(columnIndex) == 0 ? false : true;
    }
}
