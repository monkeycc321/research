package edu.swfu.routeplanning.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.swfu.core.util.ControllerHelper;
import edu.swfu.core.util.TQueryPara;
import edu.swfu.routeplanning.entity.BusStop;
import edu.swfu.routeplanning.service.IBusStopService;



@RestController
@EnableAutoConfiguration
@RequestMapping(name="busStop",value="busStop")
public class BusStopController {
    @Autowired
    private IBusStopService service;


    /**
     * insert a object of BusStop type
     * @param target
     * @return success/error message
     */
    @RequestMapping("/insert")
    public Map<String, Object> insert(BusStop target){
        Map<String, Object> result;
        try {
            int i = service.insert(target);
            if (i == 1) {
                result = ControllerHelper.getSuccessMap();
            }else {
                result = ControllerHelper.getErrorMap("effect rows != 1");
            }
        } catch (Exception e) {
            
            result = ControllerHelper.getErrorMap(e);
        }
        return result;
    }

    /**
     * update a object of BusStop type
     * @param target
     * @return success/error message
     */
    @RequestMapping("/update")
    public Object update(BusStop target) {
        Map<String, Object> result;
        try {
            int i = service.update(target);
            if (i  == 1) {
                result = ControllerHelper.getSuccessMap();
            }else {
            	result = ControllerHelper.getErrorMap("effect rows != 1");
            }
        } catch (Exception e) {
            
            result = ControllerHelper.getErrorMap(e);
        }
        return result;
    }

    /**
     * delete a object of BusStop type by the primary key
     * @param request
     * @return success/error message
     */
    @RequestMapping("/deleteByPk")
    public Map<String, Object> deleteByPk(String id) {
        Map<String, Object> result;
        try {
            int i= service.deleteByPk(id);
            if (i > 0) {
                result = ControllerHelper.getSuccessMap();
            }else {
                result = ControllerHelper.getErrorMap("员工删除失败！");
            }
        } catch (Exception e) {
            
            result = ControllerHelper.getErrorMap(e);
        }
        return result;
    }
    
    /**
     * select a object of BusStop type by the primary key
     * @param request
     * @return success/error message
     */
    @RequestMapping("/selectByPk")
    public Map<String, Object> selectByPk(String id) {
        Map<String, Object> result;
        try {
            BusStop data= service.selectByPk(id);
            result = ControllerHelper.getSuccessMap(data);
        } catch (Exception e) {
             result = ControllerHelper.getErrorMap(e);
        }
        return result;
    }    


    /**
     * select a object of BusStop type by the key
     * @param request
     * @return success/error message
     */
    @RequestMapping("/selectByKey")
    public Map<String, Object> searchByKey(String key) {
        Map<String, Object> result;
		TQueryPara para=new TQueryPara();
		para.addExp("name_like", "%"+key+"%");        
        
        try {
            List<BusStop> datas= service.select(para);
            result = ControllerHelper.getSuccessMap(datas);
        } catch (Exception e) {
             result = ControllerHelper.getErrorMap(e);
        }
        return result;
    }   
  
    
   

//    @RequestMapping("/select")
//    public Map<String, Object> selectPage(HttpServletRequest request, Integer page, Integer rows) {
//        TQueryPage queryPage;
//        try {
//            queryPage = service.select(ControllerHelper.readQueryPara(request), page, rows);
//
//            return ControllerHelper.getSuccessMap(queryPage.getDatas(), queryPage.getTotal());
//        } catch (Exception e) {
//            LOGGER.error(e.getMessage());
//            return ControllerHelper.getErrorMap(e);
//        }
//    }


}
