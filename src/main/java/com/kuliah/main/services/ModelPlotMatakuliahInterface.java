package com.kuliah.main.services;

import java.util.List;

import com.kuliah.main.entity.PlotMataKuliah;

public interface ModelPlotMatakuliahInterface {
	
public List<PlotMataKuliah> getAllPlotMataKuliah();
	
	public PlotMataKuliah addPlotMataKuliah (PlotMataKuliah plotmatakuliah);
	public PlotMataKuliah getPlotMataKuliahById(long id);
	public void deletePlotMataKuliah (long id);

}
