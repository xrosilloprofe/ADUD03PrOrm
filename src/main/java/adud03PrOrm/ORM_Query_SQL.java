package adud03PrOrm;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;

public class ORM_Query_SQL {

	public static void main(String[] args) {

		Session s = HibernateUtil.getSessionFactory().openSession();

		try {
			List<Object[]> empleados = s.createNativeQuery(
					"SELECT e.dni, e.idDepto, e.nomEmp, dp.categoria FROM empleado e LEFT OUTER JOIN empleadodatosprof dp ON dp.dni=e.dni")
					.addScalar("dni", StringType.INSTANCE).addScalar("idDepto", IntegerType.INSTANCE)
					.addScalar("nomEmp", StringType.INSTANCE).addScalar("categoria", StringType.INSTANCE).list();
			for (Object[] objetos : empleados) {
				System.out.println("Empleado [dni:" + (String) objetos[0] + ", idDepto: " + (Integer) objetos[1]
						+ ", nomEmp: " + (String) objetos[2] + ", categoria: " + (String) objetos[3] + "]");
			}

		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}
}
