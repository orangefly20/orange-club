package com.orange.auth.domain.service;

import com.orange.auth.domain.entity.AuthPermissionBO;
import com.orange.auth.domain.entity.AuthRolePermissionBO;

/**
 * 角色领域service
 * 
 */
public interface AuthRolePermissionDomainService {

    Boolean add(AuthRolePermissionBO authRolePermissionBO);

}
