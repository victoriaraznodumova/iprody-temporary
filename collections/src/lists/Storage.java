package lists;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Storage implements Iterable<String>{
    private List<String> relatedNames;
    private String name;

    public Storage(List<String> relatedNames, String name) {
        this.relatedNames = relatedNames;
        this.name = name;
    }

    public List<String> getRelatedNames() {
        return relatedNames;
    }

    public void setRelatedNames(List<String> relatedNames) {
        this.relatedNames = relatedNames;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private Iterator<String> relatedNamesIterator = relatedNames.iterator();
            private boolean relatedNamesEnded = false;

            @Override
            public boolean hasNext() {
                return relatedNamesIterator.hasNext() || !relatedNamesEnded;
            }

            @Override
            public String next() {
                if (relatedNamesEnded)
                    throw new NoSuchElementException();
                if (relatedNamesIterator.hasNext())
                    return relatedNamesIterator.next();
                relatedNamesEnded = true;
                return name;
            }
        };
    }
}
