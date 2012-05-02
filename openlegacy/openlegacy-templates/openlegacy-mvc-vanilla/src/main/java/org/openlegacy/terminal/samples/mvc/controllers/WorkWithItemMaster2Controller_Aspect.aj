// WARNING: DO NOT EDIT THIS FILE.
// You may push code into the target .java compilation unit if you wish to edit any member(s).
package org.openlegacy.terminal.samples.mvc.controllers;

import java.util.*;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import org.springframework.beans.propertyeditors.CustomDateEditor;

import org.openlegacy.terminal.ScreenEntity;
import org.openlegacy.terminal.TerminalSession;
import org.openlegacy.terminal.actions.TerminalActions;
import org.openlegacy.terminal.spi.ScreenEntitiesRegistry;
import org.openlegacy.terminal.web.JsonSerializationUtil;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.WebDataBinder;

import org.openlegacy.terminal.samples.model.WorkWithItemMaster2;

privileged @SuppressWarnings("unused") aspect WorkWithItemMaster2Controller_Aspect {

	@Inject
	private TerminalSession WorkWithItemMaster2Controller.terminalSession;

	@Inject
	private ScreenEntitiesRegistry WorkWithItemMaster2Controller.screenEntitiesRegistry;

	// handle page initial display
    @RequestMapping(method = RequestMethod.GET, params="partial=1")
    public String WorkWithItemMaster2Controller.show(Model uiModel) {
    	WorkWithItemMaster2 workWithItemMaster2 = terminalSession.getEntity(WorkWithItemMaster2.class);
	uiModel.addAttribute("workWithItemMaster2", workWithItemMaster2);
	// show the resulting page for WorkWithItemMaster2
        return "WorkWithItemMaster2";
    }

    @RequestMapping(value="/help", method = RequestMethod.GET)
    public @ResponseBody String WorkWithItemMaster2Controller.systemHelp(HttpServletRequest request) throws IOException {
    	URL resource = request.getSession().getServletContext().getResource("/help/workWithItemMaster2.html");
    	String result = "";
    	if (resource != null){
    		result = IOUtils.toString(resource.openStream());
    	}
    	return result;
    }

	// handle submit action
    @RequestMapping(method = RequestMethod.POST)
    public String WorkWithItemMaster2Controller.submit(WorkWithItemMaster2 workWithItemMaster2, Model uiModel, HttpServletRequest httpServletRequest) {
	ScreenEntity resultScreenEntity = terminalSession.doAction(TerminalActions.ENTER(), workWithItemMaster2);
	// go to the controller for the resulting screen name
		if (resultScreenEntity != null){
			String screenEntityName = screenEntitiesRegistry.get(resultScreenEntity.getClass()).getEntityClassName();
			if (httpServletRequest.getParameter("partial") != null){
				workWithItemMaster2 = terminalSession.getEntity(WorkWithItemMaster2.class);
		    	uiModel.addAttribute("workWithItemMaster2", workWithItemMaster2);
		        return "WorkWithItemMaster2";
			}
        	return "redirect:" + screenEntityName;
		}
    	return "redirect:/";
		
    }
    
	// handle help action
    @RequestMapping(params="action=help", method = RequestMethod.POST)
    public String WorkWithItemMaster2Controller.help(WorkWithItemMaster2 workWithItemMaster2, Model uiModel, HttpServletRequest httpServletRequest) {
	ScreenEntity resultScreenEntity = terminalSession.doAction(TerminalActions.F1(), workWithItemMaster2);
	// go to the controller for the resulting screen name
		if (resultScreenEntity != null){
			String screenEntityName = screenEntitiesRegistry.get(resultScreenEntity.getClass()).getEntityClassName();
			if (httpServletRequest.getParameter("partial") != null){
				workWithItemMaster2 = terminalSession.getEntity(WorkWithItemMaster2.class);
		    	uiModel.addAttribute("workWithItemMaster2", workWithItemMaster2);
		        return "WorkWithItemMaster2";
			}
        	return "redirect:" + screenEntityName;
		}
    	return "redirect:/";
		
    }
	// handle cancel action
    @RequestMapping(params="action=cancel", method = RequestMethod.POST)
    public String WorkWithItemMaster2Controller.cancel(WorkWithItemMaster2 workWithItemMaster2, Model uiModel, HttpServletRequest httpServletRequest) {
	ScreenEntity resultScreenEntity = terminalSession.doAction(TerminalActions.F3(), workWithItemMaster2);
	// go to the controller for the resulting screen name
		if (resultScreenEntity != null){
			String screenEntityName = screenEntitiesRegistry.get(resultScreenEntity.getClass()).getEntityClassName();
			if (httpServletRequest.getParameter("partial") != null){
				workWithItemMaster2 = terminalSession.getEntity(WorkWithItemMaster2.class);
		    	uiModel.addAttribute("workWithItemMaster2", workWithItemMaster2);
		        return "WorkWithItemMaster2";
			}
        	return "redirect:" + screenEntityName;
		}
    	return "redirect:/";
		
    }
	// handle prompt action
    @RequestMapping(params="action=prompt", method = RequestMethod.POST)
    public String WorkWithItemMaster2Controller.prompt(WorkWithItemMaster2 workWithItemMaster2, Model uiModel, HttpServletRequest httpServletRequest) {
	ScreenEntity resultScreenEntity = terminalSession.doAction(TerminalActions.F4(), workWithItemMaster2);
	// go to the controller for the resulting screen name
		if (resultScreenEntity != null){
			String screenEntityName = screenEntitiesRegistry.get(resultScreenEntity.getClass()).getEntityClassName();
			if (httpServletRequest.getParameter("partial") != null){
				workWithItemMaster2 = terminalSession.getEntity(WorkWithItemMaster2.class);
		    	uiModel.addAttribute("workWithItemMaster2", workWithItemMaster2);
		        return "WorkWithItemMaster2";
			}
        	return "redirect:" + screenEntityName;
		}
    	return "redirect:/";
		
    }
	// handle return_ action
    @RequestMapping(params="action=return_", method = RequestMethod.POST)
    public String WorkWithItemMaster2Controller.return_(WorkWithItemMaster2 workWithItemMaster2, Model uiModel, HttpServletRequest httpServletRequest) {
	ScreenEntity resultScreenEntity = terminalSession.doAction(TerminalActions.F12(), workWithItemMaster2);
	// go to the controller for the resulting screen name
		if (resultScreenEntity != null){
			String screenEntityName = screenEntitiesRegistry.get(resultScreenEntity.getClass()).getEntityClassName();
			if (httpServletRequest.getParameter("partial") != null){
				workWithItemMaster2 = terminalSession.getEntity(WorkWithItemMaster2.class);
		    	uiModel.addAttribute("workWithItemMaster2", workWithItemMaster2);
		        return "WorkWithItemMaster2";
			}
        	return "redirect:" + screenEntityName;
		}
    	return "redirect:/";
		
    }
	// handle delete action
    @RequestMapping(params="action=delete", method = RequestMethod.POST)
    public String WorkWithItemMaster2Controller.delete(WorkWithItemMaster2 workWithItemMaster2, Model uiModel, HttpServletRequest httpServletRequest) {
	ScreenEntity resultScreenEntity = terminalSession.doAction(TerminalActions.F2(), workWithItemMaster2);
	// go to the controller for the resulting screen name
		if (resultScreenEntity != null){
			String screenEntityName = screenEntitiesRegistry.get(resultScreenEntity.getClass()).getEntityClassName();
			if (httpServletRequest.getParameter("partial") != null){
				workWithItemMaster2 = terminalSession.getEntity(WorkWithItemMaster2.class);
		    	uiModel.addAttribute("workWithItemMaster2", workWithItemMaster2);
		        return "WorkWithItemMaster2";
			}
        	return "redirect:" + screenEntityName;
		}
    	return "redirect:/";
		
    }
	
	
	@InitBinder
	public void WorkWithItemMaster2Controller.initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
}
