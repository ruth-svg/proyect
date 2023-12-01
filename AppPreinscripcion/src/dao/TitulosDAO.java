package dao;


import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import entidades.Titulos;
import utils.HibernateUtils;

public class TitulosDAO {

	public static List<Titulos> getAll() {
		try(Session sesion = HibernateUtils.getSessionFactory().openSession()) {
			Transaction tr = sesion.beginTransaction();
			CriteriaQuery<Titulos> consulta = sesion.getCriteriaBuilder().createQuery(Titulos.class);
			consulta.from(Titulos.class);
			List<Titulos> listaTit =  sesion.createQuery(consulta).getResultList();
			tr.commit();
			return listaTit;
		}
	}
	
	public static Titulos select(Titulos t) throws Exception {

		Transaction tr = null;
		Titulos tit=null;
		try (Session sesion = HibernateUtils.getSessionFactory().openSession();) {
			tr = sesion.beginTransaction();
			//Get permite recuperar el registro de inmediato y recoge null si no existe 
			tit=sesion.get(Titulos.class,t.getCodtitulo());
			tr.commit();
			return tit;
		}

	}
	
	
}
