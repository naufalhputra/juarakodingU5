package com.kuliah.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.kuliah.main.entity.PlotMataKuliah;
import com.kuliah.main.services.ModelDosen;
import com.kuliah.main.services.ModelMahasiswa;
import com.kuliah.main.services.ModelMataKuliah;
import com.kuliah.main.services.ModelPlotMatakuliah;
import com.kuliah.main.services.ModelSoal;

@Controller
public class PlotMataKuliahPage {

	@Autowired
	ModelDosen modelDosen;
	
	@Autowired
	ModelMahasiswa modelMahasiswa;

	@Autowired
	ModelMataKuliah modelMataKuliah;
	
	@Autowired
	ModelPlotMatakuliah modelPlotMataKuliah;

	@Autowired
	ModelSoal modelSoal;

	@GetMapping("/plotmatakuliah/view")
	public String viewIndexplotmatakuliah(Model model) {
		
		model.addAttribute("listPlotMatakuliah",modelPlotMataKuliah.getAllPlotMataKuliah());
		model.addAttribute("active",6);
		return "view_plotmatakuliah";
	}
	
	
	@GetMapping("/plotmatakuliah/add")
	public String viewAddplotmatakuliah(Model model) {
		
		model.addAttribute("plotmatakuliah",new PlotMataKuliah());
		model.addAttribute("listDosen", modelDosen.getAllDosen());
		model.addAttribute("listMahasiswa", modelMahasiswa.getAllMahasiswa());
		model.addAttribute("listMataKuliah", modelMataKuliah.getAllMataKuliah());
		model.addAttribute("listSoal", modelSoal.getAllSoal());
		
		return "add_plotmatakuliah";
	}
	
	@PostMapping("/plotmatakuliah/view")
	  public String addplotmatakuliah(@ModelAttribute PlotMataKuliah plotmatakuliah, Model model) {
		
		this.modelPlotMataKuliah.addPlotMataKuliah(plotmatakuliah);
		model.addAttribute("listPlotMatakuliah",modelPlotMataKuliah.getAllPlotMataKuliah());
		
		return "redirect:/plotmatakuliah/view";
	}
	
	
	@GetMapping("/plotmatakuliah/update/{id}")
	public String viewUpdateplotmatakuliah(@PathVariable long id, Model model) {
		
		PlotMataKuliah plotmatakuliah = modelPlotMataKuliah.getPlotMataKuliahById(id);
		model.addAttribute("plotmatakuliah", plotmatakuliah);
		
		return "add_plotmatakuliah";
	}
	
	@GetMapping("/plotmatakuliah/delete/{id}")
	public String deleteplotmatakuliah(@PathVariable long id, Model model) {
		
		this.modelPlotMataKuliah.deletePlotMataKuliah(id);
		model.addAttribute("listPlotMatakuliah",modelMataKuliah.getAllMataKuliah());
		
		return "redirect:/plotmatakuliah/view";
	}

}