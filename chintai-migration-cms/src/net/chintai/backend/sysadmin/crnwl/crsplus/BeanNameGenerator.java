/*
 * Copyright 2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package net.chintai.backend.sysadmin.crnwl.crsplus;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;

/**
 * <pre>
 * BeanNameGenerator
 * </pre>
 * @author hasegawa
 * @lastModified $Date: 2014-06-27 17:56:24 +0900 (金, 27 6 2014) $ by $Author: hasegawa $
 * @version $Revision: 2607 $
 * @since 1.0
 */
public class BeanNameGenerator extends AnnotationBeanNameGenerator {
	/*
	 * (非 Javadoc)
	 *
	 * @see
	 * org.springframework.beans.factory.support.BeanNameGenerator#generateBeanName(org.springframework.beans.factory
	 * .config.BeanDefinition, org.springframework.beans.factory.support.BeanDefinitionRegistry)
	 */
	@Override
	public String generateBeanName(final BeanDefinition definition, final BeanDefinitionRegistry registry) {
		String beanName = super.generateBeanName(definition, registry);
		beanName = "crsplus" + beanName.substring(0, 1).toUpperCase() + beanName.substring(1);
		return beanName;
	}
}
