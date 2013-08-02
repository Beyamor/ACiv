package GameElements;

import AbstractMatter.Unit;
import AbstractMatter.Terrain;
import AbstractMatter.Road;
import AbstractMatter.River;
import AbstractMatter.Resource;
import AbstractMatter.City;
import AbstractMatter.Extractor;
import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class AbstractMatterList  implements Serializable {
    private List<AbstractMatter> list;

    //Order of the possible elements:
    //  Terrain
    //  River
    //  Road
    //  Resource
    //  Extractor
    //  City
    //  Unit

    public AbstractMatterList() {
        list = new LinkedList();
    }

    public void add(Unit unit){
        list.add(unit);
        this.sort();
    }

    public void add(City city){
        list.add(city);
        this.sort();
    }

    public void add(Extractor extractor){
        list.add(extractor);
        this.sort();
    }

    public void add(Resource resource){
        list.add(resource);
        this.sort();
    }

    public void add(Road road){
        list.add(road);
        this.sort();
    }

    public void add(River river){
        list.add(river);
        this.sort();
    }
    
    public void add(Terrain element){
        list.add(element);
        this.sort();
    }

    //sort the list
    public void sort(){
        Collections.sort(list, new AbstractMatterComparator());
        return;
    }

    public List<AbstractMatter> getAbstractMatterList()
    {
        return this.list;
    }

    public AbstractMatter get(Class c){
        for(AbstractMatter e : list)
        {
            if(e.getClass().getSuperclass() == c)
            {
                return e;
            }
        }
        return null;
    }

    public boolean has(Class cl)
    {
        boolean has = false;

        for(AbstractMatter e : list)
        {
            if(e.getClass().getSuperclass() == cl)
            {
                has = true;
            }
        }
        return has;
    }

    void remove(Class c)
    {
        AbstractMatter temp = null; //use a temporary pointer to
                                    //avoid concurrency issues with list stuff

        for(AbstractMatter e : list)
        {
            if(e.getClass().getSuperclass() == c)
            {
                temp = e;           //set temp to refernce the thing
            }                       //to be deleted
        }

        if(temp != null){
            list.remove(temp);      //delete it
        }

    }

    void remove(AbstractMatter abstractMatter) {
        list.remove(abstractMatter);
    }

}
