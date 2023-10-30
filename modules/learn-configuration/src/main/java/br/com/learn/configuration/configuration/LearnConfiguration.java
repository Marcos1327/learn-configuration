package br.com.learn.configuration.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition.Scope;

import aQute.bnd.annotation.metatype.Meta;
import br.com.learn.configuration.constants.ConfigConstants;

@ExtendedObjectClassDefinition(
		category = ConfigConstants.CATEGORY_KEY,
		scope = Scope.SYSTEM
)

@Meta.OCD(
		 id = ConfigConstants.PID_LEARN_CONFIGURATION,
		 name = "learn-configuration"
)
public interface LearnConfiguration {
	
	@Meta.AD(
		name = "apiUrl", required = false,	deflt = "",
		description = "URL da API"
	)
	String getApiUrl();
	
	@Meta.AD(
		name= "group", required=false,
		description="Grupos"
	)
	String getGroupId();
	
	@Meta.AD(
		name= "fields", required=false,
		description="Fields"
	)
	String[] getFields();
	
	@Meta.AD(
		name= "book", required=false,
		description="Livro"
	)
	String getBookId();





}
