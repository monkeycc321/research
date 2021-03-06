package edu.swfu.routeplanning.mybatis.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.spatial.geometry.JGeometry;
import oracle.sql.STRUCT;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;




@MappedTypes({JGeometry.class})
@MappedJdbcTypes({JdbcType.STRUCT})
public class SdoGeometryTypeHandler  implements TypeHandler<JGeometry> {

    public JGeometry getResult(ResultSet rs, String columnName)
            throws SQLException {

		STRUCT st = (STRUCT) rs.getObject(columnName);
        if (st != null) {
            return JGeometry.load(st);
        }
        return null;
    }

    public JGeometry getResult(ResultSet rs, int columnIndex)
            throws SQLException {

		STRUCT st = (STRUCT) rs.getObject(columnIndex);
        if (st != null) {
            return JGeometry.load(st);
        }
        return null;
    }

    public JGeometry getResult(CallableStatement cs, int columnIndex)
            throws SQLException {

		STRUCT st = (STRUCT) cs.getObject(columnIndex);
        if (st != null) {
            return JGeometry.load(st);
        }
        return null;
    }

	public void setParameter(PreparedStatement ps, int i, JGeometry parameter,
			JdbcType jdbcType) throws SQLException {
		if (parameter == null) {
			ps.setObject(i, null);
		} else {

			STRUCT dbObject = JGeometry.store(parameter, ps.getConnection());
			ps.setObject(i, dbObject);
		}
	}

}
