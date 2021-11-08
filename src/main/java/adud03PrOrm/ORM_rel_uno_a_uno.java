package adud03PrOrm;

import java.math.BigDecimal;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ORM.Empleadodatosprof;

public class ORM_rel_uno_a_uno {
	public static void main(String[] args) {

		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			Transaction t = null;

			try {
				t = s.beginTransaction();

				ORM.Departamento depto = s.get(ORM.Departamento.class, 1);

				ORM.Empleado emp = new ORM.Empleado();
				emp.setDni("76543210S");
				emp.setDepartamento(depto);
				emp.setNomEmp("SILVA");
				s.save(emp);

				Empleadodatosprof datosProf = new Empleadodatosprof();
				datosProf.setEmpleado(emp);
				datosProf.setCategoria("A");
				datosProf.setSueldoBrutoAnual(new BigDecimal(52000.0));
				s.save(datosProf);

				t.commit();

				s.refresh(emp);
				System.out.println("Categoría del nuevo empleado: " + emp.getEmpleadodatosprof().getCategoria()
						+ ", DNI: " + emp.getEmpleadodatosprof().getDni());

			} catch (Exception e) {
				e.printStackTrace(System.err);
				if (t != null) {
					t.rollback();
				}
			}
		}
	}

}
