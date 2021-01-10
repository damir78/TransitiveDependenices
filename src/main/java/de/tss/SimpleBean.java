package de.tss;

import java.util.HashSet;
import java.util.Set;

public class SimpleBean {
    private final String id;
    private final SimpleBean[] dependedBeans;

    public SimpleBean(String id, SimpleBean... dependedBeans) {
        this.id = id;
        this.dependedBeans = dependedBeans;
    }

    public Set<String> usedDependencies() {
        final Set<String> result = new HashSet<>();
        if (dependedBeans != null && dependedBeans.length > 0) {
            for (SimpleBean dependedBean : dependedBeans) {
                result.add(dependedBean.id);
                result.addAll(dependedBean.usedDependencies());
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return id + " " + usedDependencies();
    }
}