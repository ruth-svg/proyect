package ln;

import dao.PreinscripcionesDAO;
import entidades.Preinscripciones;


public class PreinscripcionesLN {

	public static String alta(Preinscripciones p) throws Exception {
		String mensaje = "";
		if(PreinscripcionesDAO.select(p) == null) {
			PreinscripcionesDAO.insert(p);
			mensaje = "La preinscripción se ha grabado correctamente";
		} else {
			mensaje = "La preinscripción ya ha sido grabada";
		}
		return mensaje;
	}
	
}
