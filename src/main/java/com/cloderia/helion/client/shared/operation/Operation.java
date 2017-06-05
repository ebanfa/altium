/**
 * 
 */

package com.cloderia.helion.client.shared.operation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;

import javax.inject.Qualifier;


/**
 * Qualifier for {@link FixDataOperation} to differentiate between creation, update, and deletion of {@link FixData
 * Contacts}.
 */
@Retention(RUNTIME)
@Qualifier
public @interface Operation {

  public static enum OperationType {
    CREATE, CREATE_FAILED, UPDATE, UPDATE_FAILED, DELETE, DELETE_FAILED, LOGIN_SUCCESSFUL, LOGIN_FAILED
  }

  OperationType value();

}
