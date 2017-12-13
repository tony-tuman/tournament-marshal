package tmarshal.model;

import tmarshal.server.exceptions.UnauthorizedAccessException;

;

public interface AuthorizedEntity {
    public void verifyAuthority(AccessTypes ...accessTypes) throws UnauthorizedAccessException;
}
