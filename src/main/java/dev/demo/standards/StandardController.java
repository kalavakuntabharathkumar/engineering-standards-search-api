package dev.demo.standards;
import java.util.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
@RestController @RequestMapping("/api/standards")
public class StandardController {
 private final StandardRepository repo;
 public StandardController(StandardRepository repo){this.repo=repo;}
 @GetMapping public List<Standard> list(){return repo.findAll();}
 @GetMapping("/search") public List<Standard> search(@RequestParam(defaultValue="") String q){if(q.isBlank()) return repo.findAll(); return repo.search(q.trim());}
 @GetMapping("/{id}") public Standard get(@PathVariable Long id){return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Standard not found"));}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Standard create(@RequestBody Standard input){if(input.getCode()==null||input.getCode().isBlank()||input.getTitle()==null||input.getTitle().isBlank()||input.getBody()==null||input.getVersion()==null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"code, title, body and version are required"); if(repo.findByCode(input.getCode()).isPresent()) throw new ResponseStatusException(HttpStatus.CONFLICT,"code already exists"); return repo.save(input);}
 @PutMapping("/{id}") public Standard update(@PathVariable Long id,@RequestBody Standard input){Standard s=get(id);s.setTitle(input.getTitle());s.setBody(input.getBody());s.setVersion(input.getVersion());return repo.save(s);}
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){if(!repo.existsById(id))throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Standard not found");repo.deleteById(id);}
 @GetMapping("/health") public Map<String,String> health(){return Map.of("status","UP");}
 @GetMapping("/meta") public Map<String,String> metadata(){return Map.of("service","engineering-standards-api","apiVersion","v1");}
}
