package org.nodcloud.commons.utilites;

import org.nodcloud.qing.sdk.core.Response;

public interface CloudAction<T> {

    public Response callCloud() throws Exception;

    public T handleResponse(Response response) throws Exception;

}
