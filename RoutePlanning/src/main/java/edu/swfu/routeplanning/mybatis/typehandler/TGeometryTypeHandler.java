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

import edu.swfu.gis.entity.TGeometry;
import edu.swfu.gis.util.FeatureHelper;



@MappedTypes({TGeometry.class})
@MappedJdbcTypes({JdbcType.STRUCT})
public class TGeometryTypeHandler implements TypeHandler<TGeometry> {
	public TGeometry getResult(ResultSet rs, String fieldName) throws SQLException {
		TGeometry result=null;
		STRUCT st = (STRUCT) rs.getObject(fieldName);
		 
	        if (st != null) {
	        	JGeometry jgeo=JGeometry.load(st);
	            result=FeatureHelper.JGeometry2TGeometry(jgeo);
	        }
	        return result;
	}

	public TGeometry getResult(ResultSet rs, int fieldIndex) throws SQLException {
		TGeometry result=null;
		STRUCT st = (STRUCT) rs.getObject(fieldIndex);
        if (st != null) {
        	JGeometry jgeo=JGeometry.load(st);
            result=FeatureHelper.JGeometry2TGeometry(jgeo);
        }
        return result;
	}

	public TGeometry getResult(CallableStatement cs, int columnIndex)throws SQLException {
		TGeometry result=null;
		STRUCT st = (STRUCT) cs.getObject(columnIndex);
        if (st != null) {
        	JGeometry jgeo=JGeometry.load(st);
            result=FeatureHelper.JGeometry2TGeometry(jgeo);
        }
        return result;
	}

	public void setParameter(PreparedStatement ps, int i, TGeometry parameter,
			JdbcType jdbcType) throws SQLException {
		if (parameter == null) {
			ps.setObject(i, null);
		} else {
			JGeometry jgeo = FeatureHelper.TGeometry2JGeometry(parameter);
			STRUCT dbObject = JGeometry.store(jgeo, ps.getConnection());
			ps.setObject(i, dbObject);
		}
	}

}
