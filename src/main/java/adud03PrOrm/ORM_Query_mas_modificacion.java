package adud03PrOrm;

import java.util.List;
import java.util.Random;
import java.math.BigDecimal;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class ORM_Query_mas_modificacion {
	public static void main(String[] args) {

		Transaction t = null;
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {

			t = s.beginTransaction();

			Query q = s.createQuery("FROM Empleado");
			List<ORM.Empleado> listaEmp = (List<ORM.Empleado>) q.getResultList();
			Random rand = new Random();
			for (ORM.Empleado unEmp : listaEmp) {
				ORM.Empleadodatosprof datosProf = unEmp.getEmpleadodatosprof();
				if (datosProf == null) {
					datosProf = new ORM.Empleadodatosprof();
					datosProf.setEmpleado(unEmp);
					unEmp.setEmpleadodatosprof(datosProf);
				}
				datosProf.setCategoria("A");
				datosProf.setSueldoBrutoAnual(BigDecimal.valueOf(2000000 + rand.nextInt(6000000)).movePointLeft(2));
				s.saveOrUpdate(datosProf);
				s.update(unEmp);
			}

			t.commit();

		} catch (Exception e) {
			e.printStackTrace(System.err);
			if (t != null) {
				t.rollback();
			}
		}
	}
}
