package com.kuliah.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuliah.main.entity.Mahasiswa;
import com.kuliah.main.entity.PlotMataKuliah;
import com.kuliah.main.repository.PlotMataKuliahRepository;

@Service
public class ModelPlotMatakuliah implements ModelPlotMatakuliahInterface  {
	
	@Autowired
	PlotMataKuliahRepository plotmatakuliahRepo;

	 @Override
	    public List<PlotMataKuliah> getAllPlotMataKuliah() {
	        // TODO Auto-generated method stub
	        return (List<PlotMataKuliah>) this.plotmatakuliahRepo.findAll();
	    }

	    @Override
	    public PlotMataKuliah addPlotMataKuliah(PlotMataKuliah plotMatkul) {
	        // TODO Auto-generated method stub
	        return this.plotmatakuliahRepo.save(plotMatkul);
	    }

	    @Override
	    public PlotMataKuliah getPlotMataKuliahById(long id) {
	        // TODO Auto-generated method stub
	        return this.plotmatakuliahRepo.findById(id);
	    }

	    @Override
	    public void deletePlotMataKuliah(long id) {
	        // TODO Auto-generated method stub
	        this.plotmatakuliahRepo.deleteById(id);
	    }

}


