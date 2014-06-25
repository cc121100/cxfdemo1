package batch.domain;

import java.io.Serializable;
import java.util.List;


public class SourcePage implements Serializable{

	
	private String id;
	private String name;
	private String url;
	private String filterType;
	private String isCombooFilter;
	private String sourcePageFilterString;
	private List<SourcePageFilter> sourcePageFilters;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getFilterType() {
		return filterType;
	}
	public void setFilterType(String filterType) {
		this.filterType = filterType;
	}
	public String getIsCombooFilter() {
		return isCombooFilter;
	}
	public void setIsCombooFilter(String isCombooFilter) {
		this.isCombooFilter = isCombooFilter;
	}
	public String getSourcePageFilterString() {
		return sourcePageFilterString;
	}
	public void setSourcePageFilterString(String sourcePageFilterString) {
		this.sourcePageFilterString = sourcePageFilterString;
	}
	public List<SourcePageFilter> getSourcePageFilters() {
		return sourcePageFilters;
	}
	public void setSourcePageFilters(List<SourcePageFilter> sourcePageFilters) {
		this.sourcePageFilters = sourcePageFilters;
	}
	
	@Override
	public String toString() {
		return "SourcePage [id=" + id + ", name=" + name + ", url=" + url
				+ ", filterType=" + filterType + ", isCombooFilter="
				+ isCombooFilter + ", sourcePageFilterString="
				+ sourcePageFilterString + ", sourcePageFilters="
				+ sourcePageFilters + "]";
	}
	
	
	
}
