package org.openlegacy.terminal.web.mvc;

import org.openlegacy.terminal.TerminalSession;
import org.openlegacy.terminal.render.TerminalSnapshotImageRenderer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.text.MessageFormat;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/sessionViewer")
public class SessionViewerController {

	@Inject
	private TerminalSession terminalSession;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody
	String viewer(HttpServletRequest request) throws IOException {
		return MessageFormat.format("<html><body><image src=\"{0}/sessionViewer/image\"</body></html>", request.getContextPath());
	}

	@RequestMapping(value = "/image", method = RequestMethod.GET)
	public void image(HttpServletResponse response) throws IOException {
		response.setContentType("image/jpeg");
		TerminalSnapshotImageRenderer.instance().render(terminalSession.getSnapshot(), response.getOutputStream());
	}

}