package com.safeseatai.safeseat_ai.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SafetyStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentId;
    private Long busId;

    private boolean childPresent;
    private boolean doorOpen;
    private boolean routeCompleted;
    private boolean leftBehind;
    private boolean alertSent;

    public SafetyStatus() {
    }

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the studentId
	 */
	public Long getStudentId() {
		return studentId;
	}

	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	/**
	 * @return the busId
	 */
	public Long getBusId() {
		return busId;
	}

	/**
	 * @param busId the busId to set
	 */
	public void setBusId(Long busId) {
		this.busId = busId;
	}

	/**
	 * @return the childPresent
	 */
	public boolean isChildPresent() {
		return childPresent;
	}

	/**
	 * @param childPresent the childPresent to set
	 */
	public void setChildPresent(boolean childPresent) {
		this.childPresent = childPresent;
	}

	/**
	 * @return the doorOpen
	 */
	public boolean isDoorOpen() {
		return doorOpen;
	}

	/**
	 * @param doorOpen the doorOpen to set
	 */
	public void setDoorOpen(boolean doorOpen) {
		this.doorOpen = doorOpen;
	}

	/**
	 * @return the routeCompleted
	 */
	public boolean isRouteCompleted() {
		return routeCompleted;
	}

	/**
	 * @param routeCompleted the routeCompleted to set
	 */
	public void setRouteCompleted(boolean routeCompleted) {
		this.routeCompleted = routeCompleted;
	}

	/**
	 * @return the leftBehind
	 */
	public boolean isLeftBehind() {
		return leftBehind;
	}

	/**
	 * @param leftBehind the leftBehind to set
	 */
	public void setLeftBehind(boolean leftBehind) {
		this.leftBehind = leftBehind;
	}

	/**
	 * @return the alertSent
	 */
	public boolean isAlertSent() {
		return alertSent;
	}

	/**
	 * @param alertSent the alertSent to set
	 */
	public void setAlertSent(boolean alertSent) {
		this.alertSent = alertSent;
	}

}
