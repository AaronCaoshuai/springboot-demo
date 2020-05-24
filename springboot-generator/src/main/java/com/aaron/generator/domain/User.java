package com.aaron.generator.domain;

import java.io.Serializable;
import lombok.Data;

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