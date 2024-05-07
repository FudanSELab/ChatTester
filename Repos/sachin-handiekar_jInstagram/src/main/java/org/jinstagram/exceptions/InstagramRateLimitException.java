package org.jinstagram.exceptions;

import java.util.Map;

public class InstagramRateLimitException extends InstagramException {
	private static final long serialVersionUID = 1L;

	/**
	 * No-exception constructor. Used when there is no original exception
	 *
	 * @param message message explaining what went wrong
	 */
	public InstagramRateLimitException(String message) {
		super(message);
	}

	/**
	 * No-exception constructor with response headers. 
	 * Used when there is no original exception
	 * 
	 * @param message message explaining what went wrong
	 * @param responseHeaders the headers obtained from Instagram http response
	 */
	public InstagramRateLimitException(String message, Map<String, String> responseHeaders) {
		super(message, responseHeaders);
	}

    /**
     * No-exception constructor with response headers.
     * Used when there is no original exception
     *
     * @param message message explaining what went wrong
     * @param responseHeaders the headers obtained from Instagram http response
     */
    public InstagramRateLimitException(String exceptionType, String message, Map<String, String> responseHeaders) {
        super(exceptionType, message, responseHeaders);
    }

    /**
	 * Default constructor
	 *
	 * @param message message explaining what went wrong
	 * @param e original exception
	 */
	public InstagramRateLimitException(String message, Exception e) {
		super(message, e);
	}

	/**
	 * Constructor with response headers
	 * @param message message explaining what went wrong
	 * @param e original exception
	 * @param responseHeaders the headers obtained from Instagram http response
	 */
	public InstagramRateLimitException(String message, Exception e, Map<String, String> responseHeaders) {
		super(message, e, responseHeaders);
	}
}
