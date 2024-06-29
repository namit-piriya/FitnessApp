package runnerz.run;
import java.util.List;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/runs")
@RestController
public class RunController {

    private final RunRepository runRepository;

    public RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    @GetMapping("")
    public List<Run> getRuns() {
        return this.runRepository.findAll();
    }

    @GetMapping("/{id}")
    public Run getRun(@PathVariable Integer id){
        return this.runRepository.findById(id).orElse(null);
    }

    @PostMapping("")
    public List <Run> createRun(@RequestBody @Valid  Run run){
        return this.runRepository.create(run);
    }

    @PutMapping("/{id}")
    public void updateRun(@RequestBody @Valid Run run, @PathVariable Integer id ){
        this.runRepository.update(id, run);
    }

    @DeleteMapping("/{id}")
    public void deleteRun(@PathVariable @Valid Integer id){
        this.runRepository.deleteById(id);
    }

}
