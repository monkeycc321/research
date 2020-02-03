package edu.swfu.gis.service;

import java.util.List;






import edu.swfu.core.util.TQueryPara;
import edu.swfu.gis.dao.IFeatureDao;
import edu.swfu.gis.entity.TFeature;

public class TFeatureServiceImpl <T extends TFeature> implements IFeatureService<T> {

	
	private IFeatureDao<T> dao;
	
	public IFeatureDao<T> getDao(){
		return this.dao;
	}
	
	
    /**
     * insert a feature
     * @param model 
     * @return effect rows
     * @throws Exception
     */
	public int insert(T target) throws Exception {
		return this.getDao().insert(target);
	}
	
	
    /**
     * update a feature
     * @param model 更新的对象
     * @return effect rows 
     * @throws Exception
     */
	public int update(T target) throws Exception {
		return this.getDao().update(target);
	}

    /**
     * delete a feature by the primary key
     * @param pk 主键对象
     * @return effect rows
     */	
	public int deleteByPk(Object pk) throws Exception {
		return this.getDao().deleteByPk(pk);
	}

    /**
     * get a feature by the primary key
     * @param pk
     * @return
     * @throws Exception
     */
	public T selectByPk(Object pk) throws Exception {
		return (T) this.getDao().selectByPk(pk);
	}

    /**
     * return all features
     * @param pk
     * @return
     * @throws Exception
     */
	public List<T> selectAll() throws Exception {
		return this.getDao().selectAll();

	}

	

	/**
	 * query the features by the parameter
	 * @param para
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<T> select(TQueryPara para) throws Exception {
		return this.getDao().select(para);
	}
	

}
