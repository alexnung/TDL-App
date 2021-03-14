package com.qa.tdl.TDLWA.dto;

import java.util.List;

public class PeopleDTO {

	private int id;

	private String name;

	private String title;

	private List<TasksDTO> tasks;

	public PeopleDTO() {
	}

	public PeopleDTO(int id, String name, String title, List<TasksDTO> tasks) {
		super();
		this.id = id;
		this.name = name;
		this.title = title;
		this.tasks = tasks;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<TasksDTO> getTasks() {
		return tasks;
	}

	public void setTasks(List<TasksDTO> tasks) {
		this.tasks = tasks;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((tasks == null) ? 0 : tasks.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PeopleDTO other = (PeopleDTO) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (tasks == null) {
			if (other.tasks != null)
				return false;
		} else if (!tasks.equals(other.tasks))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PeopleDTO [id=" + id + ", name=" + name + ", title=" + title + ", tasks=" + tasks + "]";
	}

}
