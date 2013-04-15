package org.inmeta.tasksystem.integrations;

import org.apache.commons.collections.CollectionUtils;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: alexanderv
 * Date: 16.02.13
 * Time: 14:36
 * To change this template use File | Settings | File Templates.
 */
public abstract class Provider {
    private long lastInvocation;
    private long threshold = 2000;

    protected String safeSelect(final Element doc, final String selector) {
        final Elements selected = doc.select(selector);
        if (CollectionUtils.isNotEmpty(selected)) {
            return selected.get(0).text();
        } else {
            return "";
        }
    }

    public List<Person> lookup(final String q) {
        lastInvocation = System.currentTimeMillis();
        return doLookup(q);

    }

    public abstract List<Person> doLookup(final String query);

    public boolean isReady() {
        long now = System.currentTimeMillis();
        return (now - lastInvocation) > 2000;
    }
}
