/**
 * Copyright (c) 2021 Fundacion Jala.
 * <p>
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Gustavo Zacarias Huanca Alconz
 */

package salesforce.utilities;

public class ObjectInformation {
    private String token;
    private String id;
    private String nameOwner;
    private String typeUser;

    /**
     * Gets typeUser.
     *
     * @return a typeUser
     */
    public String getTypeUser() {
        return typeUser;
    }

    /**
     * Sets typeUser.
     *
     * @param typeUser of user
     */
    public void setTypeUser(final String typeUser) {
        this.typeUser = typeUser;
    }

    /**
     * Gets token.
     *
     * @return a token
     */
    public String getToken() {
        return token;
    }

    /**
     * Sets token.
     *
     * @param token of user
     */
    public void setToken(final String token) {
        this.token = token;
    }

    /**
     * Gets Id of feature or entity.
     *
     * @return a String with Id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets of Id of feature or entity.
     *
     * @param id of feature or entity.
     */
    public void setId(final String id) {
        this.id = id;
    }

    /**
     * Gets name Owner.
     *
     * @return a String with name Owner
     */
    public String getNameOwner() {
        return nameOwner;
    }

    /**
     * Sets of name Owner.
     *
     * @param nameOwner is name owner
     */
    public void setNameOwner(final String nameOwner) {
        this.nameOwner = nameOwner;
    }
}
