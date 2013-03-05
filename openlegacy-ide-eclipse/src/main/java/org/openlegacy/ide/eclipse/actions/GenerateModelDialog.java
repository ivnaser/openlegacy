/*******************************************************************************
 * Copyright (c) 2012 OpenLegacy Inc.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     OpenLegacy Inc. - initial API and implementation
 *******************************************************************************/
package org.openlegacy.ide.eclipse.actions;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.openlegacy.designtime.EntityUserInteraction;
import org.openlegacy.designtime.PreferencesConstants;
import org.openlegacy.ide.eclipse.Messages;
import org.openlegacy.ide.eclipse.util.JavaUtils;
import org.openlegacy.terminal.TerminalSnapshot;
import org.openlegacy.terminal.definitions.ScreenEntityDefinition;

import java.io.File;
import java.text.MessageFormat;

public class GenerateModelDialog extends AbstractGenerateCodeDialog implements EntityUserInteraction<ScreenEntityDefinition> {

	private TerminalSnapshot[] terminalSnapshots;

	public GenerateModelDialog(Shell shell, IFile file, TerminalSnapshot... terminalSnapshots) {
		super(shell, file);
		this.terminalSnapshots = terminalSnapshots;
	}

	private final static Logger logger = Logger.getLogger(GenerateModelDialog.class);

	@Override
	protected void executeGenerate() {

		Job job = new Job(Messages.job_generating_model) {

			@Override
			protected IStatus run(final IProgressMonitor monitor) {

				final IFile trailPath = getFile();
				int fileSize = (int)(new File(trailPath.getLocation().toOSString()).length() / 1000);
				monitor.beginTask(Messages.job_activating_analyzer, fileSize);

				monitor.worked(2);
				EclipseDesignTimeExecuter.instance().generateModel(trailPath, getSourceFolder(), getPackageValue(),
						GenerateModelDialog.this, isUseAj(), terminalSnapshots);

				monitor.worked(fileSize - 4);
				Display.getDefault().syncExec(new Runnable() {

					public void run() {
						try {
							monitor.worked(1);
							trailPath.getProject().refreshLocal(IResource.DEPTH_INFINITE, monitor);
							monitor.done();
						} catch (CoreException e) {
							logger.fatal(e);
						}
					}
				});

				return Status.OK_STATUS;
			}
		};
		job.schedule();
	}

	@Override
	protected void loadPrefrences() {

		EclipseDesignTimeExecuter designtimeExecuter = EclipseDesignTimeExecuter.instance();
		IProject project = getProject();

		String prefrenceSourceFolderPath = designtimeExecuter.getPreference(project, PreferencesConstants.API_SOURCE_FOLDER);
		getSourceFolderPathText().setText(
				MessageFormat.format("{0}{1}{2}", project.getName(), File.separator, prefrenceSourceFolderPath)); //$NON-NLS-1$

		IJavaProject javaProject = JavaUtils.getJavaProjectFromIProject(project);
		setSourceFolder(javaProject.getPackageFragmentRoot(prefrenceSourceFolderPath));

		String prefrencePackage = designtimeExecuter.getPreference(project, PreferencesConstants.API_PACKAGE);
		if (prefrencePackage != null) {
			getPackageText().setText(prefrencePackage);
		}
		String useAjStr = designtimeExecuter.getPreference(project, PreferencesConstants.USE_AJ);
		if (useAjStr.equals("0")) {
			this.setUseAj(false);
		}
	}

	@Override
	protected void savePreferences() {
		String sourceFolderOnly = getSourceFolderPathText().getText().substring(
				getSourceFolder().getJavaProject().getProject().getName().length() + 1);

		EclipseDesignTimeExecuter designtimeExecuter = EclipseDesignTimeExecuter.instance();

		designtimeExecuter.savePreference(getProject(), PreferencesConstants.API_SOURCE_FOLDER, sourceFolderOnly);
		designtimeExecuter.savePreference(getProject(), PreferencesConstants.API_PACKAGE, getPackageText().getText());
		designtimeExecuter.savePreference(getProject(), PreferencesConstants.USE_AJ, isUseAj());
	}

	public boolean customizeEntity(final ScreenEntityDefinition screenEntityDefinition) {

		final BooleanContainer generate = new BooleanContainer();
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				CustomizeScreenEntityDialog customizeDialog = new CustomizeScreenEntityDialog(getShell(), screenEntityDefinition);
				int result = customizeDialog.open();
				if (result == Window.CANCEL) {
					generate.setBooleanValue(false);
				}
			}
		});
		return generate.getBooleanValue();
	}

	private static class BooleanContainer {

		boolean booleanValue = true;

		public void setBooleanValue(boolean booleanValue) {
			this.booleanValue = booleanValue;
		}

		public boolean getBooleanValue() {
			return booleanValue;

		}
	}
}
