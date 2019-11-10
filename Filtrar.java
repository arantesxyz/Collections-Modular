import java.util.List;
import java.util.stream.Collectors;

public class Filtrar {
    private List<Monitor> monitores;

    Filtrar(List<Monitor> monitores){
        this.monitores = monitores;
    }

    public List<Monitor> name(String name) {
        return monitores.stream().filter(monitor -> monitor.getNome().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());
    }

    public List<Monitor> materia(String materia) {
        return monitores.stream().filter(monitor -> monitor.getMateria().toLowerCase().contains(materia.toLowerCase())).collect(Collectors.toList());
    }

    public List<Monitor> horario(String horario) {
        return monitores.stream().filter(monitor -> monitor.getHorario().toLowerCase().contains(horario.toLowerCase())).collect(Collectors.toList());
    }

    public List<Monitor> matricula(int matricula) {
        return monitores.stream().filter(monitor -> monitor.getMatricula() == matricula).collect(Collectors.toList());
    }
}
