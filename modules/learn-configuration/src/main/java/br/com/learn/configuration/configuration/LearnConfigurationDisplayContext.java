package br.com.learn.configuration.configuration;

import com.liferay.portal.kernel.model.Group;

import java.util.ArrayList;
import java.util.List;

import br.com.learn.configuration.dto.ConfigDTO;

public class LearnConfigurationDisplayContext {
	
	private String apiUrl;
	private String groupId;
	private List<Group> _groups;
	private String[] fields;
	private String bookId;
	
	public LearnConfigurationDisplayContext() {
	
	}
	
	public String getApiUrl() {
		return apiUrl;
	}
	public void setApiUrl(String apiUrl) {
		this.apiUrl = apiUrl;
	}
	public String getGroup() {
		return groupId;
	}

	public void setGroup(String group) {
		this.groupId = group;
	}

	public List<Group> get_groups() {
		return _groups;
	}
	public void set_groups(List<Group> _groups) {
		this._groups = _groups;
	}

	public String[] getFields() {
		return fields;
	}

	public void setFields(String[] fields) {
		this.fields = fields;
	}
	
	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public List<ConfigDTO> getFieldsValues() {

		List<ConfigDTO> configDTOList = new ArrayList<>();

		for (String field : fields) {
			String[] split = field.split(",");

			ConfigDTO configDTO = new ConfigDTO();

			if (split.length > 0) {
				configDTO.setGroup(split[0]);
			} else {
				configDTO.setGroup("");
			}
			
			if (split.length > 1) {
				configDTO.setBook(split[1]);
			} else {
				configDTO.setBook("");
			}
			
			configDTOList.add(configDTO);
		}

		return configDTOList;
	}
            

}
