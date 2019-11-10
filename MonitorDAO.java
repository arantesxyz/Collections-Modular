
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;


public class MonitorDAO {

	public MonitorDAO() {

	}

	public void add(Monitor m) {
		try (DataOutputStream saida = new DataOutputStream(new FileOutputStream("BancoDeDados.txt", true))) {
			saida.writeUTF(m.getNome());
			saida.writeUTF(m.getMateria());
			saida.writeUTF(m.getHorario());
			saida.writeInt(m.getMatricula());
			saida.flush();

		} catch (Exception e) {
			System.out.println("ERRO ao gravar o monitor'" + m.getNome() + "' no disco!");
			e.printStackTrace();
		}
	}

	public Monitor get(String chave) {
		Monitor retorno = null;
		String idSTR = null;

		try (DataInputStream entrada = new DataInputStream(new FileInputStream("BancoDeDados.txt"))) {
			while ((idSTR = entrada.readUTF()) != null) {
				if (chave.equals(idSTR)) {
					retorno = new Monitor(idSTR, entrada.readUTF(), entrada.readUTF(), entrada.readInt());
					break;
				}

				entrada.readUTF();
				entrada.readUTF();
				entrada.readInt();

			}
		} catch (Exception e) {
			System.out.println("ERRO ao ler o Monitor '" + chave + "' do disco!");
			e.printStackTrace();
		}
		return retorno;
	}

	public List<Monitor> getAll() {
		List<Monitor> monitores = new ArrayList<Monitor>();
		Monitor monitor = null;
		String idSTR = null;

		try (DataInputStream entrada = new DataInputStream(new FileInputStream("BancoDeDados.txt"))) {
			while ((idSTR = entrada.readUTF()) != null) {
				monitor = new Monitor(idSTR, entrada.readUTF(), entrada.readUTF(), entrada.readInt());
				monitores.add(monitor);
			}
		} catch (Exception e) {
			System.out.println("ERRO ao ler o monitor '" + idSTR + "' do disco!");
			e.printStackTrace();
		}
		return monitores;
	}
	
	public void update(Monitor m) {
		List<Monitor> monitores = getAll();

		int index = IntStream.range(0, monitores.size())
				.filter(i -> m.getMatricula() == monitores.get(i).getMatricula())
				.findFirst()
				.orElse(-1);

		if (index != -1) {
			monitores.set(index,m);
		}
		saveToFile(monitores);
	}

	public void remove(Monitor m) {
		List<Monitor> monitores = getAll();

		int index = IntStream.range(0, monitores.size())
				.filter(i -> m.getMatricula() == monitores.get(i).getMatricula())
				.findFirst()
				.orElse(-1);

		if (index != -1) {
			monitores.remove(index);
		}
		saveToFile(monitores);
	}
	
	private void saveToFile(List<Monitor> monitores) {
		try (DataOutputStream saida = new DataOutputStream(new FileOutputStream("BancoDeDados.txt", false))) {

			monitores.forEach(m -> {
				try {
					saida.writeUTF(m.getNome());
					saida.writeUTF(m.getMateria());
					saida.writeUTF(m.getHorario());
					saida.writeInt(m.getMatricula());
					saida.flush();
				} catch (IOException e) {
					System.out.println("ERRO ao escrever Monitores no disco!");
					e.printStackTrace();
				}
			});

		} catch (Exception e) {
			System.out.println("ERRO ao gravar Monitores no disco!");
			e.printStackTrace();
		}
	}
}
