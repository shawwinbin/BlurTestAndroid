package at.favre.app.blurbenchmark.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.File;
import java.util.Date;

/**
* Created by PatrickF on 16.04.2014.
*/
public class BenchmarkWrapper implements Comparable<BenchmarkWrapper> {
	private String bitmapPath;
	private String flippedBitmapPath;
	private StatInfo statInfo;
	private boolean additionalInfoVisibility = false;

	public BenchmarkWrapper() {
	}

	public BenchmarkWrapper(File bitmapFile, File flippedBitmapFile, StatInfo statInfo) {
		if(bitmapFile != null && flippedBitmapFile != null) {
			this.bitmapPath = bitmapFile.getAbsolutePath();
			this.flippedBitmapPath = flippedBitmapFile.getAbsolutePath();
		}
		this.statInfo = statInfo;

		if(bitmapPath == null) {
			statInfo.setError(true);
		}

	}

	public StatInfo getStatInfo() {
		return statInfo;
	}

	public String getBitmapPath() {
		return bitmapPath;
	}

	public void setBitmapPath(String bitmapPath) {
		this.bitmapPath = bitmapPath;
	}

	public void setStatInfo(StatInfo statInfo) {
		this.statInfo = statInfo;
	}

	public boolean isAdditionalInfoVisibility() {
		return additionalInfoVisibility;
	}

	public void setAdditionalInfoVisibility(boolean additionalInfoVisibility) {
		this.additionalInfoVisibility = additionalInfoVisibility;
	}

	public String getFlippedBitmapPath() {
		return flippedBitmapPath;
	}

	public void setFlippedBitmapPath(String flippedBitmapPath) {
		this.flippedBitmapPath = flippedBitmapPath;
	}

	@JsonIgnore
	public File getBitmapAsFile() {return new File(bitmapPath);}
	@JsonIgnore
	public File getFlippedBitmapAsFile() {return new File(flippedBitmapPath);}

    @Override
    public int compareTo(BenchmarkWrapper benchmarkWrapper) {
        return new Date(getStatInfo().getDate()).compareTo(new Date(benchmarkWrapper.getStatInfo().getDate())) * -1;
    }
}
