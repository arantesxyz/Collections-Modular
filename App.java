import java.io.File;
import java.util.List;

public class App {

	public static void main(String[] args) {

		File f = new File("BancoDeDados.txt");
		if (f.exists())
			f.delete();
		
		MonitorDAO monitorDAO = new MonitorDAO();
		
		monitorDAO.add(new Monitor("Guilherme","Modular","13:00 - 17:00",637595));
		monitorDAO.add(new Monitor("Leonardo","Calculo","13:00 - 18:00",665720));
		monitorDAO.add(new Monitor("Matheus","AED I","13:00 - 17:00",650695));
		monitorDAO.add(new Monitor("Guilherme OA","DIW","13:00 - 15:00",689290));
		monitorDAO.add(new Monitor("Gabriel","AED I ","14:00 - 17:00",647856));
		monitorDAO.add(new Monitor("Camila","AED I","15:00 - 18:00",635698));
		
		
		monitorDAO.update(new Monitor("Gabriel","AED I ","13:30 - 17:30",647856));
		monitorDAO.remove(new Monitor("Camila","AED I","15:00 - 18:00",635698));
			
		List<Monitor> monitores = monitorDAO.getAll();

		Filtrar filtrar = new Filtrar(monitores);

		System.out.println("\nFiltro por nome 'Guilherme'");
		filtrar.name("Guilherme").forEach(System.out::println);

		System.out.println("\nFiltro por materia 'AED'");
		filtrar.materia("aed").forEach(System.out::println);

		System.out.println("\nFiltro por horario '13'");
		filtrar.horario("13").forEach(System.out::println);

		System.out.println("\nFiltro por matricula '689290'");
		filtrar.matricula(689290).forEach(System.out::println);


		System.out.println("\nTodos:");
		monitores.forEach(System.out::println);
	}
}
