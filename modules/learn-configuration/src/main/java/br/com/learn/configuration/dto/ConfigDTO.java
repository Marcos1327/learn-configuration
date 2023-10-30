package br.com.learn.configuration.dto;

public class ConfigDTO {
	
	private String group;
	private String book;

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "ConfigDTO [group=" + group + ", book=" + book + "]";
	}

	
	

}
