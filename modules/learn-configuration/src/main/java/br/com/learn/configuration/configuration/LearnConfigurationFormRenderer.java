package br.com.learn.configuration.configuration;

import com.liferay.configuration.admin.display.ConfigurationFormRenderer;
import com.liferay.frontend.taglib.servlet.taglib.util.JSPRenderer;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import br.com.learn.configuration.constants.ConfigConstants;

@Component(configurationPid = ConfigConstants.PID_LEARN_CONFIGURATION, immediate = true, service = ConfigurationFormRenderer.class)
public class LearnConfigurationFormRenderer implements ConfigurationFormRenderer {

	@Override
	public String getPid() {
		return ConfigConstants.PID_LEARN_CONFIGURATION;
	}

	@Override
	public Map<String, Object> getRequestParameters(HttpServletRequest httpServletRequest) {
		Map<String, Object> params = new HashMap<String, Object>();
		
		String apiUrl = ParamUtil.getString(httpServletRequest, "apiUrl");
		String group = ParamUtil.getString(httpServletRequest, "group");
		
		params.put("getApiUrl", apiUrl);
		params.put("getGroupId", group);
		
		return params;
	}

	@Override
	public void render(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
		ThemeDisplay themeDisplay = (ThemeDisplay) httpServletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		LearnConfigurationDisplayContext learnConfigurationDisplayContext = new LearnConfigurationDisplayContext();
		
		String apiUrl;
		
		long companyId = themeDisplay.getCompanyId();
		
		if (_learnConfiguration.getApiUrl().isEmpty()) {
			
			apiUrl = PropsUtil.get("lalalalalalala");
		}else {
			apiUrl = _learnConfiguration.getApiUrl();
		}
		
		List<Group> _groups = new ArrayList<Group>();
		
		_groups = _groupLocalService
				.getGroups(companyId, QueryUtil.ALL_POS, true)
				.stream()
				.collect(Collectors.toList());
		
		learnConfigurationDisplayContext.setApiUrl(apiUrl);
		learnConfigurationDisplayContext.set_groups(_groups);
		learnConfigurationDisplayContext.setGroup(_learnConfiguration.getGroupId());
		
		
		httpServletRequest.setAttribute(LearnConfigurationDisplayContext.class.getName(),
				learnConfigurationDisplayContext);
		
		_jspRenderer.renderJSP(_servletContext, httpServletRequest, httpServletResponse, "/configuration/learn.jsp");


	}
	
	@Activate
	@Modified
	public void activate(Map<String, Object> properties) {
		_learnConfiguration = ConfigurableUtil.createConfigurable(LearnConfiguration.class,
				properties);
	}

	private volatile LearnConfiguration _learnConfiguration;
	
	@Reference
	private JSPRenderer _jspRenderer;
	
	@Reference
	private GroupLocalService _groupLocalService;
	
	@Reference(target = "(osgi.web.symbolicname=" + ConfigConstants.SYMBOLIC_NAME + ")", unbind = "-")
	private ServletContext _servletContext;




}
