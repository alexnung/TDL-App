package com.qa.tdl.TDLWA.data.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Tasks {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	private String task;

	@NotNull
	private String dueDate;

	@NotNull
	private String status;

	@NotNull
	private String completedOnTime;

	@ManyToOne(targetEntity = People.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_people_id")
	private People people;

	public Tasks() {
	}

	public Tasks(String task, String dueDate, String status, String completedOnTime) {
		super();
		this.task = task;
		this.dueDate = dueDate;
		this.status = status;
		this.completedOnTime = completedOnTime;
	}

	public Tasks(Integer id, String task, String dueDate, String status, String completedOnTime) {
		super();
		this.id = id;
		this.task = task;
		this.dueDate = dueDate;
		this.status = status;
		this.completedOnTime = completedOnTime;
	}

	public Tasks(Integer id, String task, String dueDate, String status, String completedOnTime, People people) {
		super();
		this.id = id;
		this.task = task;
		this.dueDate = dueDate;
		this.status = status;
		this.completedOnTime = completedOnTime;
		this.people = people;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCompletedOnTime() {
		return completedOnTime;
	}

	public void setCompletedOnTime(String completedOnTime) {
		this.completedOnTime = completedOnTime;
	}

	public People getPeople() {
		return people;
	}

	public void setPeople(People people) {
		this.people = people;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", task=" + task + ", dueDate=" + dueDate + ", status=" + status
				+ ", completedOnTime=" + completedOnTime + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((completedOnTime == null) ? 0 : completedOnTime.hashCode());
		result = prime * result + ((dueDate == null) ? 0 : dueDate.hashCode());
		result = prime * result + ((people == null) ? 0 : people.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((task == null) ? 0 : task.hashCode());
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
		Tasks other = (Tasks) obj;
		if (completedOnTime == null) {
			if (other.completedOnTime != null)
				return false;
		} else if (!completedOnTime.equals(other.completedOnTime))
			return false;
		if (dueDate == null) {
			if (other.dueDate != null)
				return false;
		} else if (!dueDate.equals(other.dueDate))
			return false;
		if (people == null) {
			if (other.people != null)
				return false;
		} else if (!people.equals(other.people))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (task == null) {
			if (other.task != null)
				return false;
		} else if (!task.equals(other.task))
			return false;
		return true;
	}

}
