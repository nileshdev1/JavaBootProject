package org.nk.controller;

import java.util.List;
import java.util.Optional;

import org.nk.model.ShipmentType;
import org.nk.service.IShipmentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * @Class:  Controller
 * @Author:  Nil
 * @Version: 1.0
 * @ShipmentType
 */

@Controller
@RequestMapping("/shipment")
public class ShipmentTypeController {

	@Autowired
	private IShipmentTypeService service;
	
	/*
	 * Find the RegistrationForm to Generate ShipmentType
	 */
	@GetMapping("/register")
	public String showRegister(Model model) {
		model.addAttribute("shipmentType", new ShipmentType());
		return "ShipmentRegister";
	}
	
	/*
	 * Take Data from form and save into DB
	 */
	@PostMapping("/save")
	public String saveShipment(@ModelAttribute ShipmentType shipmentType, Model model) {
		Integer id=service.saveShipment(shipmentType);
		String message="Shipment id "+id+" created";
		model.addAttribute("msg", message);
		model.addAttribute("shipmentType", new ShipmentType());
		return "ShipmentRegister";
	}
	
	/*
	 * Find the All ShipmentType Data
	 */
	@GetMapping("/all")
	public String getAllShipment(Model model) {	
		List<ShipmentType> list=service.getAllShipment();
		model.addAttribute("list", list);
		return "ShipmentData";
	}
	
	/*
	 * Remove the one selected ShipmentType
	 * And Return back to All Data Page
	 */
	@GetMapping("/delete/{id}")
	public String deleteShipment(@PathVariable Integer id, Model model) {	
		service.deleteShipment(id);
		String message="Shipment "+id+" Deleted";
		model.addAttribute("msg", message);
		
		List<ShipmentType> list=service.getAllShipment();
		model.addAttribute("list", list);
		return "ShipmentData";
	}
	
	/*
	 *Link to Modify Page of ShipmentType Data
	 */
	@GetMapping("/edit/{id}")
	public String showEdit(@PathVariable Integer id, Model model) {
		Optional<ShipmentType> ship=service.getOneShipment(id);
		model.addAttribute("shipment", ship);
		return "ShipmentEdit";
	}
	
	/*
	 * Modify ShipmentType Data 
	 */
	@PostMapping("/update")
	public String updatePage(@ModelAttribute ShipmentType shipment, Model model) {
		service.saveShipment(shipment);
		List<ShipmentType> list=service.getAllShipment();
		model.addAttribute("list", list);
		return "ShipmentData";
	}
	
	/*
	 * View All Data to selected ID
	 */
	@GetMapping("/view/{id}")
	public String showView(@PathVariable Integer id, Model model) {
		Optional<ShipmentType> ship=service.getOneShipment(id);
		ShipmentType ship1=ship.get();
		model.addAttribute("ship", ship1);
		return "ShipmentView";
	}
	
}
