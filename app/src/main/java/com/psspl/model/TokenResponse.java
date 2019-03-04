package com.psspl.model;

/**
 * Created by haresh
 * on 23-10-2018.
 */

public class TokenResponse {

    /**
     * access_token : ya29.Gls_BoL1R6lf0XhYcNyThaFbsRDRlvdmUgKUTF4z51ey4AcEdeWBt5GFv-u5tpLWxa79NeHx9nNO4MDGX0PHkOYSMR4qXGw-_uCz18dNspjCa1gCs7vaOcBRIjr1
     * expires_in : 3580
     * scope : https://www.googleapis.com/auth/userinfo.email https://www.googleapis.com/auth/plus.me https://www.googleapis.com/auth/userinfo.profile
     * token_type : Bearer
     * id_token : eyJhbGciOiJSUzI1NiIsImtpZCI6IjcyOGY0MDE2NjUyMDc5YjllZDk5ODYxYmIwOWJhZmM1YTQ1YmFhODYiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJodHRwczovL2FjY291bnRzLmdvb2dsZS5jb20iLCJhenAiOiIxMDQyNDg0ODcxNzMwLWFwY2UwaWVrZ2w5NGViY3AwbGVlNGwxb3J2Nm5kYnVqLmFwcHMuZ29vZ2xldXNlcmNvbnRlbnQuY29tIiwiYXVkIjoiMTA0MjQ4NDg3MTczMC1hcGNlMGlla2dsOTRlYmNwMGxlZTRsMW9ydjZuZGJ1ai5hcHBzLmdvb2dsZXVzZXJjb250ZW50LmNvbSIsInN1YiI6IjExMDY3ODEwOTA5MDcxOTY5ODE0NiIsImVtYWlsIjoicHNzcGxtb2JpbGV0ZWFtQGdtYWlsLmNvbSIsImVtYWlsX3ZlcmlmaWVkIjp0cnVlLCJhdF9oYXNoIjoiV2VRc21mOXEzcDNNa1M4dmJSNkF4USIsIm5hbWUiOiJQcmFrc2ggaW50b3RlY2giLCJwaWN0dXJlIjoiaHR0cHM6Ly9saDQuZ29vZ2xldXNlcmNvbnRlbnQuY29tLy1hc1lIY3NncjQ2RS9BQUFBQUFBQUFBSS9BQUFBQUFBQUFBQS9BQnRObGJBSnhSWl95YTFsV2I3c1lOenJlVWNGOXVwNkxBL3M5Ni1jL3Bob3RvLmpwZyIsImdpdmVuX25hbWUiOiJQcmFrc2giLCJmYW1pbHlfbmFtZSI6ImludG90ZWNoIiwibG9jYWxlIjoiZW4iLCJpYXQiOjE1NDAyOTkyMzMsImV4cCI6MTU0MDMwMjgzM30.ae8HtGoBPLv137pdwjc4-1LINmuWQfdfCCEZJhxVOT8mG9IJWTsSwOj2jFnjiGB__yzu2q48pSp-sVL13LW84_NmGed2-nb_qVfkwO5sGALrP3lOO8CwgSaA-hn3E3NYlXzycy06h7cuus6faRu9-dmYsMyIYCiVvudsaO_Zqzhbyp9qGyhxuU9kNx4PXwenPF9THfOzoqfZl3JzmhkrVQnUUK1P3vYgSTEwQo_3i9LU-ZKXc311-gmJRQ0XWk3yp7rhCv7Cpf_PGZO2ahIs11lPsvVkeD2eg-Iyu15IUvR_V2S-w4M1rNTb6zow4jlIJnkQjaXyuy2ZGrJmeNcXXA
     */

    private String access_token;
    private int expires_in;
    private String scope;
    private String token_type;
    private String id_token;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getId_token() {
        return id_token;
    }

    public void setId_token(String id_token) {
        this.id_token = id_token;
    }
}
