package br.com.learn.configuration.portlet;

import br.com.learn.configuration.constants.LearnConfigurationPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author marcos
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.hidden",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=LearnConfiguration",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + LearnConfigurationPortletKeys.LEARNCONFIGURATION,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class LearnConfigurationPortlet extends MVCPortlet {
}