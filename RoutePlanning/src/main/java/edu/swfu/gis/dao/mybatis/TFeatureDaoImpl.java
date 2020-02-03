package edu.swfu.gis.dao.mybatis;


import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import edu.swfu.core.util.TQueryPara;
import edu.swfu.gis.dao.IFeatureDao;
import edu.swfu.gis.entity.TFeature;

public class TFeatureDaoImpl <T extends TFeature> implements IFeatureDao<T>  {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public SqlSession getSqlSession(){
		return sqlSession;
	}
	
	/**
	 * get the class name of the entity
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private String getEntityClassName() {
		Type type =this.getClass().getGenericSuperclass();

		Class<T> modelClass=(Class<T>) ((ParameterizedType)type).getActualTypeArguments()[0];
		return modelClass.getName();
		
	}
	
	/**
	 * get the name space of corresponding mapper file
	 * @return
	 */
	public String getMapperNameSpace() {
		String className = this.getEntityClassName();
		return className.replace(".entity.", ".mapper.") + "Mapper";
	}

	/**
	 * insert a feature
	 * @param target 
	 * @return 影响行数
	 */
	public int insert(T target) throws Exception {
		return getSqlSession().insert(this.getMapperNameSpace()+".insert", target);  
	}


	public int update(T target) throws Exception {
		//Field[] fields = target.getClass().getDeclaredFields();


		return getSqlSession().update(this.getMapperNameSpace()+".updateByPrimaryKey", target);
	}


	public int deleteByPk(Object pk) throws Exception {
		
		return  getSqlSession().delete(this.getMapperNameSpace()+".deleteByPrimaryKey", pk);
	}


	@SuppressWarnings("unchecked")
	public T selectByPk(Object pk) throws Exception {

		Object obj = getSqlSession().selectOne(this.getMapperNameSpace()+".selectByPrimaryKey", pk);

		 return (T)obj;
	}

	public List<T> selectAll() throws Exception {
		/*Map<String,Object> target=new HashMap<String,Object>();
		target.put("id", 1);
		target.put("name","test ok");
		
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
		
		list.add(target);
		
		return list;*/
		
		return getSqlSession().selectList(this.getMapperNameSpace()+".selectAll"); 
	}
	
	public List<T> selectByMethod(String method) throws Exception {
		return getSqlSession().selectList(this.getMapperNameSpace()+"."+method);
		
		
	}	
	
	public List<T> selectByMethod(String method, TQueryPara para) throws Exception {

		return getSqlSession().selectList(this.getMapperNameSpace()+"."+method,para);
	}

	@Override
	public List<T> selectByMethod(String method, Map<String, Object> para)
			throws Exception {
		return getSqlSession().selectList(this.getMapperNameSpace()+"."+method,para);
	}

	@Override
	public List<T> select(TQueryPara para) throws Exception {
		return getSqlSession().selectList(this.getMapperNameSpace()+".select",para);
	}



}