package pl.serwis.db;

import org.springframework.stereotype.Controller;
import pl.serwis.Spittle;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SpittleRepositoryImpl implements SpittleRepository{
    public List<Spittle> findSpittles(long max, int count) {
        List<Spittle> list = new ArrayList<Spittle>();
        list.add(new Spittle("elo 1", Date.valueOf("2018-06-01")));
        list.add(new Spittle("elo 2", Date.valueOf("2018-06-02")));
        list.add(new Spittle("elo 3", Date.valueOf("2018-06-03")));
        return list;
    }
}
