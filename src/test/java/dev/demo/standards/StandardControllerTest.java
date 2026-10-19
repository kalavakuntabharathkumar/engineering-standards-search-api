package dev.demo.standards;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;
import java.util.*;
import org.junit.jupiter.api.Test;
import org.springframework.web.server.ResponseStatusException;
class StandardControllerTest {
 @Test void searchDelegatesToRepository(){StandardRepository repo=mock(StandardRepository.class); StandardController c=new StandardController(repo); when(repo.search("safety")).thenReturn(List.of(new Standard("ENG-1","Safety","Body","1.0"))); assertThat(c.search(" safety ")).hasSize(1); verify(repo).search("safety");}
 @Test void missingRecordReturnsNotFound(){StandardRepository repo=mock(StandardRepository.class);when(repo.findById(99L)).thenReturn(Optional.empty());StandardController c=new StandardController(repo);assertThatThrownBy(()->c.get(99L)).isInstanceOf(ResponseStatusException.class);}
}
