package edu.swfu.routeplanning.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.swfu.core.util.ControllerHelper;
import edu.swfu.core.util.TQueryPara;
import edu.swfu.gis.entity.TPoint;
import edu.swfu.routeplanning.entity.BusRoute;
import edu.swfu.routeplanning.entity.BusRoutePoint;
import edu.swfu.routeplanning.entity.BusRouteStop;
import edu.swfu.routeplanning.entity.BusStop;
import edu.swfu.routeplanning.service.IBusRouteService;
import edu.swfu.routeplanning.service.IBusStopService;

@RestController
@EnableAutoConfiguration
@RequestMapping(name = "busRoute", value = "busRoute")
public class BusRouteController {
	@Autowired
	private IBusRouteService service;
	
    @Autowired
    private IBusStopService busStopService;
    
//    @Autowired
//    private IBusRouteStopService busRouteStopService;
//    
//    @Autowired
//    private IBusRoutePointService busRoutePointService;
   
	
	
	@RequestMapping("/collect")
	public Map<String, Object> collect(BusRoute target,String stations,String points,Long pointsId) {
		System.out.println(target.getName());
		//System.out.println(stations);
		System.out.println("--------------------------------");
		
		Map<String, Object> result=new HashMap<String,Object>();
		try {
			List<BusRouteStop> lstBrs=new ArrayList<BusRouteStop>();
			String[] ss=stations.split("\\|");
			int sn=1;
			for (String s:ss) {
				String[] props=s.split(",");
				
				//insert a bus stop
				BusStop busStop=new BusStop();
				String name=props[0];
				busStop.setName(name);
				busStop.setGeometry(new TPoint(4326,Double.parseDouble(props[1]),Double.parseDouble(props[2])));
				busStop.setId(busStopService.getStopId(name,busStop.getGeometry()));
				busStop.setCode(busStopService.getStopCode(busStop.getGeometry()));
				//System.out.println(busStop.getId()+":"+busStop.getName());
				busStop.setNotes(props[3]);
				busStopService.insert(busStop);
				
				BusRouteStop busRouteStop=new BusRouteStop();
				busRouteStop.setId(busStop.getId());
				busRouteStop.setGeometry(new TPoint(4326,Double.parseDouble(props[1]),Double.parseDouble(props[2])));
				busRouteStop.setBusRouteId(target.getId());
				busRouteStop.setSn(sn++);
				lstBrs.add(busRouteStop);
			}
			
			List<BusRoutePoint> lstPoi=new ArrayList<BusRoutePoint>();
			ss=points.split("\\|");
			Long id=pointsId+1;
			for (String s:ss) {
				String[] props=s.split(",");
				BusRoutePoint busRoutePoint=new BusRoutePoint();
				busRoutePoint.setId((id++).toString());
				busRoutePoint.setName(target.getName());
				busRoutePoint.setGeometry(new TPoint(4326,Double.parseDouble(props[0]),Double.parseDouble(props[1])));
				busRoutePoint.setBusRouteId(target.getId());
				lstPoi.add(busRoutePoint);
			}
			
			
			//insert a bus route
			int i = service.collect(target,lstBrs,lstPoi);
			
			if (i == 1) {
				result = ControllerHelper.getSuccessMap();
			} else {
				result = ControllerHelper.getErrorMap("effect rows != 1");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());

			result = ControllerHelper.getErrorMap(e);
		}
		return result;
	}
	

	@RequestMapping("/insert")
	public Map<String, Object> insert(BusRoute target) {
		Map<String, Object> result;
		try {
			int i = service.insert(target);
			if (i == 1) {
				result = ControllerHelper.getSuccessMap();
			} else {
				result = ControllerHelper.getErrorMap("effect rows != 1");
			}
		} catch (Exception e) {

			result = ControllerHelper.getErrorMap(e);
		}
		return result;
	}

	/**
	 * @describe: 修改
	 * @param target
	 *            待修改实体
	 */
	@RequestMapping("/update")
	public Object update(BusRoute target, HttpServletRequest request) {
		Map<String, Object> result;
		try {
			int i = service.update(target);
			if (i == 1) {
				result = ControllerHelper.getSuccessMap();
			} else {
				result = ControllerHelper.getErrorMap("effect rows != 1");
			}
		} catch (Exception e) {

			result = ControllerHelper.getErrorMap(e);
		}
		return result;
	}

	/**
	 * 根据条件删除
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/delete")
	public Map<String, Object> delete(Object id) {
		Map<String, Object> result;
		try {
			int i = service.deleteByPk(id);
			if (i > 0) {
				result = ControllerHelper.getSuccessMap();
			} else {
				result = ControllerHelper.getErrorMap("员工删除失败！");
			}
		} catch (Exception e) {

			result = ControllerHelper.getErrorMap(e);
		}
		return result;
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/searchByKey")
	public Map<String, Object> searchByKey(String key) {
		Map<String, Object> result;
		
		List<Map<String,Object>> data=new ArrayList<Map<String,Object>> ();
		
		TQueryPara para=new TQueryPara();
		para.addExp("name_like", "%"+key+"%");
		try {
			List<BusRoute> lstBusRoute=service.select(para);
			for (BusRoute route:lstBusRoute) {
				Map map=new HashMap<String,Object>();
				map.put("busRoute", route);
				
				List<BusStop> stops= busStopService.selectByRoute(route.getId());
				map.put("busStops", stops);
				
				data.add(map);
			}
			
			result=ControllerHelper.getSuccessMap(data);
		} catch (Exception e) {

			result = ControllerHelper.getErrorMap(e);
		}
		return result;
	}
	
    /**
     * select the passing bus stations 
     * @param routeId 
     * @param sn1
     * @param sn2
     * @return success/error message
     */
    //http://localhost:8080/busRoute/searchStopsBySn?routeId=5201B00101&sn1=9&sn2=15
    @RequestMapping("/searchStopsBySn")
    public Map<String, Object> searchStopsBySn(String routeId,Integer sn1,Integer sn2) {
        Map<String, Object> result;
        
        try {
            List<BusStop> datas= busStopService.selectByRoute(routeId, sn1, sn2);
            result = ControllerHelper.getSuccessMap(datas);
        } catch (Exception e) {
             result = ControllerHelper.getErrorMap(e);
        }
        return result;
    }  	
	

	/**
	 * 分页查询
	 * 
	 * @return 分页及数据Map
	 */
//	@RequestMapping("/select")
//	public Map<String, Object> selectPage(HttpServletRequest request,
//			Integer page, Integer rows) {
//		TQueryPage queryPage;
//		try {
//			queryPage = service.select(ControllerHelper.readQueryPara(request),
//					page, rows);
//
//			return ControllerHelper.getSuccessMap(queryPage.getDatas(),
//					queryPage.getTotal());
//		} catch (Exception e) {
//
//			return ControllerHelper.getErrorMap(e);
//		}
//	}

}
