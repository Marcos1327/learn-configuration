package br.com.learn.configuration.configuration;

import com.liferay.configuration.admin.category.ConfigurationCategory;

import org.osgi.service.component.annotations.Component;

import br.com.learn.configuration.constants.ConfigConstants;

@Component(service = ConfigurationCategory.class)
public class LearnConfigurationCategory implements ConfigurationCategory {

	@Override
	public String getCategoryKey() {
		return ConfigConstants.CATEGORY_KEY;
	}

	@Override
	public String getCategorySection() {
		return ConfigConstants.CATEGORY_SECTION;
	}
	
	@Override
	public String getBundleSymbolicName() {
		return ConfigConstants.SYMBOLIC_NAME;
	}
	
	
	
	
}
