package com.orange.auth.domain.convert;

import com.orange.auth.domain.entity.AuthPermissionBO;
import com.orange.auth.domain.entity.AuthRoleBO;
import com.orange.auth.infra.basic.entity.AuthPermission;
import com.orange.auth.infra.basic.entity.AuthRole;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 权限bo转换器
 * 
 */
@Mapper
public interface AuthPermissionBOConverter {

    AuthPermissionBOConverter INSTANCE = Mappers.getMapper(AuthPermissionBOConverter.class);

    AuthPermission convertBOToEntity(AuthPermissionBO authPermissionBO);

}
