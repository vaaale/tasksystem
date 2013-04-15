package org.inmeta.common.process;

/**
 * Abstract event.
 *
 * @param <T> The Enum defining the event codes
 * @author Alexander Vaagan
 */
public abstract class Event<T> {
    private T eventCode;

    /**
     * Constructor.
     *
     * @param eventCode The event code
     */
    public Event(final T eventCode) {
        this.eventCode = eventCode;
    }

    public T getEventCode() {
        return eventCode;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) { return true; }
        if (!(o instanceof Event)) { return false; }

        Event event = (Event) o;

        return eventCode.equals(event.eventCode);

    }

    @Override
    public int hashCode() {
        return eventCode.hashCode();
    }

    @Override
    public String toString() {
        return eventCode.toString();
    }
}
