package dao;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entidades.Preinscripciones;
import utils.HibernateUtils;

public class PreinscripcionesDAO {

	public static void insert(Preinscripciones p) {
		try(Session sesion = HibernateUtils.getSessionFactory().openSession()) {
			Transaction tr = sesion.beginTransaction();
			sesion.save(p);
			tr.commit();
		}
	}
	public static void delete(Preinscripciones p) throws Exception {

		Transaction tr = null;
		try (Session sesion = HibernateUtils.getSessionFactory().openSession();) {
			tr = sesion.beginTransaction();
			sesion.delete(p);
			tr.commit();
		}

	}
	public static void update(Preinscripciones p) throws Exception {
		Transaction tr = null;
		try (Session sesion = HibernateUtils.getSessionFactory().openSession();) {
			tr = sesion.beginTransaction();
			sesion.update(p);
			tr.commit();
		}
	}

	public static Preinscripciones select(Preinscripciones p) throws Exception {

		Transaction tr = null;
		Preinscripciones preinsc=null;
		try (Session sesion = HibernateUtils.getSessionFactory().openSession();) {
			tr = sesion.beginTransaction();
			//Get permite recuperar el registro de inmediato y recoge null si no existe 
			preinsc=sesion.get(Preinscripciones.class,p.getDni());
			tr.commit();
			return preinsc;
		}

	}
	
	public static List<Preinscripciones> getAll() {
		try(Session sesion = HibernateUtils.getSessionFactory().openSession()) {
			Transaction tr = sesion.beginTransaction();
			CriteriaQuery<Preinscripciones> consulta = sesion.getCriteriaBuilder().createQuery(Preinscripciones.class);
			consulta.from(Preinscripciones.class);
			List<Preinscripciones> listaPreinsc = sesion.createQuery(consulta).getResultList();
			tr.commit();
			return listaPreinsc;
		}
	}
	
}
