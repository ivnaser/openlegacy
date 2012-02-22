package org.openlegacy.loaders.support;

import org.openlegacy.EntitiesRegistry;
import org.openlegacy.EntityDefinition;
import org.openlegacy.annotations.screen.ScreenField;
import org.openlegacy.loaders.FieldAnnotationsLoader;
import org.openlegacy.terminal.definitions.ScreenPartEntityDefinition;
import org.openlegacy.terminal.definitions.SimpleScreenFieldDefinition;
import org.openlegacy.terminal.spi.ScreenEntitiesRegistry;
import org.openlegacy.terminal.support.SimpleTerminalPosition;
import org.openlegacy.utils.StringUtil;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.text.MessageFormat;

@Component
public class ScreenFieldAnnotationLoader implements FieldAnnotationsLoader {

	public boolean match(Annotation annotation) {
		return annotation.annotationType() == ScreenField.class;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void load(BeanFactory beanFactory, EntitiesRegistry entitiesRegistry, String fieldName, Annotation annotation,
			Class<?> containingClass) {
		ScreenEntitiesRegistry screenEntitiesRegistry = (ScreenEntitiesRegistry)entitiesRegistry;

		ScreenField fieldAnnotation = (ScreenField)annotation;

		SimpleTerminalPosition position = SimpleTerminalPosition.newInstance(fieldAnnotation.row(), fieldAnnotation.column());
		SimpleScreenFieldDefinition screenFieldDefinition = new SimpleScreenFieldDefinition(fieldName,
				fieldAnnotation.fieldType());
		screenFieldDefinition.setPosition(position);

		if (fieldAnnotation.endColumn() == 0) {
			screenFieldDefinition.setLength(0);
		} else {
			screenFieldDefinition.setLength(fieldAnnotation.endColumn() - fieldAnnotation.column() + 1);
		}

		screenFieldDefinition.setEditable(fieldAnnotation.editable());

		if (fieldAnnotation.displayName().length() > 0) {
			screenFieldDefinition.setDisplayName(fieldAnnotation.displayName());
		} else {
			screenFieldDefinition.setDisplayName(StringUtil.toDisplayName(fieldName));
		}

		screenFieldDefinition.setSampleValue(fieldAnnotation.sampleValue());

		EntityDefinition screenEntityDefinition = screenEntitiesRegistry.get(containingClass);
		// look in screen entities
		if (screenEntityDefinition != null) {
			screenEntityDefinition.getFieldsDefinitions().put(fieldName, screenFieldDefinition);
		} else {
			// look in screen entities parts
			ScreenPartEntityDefinition screenPart = screenEntitiesRegistry.getPart(containingClass);
			if (screenPart != null) {
				fieldName = MessageFormat.format("{0}.{1}", screenPart.getPartName(), fieldName);
				screenFieldDefinition.setName(fieldName);
				screenPart.getFieldsDefinitions().put(fieldName, screenFieldDefinition);
			}

		}

	}

}