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
package org.openlegacy.loaders.support;

import org.openlegacy.EntitiesRegistry;
import org.openlegacy.annotations.screen.DisplayType;
import org.openlegacy.terminal.definitions.ScreenEntityDefinition;
import org.openlegacy.terminal.definitions.ScreenPartEntityDefinition;
import org.openlegacy.terminal.definitions.SimpleScreenFieldDefinition;
import org.openlegacy.terminal.services.ScreenEntitiesRegistry;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.text.MessageFormat;

@Component
public class DisplayTypeAnnotationLoader extends AbstractFieldAnnotationLoader {

	public boolean match(Annotation annotation) {
		return annotation.annotationType() == DisplayType.class;
	}

	@SuppressWarnings({ "rawtypes" })
	public void load(EntitiesRegistry entitiesRegistry, Field field, Annotation annotation, Class<?> containingClass) {
		ScreenEntitiesRegistry screenEntitiesRegistry = (ScreenEntitiesRegistry)entitiesRegistry;

		DisplayType displayTypeAnnotation = (DisplayType)annotation;

		ScreenEntityDefinition screenEntityDefinition = screenEntitiesRegistry.get(containingClass);
		String fieldName = field.getName();

		// look in screen entities
		if (screenEntityDefinition != null) {
			SimpleScreenFieldDefinition fieldDefinition = (SimpleScreenFieldDefinition)screenEntityDefinition.getFieldsDefinitions().get(
					fieldName);
			fieldDefinition.setDisplayType(displayTypeAnnotation.displayType());
		} else {
			// look in screen entities parts
			ScreenPartEntityDefinition screenPart = screenEntitiesRegistry.getPart(containingClass);
			if (screenPart != null) {
				fieldName = MessageFormat.format("{0}.{1}", screenPart.getPartName(), fieldName);
				SimpleScreenFieldDefinition fieldDefinition = (SimpleScreenFieldDefinition)screenPart.getFieldsDefinitions().get(
						fieldName);
				fieldDefinition.setDisplayType(displayTypeAnnotation.displayType());
			}

		}

	}
}
