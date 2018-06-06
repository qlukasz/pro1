package pl.serwis.db;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pl.serwis.Spittle;

import java.util.List;

public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);
}