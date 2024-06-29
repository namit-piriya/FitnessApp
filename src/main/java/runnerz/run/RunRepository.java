package runnerz.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RunRepository {
    private List<Run> runs  = new ArrayList<>();

    public List<Run> findAll(){
        return runs;
    }

    public List<Run>create(Run run){
        runs.add(new Run(run.id(),run.name(), run.description()));
        return runs;
    }

    public Optional<Run> findById(Integer id){
        return runs.stream().filter(run -> run.id().equals(id)).findFirst();
    }

    public void update(int id, Run newRun){
        Optional<Run> r = findById(id);
        r.ifPresent(run -> runs.set(runs.indexOf(run), newRun));
    }

    public void deleteById(Integer id){
        runs.removeIf(run -> run.id().equals(id));
    }

    @PostConstruct
    public void init(){
        runs.add(new Run(
                1,
                "Run 1 ",
                "Run 1 description"
        ));
        runs.add(new Run(
                2,
                "Run 2 ",
                "Run 2 description"
        ));
    }
}
