package com.domain;

/**
 * 
 * @author MetadataLogDO Filling MetadataLog__c Object Data
 *
 */
public class TestMetadataLogDO {

	private String id;
	private String logName;
	private String name;
	private String script;
	private String action;
	private String status;
	private String idC;

	public TestMetadataLogDO(String id, String logName, String name,
			String script, String action, String status, String idC) {
		this.id = id;
		this.logName = logName;
		this.name = name;
		this.script = script;
		this.action = action;
		this.status = status;
		this.idC = idC;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getScript() {
		return script;
	}

	public void setScript(String script) {
		this.script = script;
	}

	public String getIdC() {
		return idC;
	}

	public void setIdC(String idC) {
		this.idC = idC;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLogName() {
		return logName;
	}

	public void setLogName(String logName) {
		this.logName = logName;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}