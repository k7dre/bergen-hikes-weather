package weather.model;

public enum Mountain {
	
	ULRIKEN("Ulriken", 60.377516, 5.38696),
	FLOYEN("Fløyen", 60.39844, 5.345820),
	LOVSTAKKEN("Løvstakken", 60.361111, 5.319167),
	DAMSGARDSFJELLET("Damsgårdsfjellet", 60.375833, 5.290833),
	LYDERHORN("Lyderhorn", 60.373611, 5.241944),
	SANDVIKSFJELLET("Sandviksfjellet", 60.409167, 5.340556),
	RUNDEMANNEN("Rundemannen", 60.413611, 5.367222);
	
	private final String displayName;
	private final double latitude;
	private final double longitude;
	
	Mountain(String displayName, double latitude, double longitude) {
		this.displayName = displayName;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getDisplayName() {
		return displayName;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}
	
	
	
}