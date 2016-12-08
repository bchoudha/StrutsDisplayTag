/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.test;
import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

import com.google.gson.Gson;



/**
 *
 * @author eswar@vaannila.com
 */
public class UserAction extends org.apache.struts.action.Action implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/* forward name="success" path="" */
    private final static String SUCCESS = "success";
    
    /**
     * This is the action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        UserForm userForm = (UserForm) form;
        ActorData actorData = new ActorData();
        //actorData.setActorList(actorData.loadData());
        
        String json = new Gson().toJson(actorData.loadData());
        response.setContentType("application/json");
        response.getWriter().write(json);
        /*return mapping.findForward(SUCCESS);*/
		return null;
    }
}
