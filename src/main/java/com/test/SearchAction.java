package com.test;

import java.io.Serializable;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import com.google.gson.Gson;

/**
 * The Class SearchAction.
 */
public class SearchAction extends org.apache.struts.action.Action implements
		Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Constant SUCCESS. */
	private final static String SUCCESS = "success";

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.
	 * ActionMapping, org.apache.struts.action.ActionForm,
	 * javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserForm userForm = (UserForm) form;
		ActorData actorData = new ActorData();
		ArrayList<ActorData> actorList = actorData.loadData();
		// String userId = userForm.getUserId();
		String userName = userForm.getUserName();
		// String userEmail = userForm.getEmailId();
		ArrayList<ActorData> listClone = new ArrayList<ActorData>();
		for (ActorData obj : actorList) {
			if (userName != null) {
				if (obj.getUserName() != null
						&& obj.getUserName().toLowerCase()
								.contains(userName.toLowerCase())) {
					listClone.add(obj);
				}
			}
		}
		String json = new Gson().toJson(listClone);
		response.setContentType("application/json");
		response.getWriter().write(json);
		return null;
	}
}
