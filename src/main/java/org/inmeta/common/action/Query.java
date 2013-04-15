package org.inmeta.common.action;

import java.util.List;

/**
 * Interface defining a query.
 * @param <S> The type of search manager. For instance EntityManager or Compass
 * @param <R> The type of results
 *
 * @author Alexander Vaagan
 */
public interface Query<S, R> {

    /**
     * Find objects of type <R> using source <S>.
     * @param manager The manager
     * @return the result
     */
    List<R> find(S manager);
}
