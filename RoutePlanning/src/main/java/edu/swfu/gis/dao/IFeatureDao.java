package edu.swfu.gis.dao;

import java.util.List;
import java.util.Map;
import edu.swfu.core.util.TQueryPara;
import edu.swfu.gis.entity.TFeature;

public interface IFeatureDao <T extends TFeature> {

	  /**
	   * insert a feature
	   * @param target
	   * @return effect rows 
	   * @throws Exception
	   */
	  public int insert(T target) throws Exception;

	  /**
	   * update a feature
	   * @param target
	   * @return effect rows
	   * @throws Exception
	   */
	  public int update(T model) throws Exception;



	  /**
	   * delete a feature by primary key
	   * @param pk the primary key of the feature
	   * @return effect rows 
	   */
	  public int deleteByPk(Object pk) throws Exception;


	  /**
	   * get a feature by primary key
	   * @param pk the primary key of the feature
	   * @return effect rows
	   * @throws Exception
	   */
	  public T selectByPk(Object pk) throws Exception;
	  
	  /**
	   * query the features by the method name and query parameters
	   * @param method name of the method
	   * @param para   query parameters 
	   * @return a list of the query result
	   * @throws Exception
	   */
	  public List<T> selectByMethod(String method, TQueryPara para) throws Exception ;
      public List<T> selectByMethod(String method, Map<String,Object> para) throws Exception;  
	  
	  public List<T> selectByMethod(String method) throws Exception;

	  public  List<T> selectAll() throws Exception;

	  public List<T> select(TQueryPara para) throws Exception;

//
//	  List<Map<String, Object>> selectBySql(String sql, LQueryPara para) throws Exception;

	

}
