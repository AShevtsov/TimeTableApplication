

package servlets;

import daohelper.DAOHelper;
import daohelper.IDAOHelper;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {""})
public class TimeTableServlet extends HttpServlet {
    private final IDAOHelper helper;
    
    private class RequestData{
        public String page;
        public Long id;
        public String action;
    }
    
    public TimeTableServlet(){
        helper = new DAOHelper();
    }
    
    private RequestData getRequestData(HttpServletRequest request){
        RequestData rd = new RequestData();
        rd.page = request.getParameter("page");
        
        if (request.getParameter("id") == null){
            rd.id = Long.valueOf(0);
        }
        else{
            try{
                rd.id = Long.valueOf(request.getParameter("id"));
            }
            catch (NumberFormatException e){
                rd.id = Long.valueOf(0);
            }
        }
        
        rd.action = request.getParameter("action");
        
        return rd;
    }
      
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestData rd = getRequestData(request);
        
        if (rd.page == null){
            request.getRequestDispatcher("WEB-INF/pages/index.jsp").forward(request, response);
            return;
        }
        
        Class clazz = null;
        StringBuilder page = new StringBuilder();
        try{
            clazz = Class.forName("models." + rd.page);
            page.append("WEB-INF/pages/").append(rd.page).append(".jsp");
        } catch (ClassNotFoundException|RuntimeException ex) {
            request.setAttribute("error", ex);
            page.append("WEB-INF/pages/index.jsp");
        }
        finally{
            request.setAttribute("table", helper.getTable(clazz, rd.id));
            request.getRequestDispatcher(page.toString()).forward(request, response);
        }
    }
        
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
        request.setCharacterEncoding("UTF-8");

        RequestData rd = getRequestData(request);

        Class clazz;
        try{
            clazz = Class.forName("models." + rd.page);
        }
        catch(ClassNotFoundException ex){
            request.setAttribute("error", ex);
            request.getRequestDispatcher("WEB-INF/pages/index.jsp").forward(request, response);
            return;     
        }

        switch (rd.action){
            case "add":
                actionAdd(request, rd, clazz);
                break;
            case "delete":
                actionDelete(request, rd, clazz);
                break;
            case "update":
                actionUpdate(request, rd, clazz);
        }
        request.setAttribute("table", helper.getTable(clazz, Long.valueOf(0)));
        request.getRequestDispatcher("WEB-INF/pages/" + rd.page + ".jsp").forward(request, response);        
    }
    
    private void actionAdd(HttpServletRequest request, RequestData rd, Class clazz){
        try{
            Object obj;
            obj = helper.addElement(clazz, request.getParameterMap());    
            if (obj == null) request.setAttribute("error", "Не удалось добавить объект");
        }
        catch (RuntimeException ex){
            request.setAttribute("error", ex);
        }

    }
    
    private void actionDelete(HttpServletRequest request, RequestData rd, Class clazz){
        try{
            helper.deleteElement(clazz, rd.id);    
        }
        catch(RuntimeException ex){
            request.setAttribute("error", ex.getMessage());
        }

    }
    
    private void actionUpdate(HttpServletRequest request, RequestData rd, Class clazz){
        try{
            helper.update(clazz, rd.id, request.getParameterMap());
        }
        catch (RuntimeException ex){
            request.setAttribute("error", ex.getMessage());
        }

    }
    
}
