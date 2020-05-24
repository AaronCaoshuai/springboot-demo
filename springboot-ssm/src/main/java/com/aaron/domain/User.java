package com.aaron.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 
 * 
 * user
 * 
 **/
@Data
public class User implements Serializable {
    /**
     * id
     */
    private Integer id;

    /**
     * username
     */
    private String username;

    /**
     * birthday
     */
    private String birthday;

    /**
     * sex
     */
    private String sex;

    /**
     * address
     */
    private String address;

    private static final long serialVersionUID = 1L;
}