package com.orange.auth.domain.convert;

import com.orange.auth.domain.entity.AuthRoleBO;
import com.orange.auth.domain.entity.AuthUserBO;
import com.orange.auth.infra.basic.entity.AuthRole;
import com.orange.auth.infra.basic.entity.AuthUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 角色bo转换器
 * 
 */
@Mapper
public interface AuthRoleBOConverter {

    AuthRoleBOConverter INSTANCE = Mappers.getMapper(AuthRoleBOConverter.class);

    AuthRole convertBOToEntity(AuthRoleBO authRoleBO);

}
