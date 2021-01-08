package de.tss;

import java.util.HashSet;
import java.util.Set;

public class SimpleBean {
    private String id;
    private SimpleBean[] dependedBeans;


    public SimpleBean(String id, SimpleBean... dependedBeans) {
        this.id = id;
        this.dependedBeans = dependedBeans;
    }

    public Set<String> usedAsExternalDependencies() {
        final Set<String> result = usedDependencies();
        result.add(id);
        return result;
    }

    public Set<String> usedDependencies() {
        final Set<String> result = new HashSet<>();
        if (dependedBeans != null && dependedBeans.length > 0) {
            for (SimpleBean dependedBean : dependedBeans) {
                result.addAll(dependedBean.usedAsExternalDependencies());
            }
        }
        return result;
    }
    @Override
    public String toString() { return id + " " + usedDependencies(); }
}