// WARNING: DO NOT EDIT THIS FILE.
// You may push code into the target .java compilation unit if you wish to edit any member(s).
package org.openlegacy.terminal.samples.mvc.controllers;

import java.util.*;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.openlegacy.terminal.samples.model.*;

import org.openlegacy.modules.login.Login;
import org.openlegacy.modules.login.LoginException;
import org.openlegacy.modules.menu.Menu;
import org.openlegacy.modules.menu.MenuItem;
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

import org.openlegacy.terminal.samples.model.SignOn;

privileged @SuppressWarnings("unused") aspect SignOnController_Aspect {

	@Inject
	private TerminalSession SignOnController.terminalSession;

	@Inject
	private ScreenEntitiesRegistry SignOnController.screenEntitiesRegistry;

	// handle page initial display
    @RequestMapping(method = RequestMethod.GET)
    public String SignOnController.show(Model uiModel) {
    	SignOn signOn = new SignOn();
		uiModel.addAttribute("signOn", signOn);
        return "SignOn";
    }
    
	// handle submit action
    @RequestMapping(method = RequestMethod.POST)
    public String SignOnController.submit(SignOn signOn, Model uiModel, HttpServletRequest httpServletRequest) {
    	try{
        	terminalSession.getModule(Login.class).login(signOn);
    	}
    	catch(LoginException e){
    		// errorMessage is assigned within login method
    		return "SignOn";
    	}

    	// find the main menu screen and navigate to it
    	MenuItem mainMenu = terminalSession.getModule(Menu.class).getMenuTree();
    	if (mainMenu != null){
    		Class<?> mainMenuEntity = mainMenu.getTargetEntity();
           	return "redirect:" + screenEntitiesRegistry.get(mainMenuEntity).getEntityClassName();
		}
    	return "redirect:HtmlEmulation";
    }

	
}
