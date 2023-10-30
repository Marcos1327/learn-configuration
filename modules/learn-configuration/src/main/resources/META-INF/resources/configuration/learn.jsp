<%@ include file="/init.jsp"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="br.com.learn.configuration.configuration.LearnConfigurationDisplayContext"%>

<%
	LearnConfigurationDisplayContext learnConfigurationDisplayContext = (LearnConfigurationDisplayContext) request
			.getAttribute(LearnConfigurationDisplayContext.class.getName());

	pageContext.setAttribute("displayContext", learnConfigurationDisplayContext);
%>

<div class="sheet-section">
	<br>
	<h6 class="sheet-subtitle">Conexão</h6>
	<div class="form-group">
		<span class="autofit-col">
			<aui:input name="apiUrl" label="API URL" type="text" value="<%=learnConfigurationDisplayContext.getApiUrl()%>">
			</aui:input>
		</span>
	</div>

	<h6 class="sheet-subtitle">Site</h6>
	<div class="form-group">
		<span class="autofit-col">
			<aui:select cssClass="group" label="Site" name="group" value="<%=learnConfigurationDisplayContext.getGroup()%>">
				<aui:option selected="true"></aui:option>
				<c:forEach var="group"
					items="<%=learnConfigurationDisplayContext.get_groups()%>">
					<aui:option value="${group.getGroupId()}">${group.getName(locale)}</aui:option>
					<aui:validator name="required" errorMessage="O campo Site é obrigatório." />
				</c:forEach>
			</aui:select>
		</span>
	</div>
</div>	
