package com.fibbery.framework.vo.handler;

import com.fibbery.framework.vo.enums.StatusEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * create by jiangnenghua
 */
public class StatusEnumHandler extends BaseTypeHandler<StatusEnum> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, StatusEnum parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.getCode());
    }

    @Override
    public StatusEnum getNullableResult(ResultSet rs, String columnName) throws SQLException {
        int code = rs.getInt(columnName);
        if( rs.wasNull()){
            return null;
        }else {
            return locateStatusEnum(code);
        }
    }

    private StatusEnum locateStatusEnum(int code) {
        StatusEnum[] enums = StatusEnum.values();
        for(StatusEnum status: enums){
            if(status.getCode() == code){
                return status;
            }
        }

        throw  new IllegalArgumentException("未知的code:"+code+",请检查");
    }

    @Override
    public StatusEnum getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return null;
    }

    @Override
    public StatusEnum getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return null;
    }
}
