package batch.domain;

import java.io.Serializable;

public class SourcePageFilter implements Serializable{

	private String id;
	private String sourcePageId;
	private String filter;
	private String param1;
	private String param2;
	private String refNode;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSourcePageId() {
		return sourcePageId;
	}
	public void setSourcePageId(String sourcePageId) {
		this.sourcePageId = sourcePageId;
	}
	public String getFilter() {
		return filter;
	}
	public void setFilter(String filter) {
		this.filter = filter;
	}
	public String getParam1() {
		return param1;
	}
	public void setParam1(String param1) {
		this.param1 = param1;
	}
	public String getParam2() {
		return param2;
	}
	public void setParam2(String param2) {
		this.param2 = param2;
	}
	public String getRefNode() {
		return refNode;
	}
	public void setRefNode(String refNode) {
		this.refNode = refNode;
	}

	
	
}
