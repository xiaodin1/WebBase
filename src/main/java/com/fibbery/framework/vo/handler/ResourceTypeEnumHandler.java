package com.fibbery.framework.vo.handler;

import com.fibbery.framework.vo.enums.ResourceTypeEnum;
import com.fibbery.framework.vo.enums.StatusEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * Created by jiangnenghua on 2016/8/1.
 */
public class ResourceTypeEnumHandler extends BaseTypeHandler<ResourceTypeEnum> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, ResourceTypeEnum parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.getCode());
    }

    @Override
    public ResourceTypeEnum getNullableResult(ResultSet rs, String columnName) throws SQLException {
        int code = rs.getInt(columnName);
        if( rs.wasNull()){
            return null;
        }else {
            return locateResourceTypeEnum(code);
        }
    }

    private ResourceTypeEnum locateResourceTypeEnum(int code) {
        ResourceTypeEnum[] enums = ResourceTypeEnum.values();
        for(ResourceTypeEnum status: enums){
            if(status.getCode() == code){
                return status;
            }
        }

        throw  new IllegalArgumentException("未知的code:"+code+",请检查");
    }

    @Override
    public ResourceTypeEnum getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return null;
    }

    @Override
    public ResourceTypeEnum getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return null;
    }
}
