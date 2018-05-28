package pe.edu.upc.util;

import java.util.ArrayList;
import java.util.List;

public class ComboBuilder {
	//TODO: Llenar fields select-option: ciudad origen y destino, aviones
	
	public static List<String> ciudadesDisponibles(){
		List<String> ciudades = new ArrayList<>();
		ciudades.add("Arequipa");
		ciudades.add("Ayacucho");
		ciudades.add("Cajamarca");
		ciudades.add("Chiclayo");
		ciudades.add("Cuzco");
		ciudades.add("Ilo");
		ciudades.add("Iquitos");
		ciudades.add("Juliaca");
		ciudades.add("Lima");
		ciudades.add("Piura");
		ciudades.add("Pucallpa");
		ciudades.add("Puerto Maldonado");
		ciudades.add("Rioja");
		ciudades.add("Tacna");
		ciudades.add("Talara");
		ciudades.add("Tarapoto");
		ciudades.add("Trujillo");
		ciudades.add("Tumbes");
		ciudades.add("Yurimaguas");
		return ciudades;
	}
	
	public static List<String> avionesDisponibles(){
		List<String> aviones = new ArrayList<>();
		aviones.add("Boeing B40");
		aviones.add("Boeing B80");
		aviones.add("Boeing 221 Monomail");
		aviones.add("Boeing 247");
		aviones.add("Boeing 307");
		aviones.add("Boeing 314 Clipper");
		aviones.add("Boeing 717");
		aviones.add("Boeing 757");
		aviones.add("Boeing 787 Dreamliner");
		aviones.add("Boeing 7J7");
		aviones.add("Airbus A300");
		aviones.add("Airbus A319");
		aviones.add("Airbus A330");
		aviones.add("Airbus A340");
		aviones.add("Airbus A380");
		return aviones;
	}
	
	public static List<String> paisesDisponibles(){
		List<String> paises = new ArrayList<>();
		paises.add("Peru");
		return paises;
	}
	
	public static List<String> tiposEstadia(){
		List<String> tiposDeEstadia = new ArrayList<>();
		tiposDeEstadia.add("Hotel");
		tiposDeEstadia.add("Hostal");
		tiposDeEstadia.add("Motel");
		tiposDeEstadia.add("Apart-Hotel");
		tiposDeEstadia.add("Apartment");
		tiposDeEstadia.add("Boutique Hotel");
		tiposDeEstadia.add("Resort");
		tiposDeEstadia.add("Lodge");
		tiposDeEstadia.add("Business Hotel");
		tiposDeEstadia.add("Pension");
		tiposDeEstadia.add("Eco Hotel");
		tiposDeEstadia.add("Love Hotel");
		return tiposDeEstadia;
	}
}
