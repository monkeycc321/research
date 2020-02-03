package edu.swfu.routeplanning.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import edu.swfu.routeplanning.entity.PlanningRoute;
import edu.swfu.routeplanning.service.IPlanningRouteService;

@RestController
@EnableAutoConfiguration
@RequestMapping(name="planningRoute",value="planningRoute")
public class PlanningRouteController {
    @Autowired
    private IPlanningRouteService service;

    
    //http://localhost:8080/planningRoute/selectDirect?x1=106.719905&y1=26.572135&x2=106.708049&y2=26.569151
	@SuppressWarnings("rawtypes")
	@RequestMapping("/selectDirect")
	@ResponseBody
	public List selectDirect(Float x1,Float y1,Float x2,Float y2){
		System.out.println("select busroute!!!!!!!!!!-------------------------");
//		Float x1=(float)106.719905;
//		Float y1=(float)26.572135;
//		Float x2=(float)106.708049;
//		Float y2=(float)26.569151;
		
		List<PlanningRoute> list=null;
		try {
			list = service.selectDirect(x1,y1,x2,y2,4326,500);
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
		
		return list; 
	}

	
	//http://localhost:8080/planningRoute/selectTransfer1?x1=106.720044&y1=26.586134&x2=106.646423&y2=26.618501
	@SuppressWarnings("rawtypes")
	@RequestMapping("/selectTransfer1")
	@ResponseBody
	public List selectTransfer1(Float x1,Float y1,Float x2,Float y2){
		System.out.println("select busroute!!!!!!!!!!-------------------------");

//		Float x1=(float)106.720044;
//		Float y1=(float)26.586134;
//		Float x2=(float)106.646423;
//		Float y2=(float)26.618501;

		
		List<PlanningRoute> list=null;
		try {
			list = service.selectTransfer1(x1,y1,x2,y2,4326,500);
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
		
		return list; 

	}
	
	
	//http://localhost:8080/planningRoute/selectTransfer2?x1=106.719905&y1=26.572135&x2=106.708049&y2=26.569151
	@SuppressWarnings("rawtypes")
	@RequestMapping("/selectTransfer2")
	@ResponseBody
	public List selectTransfer2(Float x1,Float y1,Float x2,Float y2){
		System.out.println("select busroute!!!!!!!!!!-------------------------");
//		Float x1=(float)106.720044;  
//		Float y1=(float)26.586134;
//		Float x2=(float)106.646423;  
//		Float y2=(float)26.618501;
		
		List<PlanningRoute> list=null;
		try {
			list = service.selectTransfer2(x1,y1,x2,y2,4326,500);
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
		
		return list; 

	}	
}
