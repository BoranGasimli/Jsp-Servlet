import az.azex.domain.FlexibleList;
import az.azex.repository.CommonDao;
import az.azex.repository.implementation.CommonDaoImpl;
import az.azex.repository.implementation.DatabaseHelper;
import az.azex.service.CommonService;
import az.azex.service.implementation.CommonServiceImpl;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebListener()
public class WebApplicationListener implements ServletContextListener {

    // Public constructor is required by servlet spec
    public WebApplicationListener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */

        try {
            DataSource dataSource = DatabaseHelper.getDataSource();
            CommonDao commonDao = new CommonDaoImpl(dataSource);
            CommonService commonService = new CommonServiceImpl(commonDao);

            List<FlexibleList> allList = commonService.getAllFlexibleList();
            Map<String, FlexibleList> flexibleListMap = new HashMap<>();
            for(FlexibleList list : allList) {
                flexibleListMap.put(list.getName(), list);
            }

            System.out.println("flexibleListMap = " + flexibleListMap);
            sce.getServletContext().setAttribute("flexibleListMap", flexibleListMap);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */


    }

}
