package weather.dto;

import java.util.List;

public class NowcastProperties {
	
	private List<Timeseries> timeseries;
	
	public List<Timeseries> getTimeseries() {
		return timeseries;
	}
	
	public void setTimeseries(List<Timeseries> timeseries) {
		this.timeseries = timeseries;
	}
}
