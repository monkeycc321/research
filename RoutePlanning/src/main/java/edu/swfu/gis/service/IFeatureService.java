package edu.swfu.gis.service;

import java.util.List;

import edu.swfu.core.util.TQueryPara;
import edu.swfu.gis.entity.TFeature;
public interface IFeatureService <T extends TFeature>  {
    /**
     * insert a feature
     * @param model 
     * @return effect rows
     * @throws Exception
     */
    int insert(T target) throws Exception;

    /**
     * update a feature
     * @param model 更新的对象
     * @return effect rows 
     * @throws Exception
     */
    int update(T target) throws Exception;

 
    /**
     * delete a feature by the primary key
     * @param pk the primary key 
     * @return effect rows
     */
    int deleteByPk(Object pk) throws Exception;
    
    /**
     * get a feature by the primary key
     * @param pk
     * @return a feature
     * @throws Exception
     */
    T selectByPk(Object pk) throws Exception;
    
    
	/**
	 * query the features by the parameter
	 * @param para
	 * @return  a list of the query result
	 * @throws Exception
	 */
    List<T> select(TQueryPara para) throws Exception;
    
    /**
     * return all features
     * @param pk
     * @return a list of the query result
     * @throws Exception
     */
	public List<T> selectAll() throws Exception;


}
