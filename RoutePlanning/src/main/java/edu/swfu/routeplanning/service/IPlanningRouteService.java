package edu.swfu.routeplanning.service;

import java.util.List;
import edu.swfu.routeplanning.entity.PlanningRoute;

public interface IPlanningRouteService  {
	public List<PlanningRoute> selectDirect(Float x1,Float y1,Float x2,Float y2,Integer srid,Integer distance) throws Exception;
	public List<PlanningRoute> selectTransfer1(Float x1,Float y1,Float x2,Float y2,Integer srid,Integer distance) throws Exception;
	public List<PlanningRoute> selectTransfer2(Float x1,Float y1,Float x2,Float y2,Integer srid,Integer distance) throws Exception;
}
