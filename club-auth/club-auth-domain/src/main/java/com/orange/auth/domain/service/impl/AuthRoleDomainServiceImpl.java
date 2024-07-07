package com.orange.auth.domain.service.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import com.orange.auth.common.enums.AuthUserStatusEnum;
import com.orange.auth.common.enums.IsDeletedFlagEnum;
import com.orange.auth.domain.convert.AuthRoleBOConverter;
import com.orange.auth.domain.convert.AuthUserBOConverter;
import com.orange.auth.domain.entity.AuthRoleBO;
import com.orange.auth.domain.entity.AuthUserBO;
import com.orange.auth.domain.service.AuthRoleDomainService;
import com.orange.auth.domain.service.AuthUserDomainService;
import com.orange.auth.infra.basic.entity.AuthRole;
import com.orange.auth.infra.basic.entity.AuthUser;
import com.orange.auth.infra.basic.service.AuthRoleService;
import com.orange.auth.infra.basic.service.AuthUserService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class AuthRoleDomainServiceImpl implements AuthRoleDomainService {

    @Resource
    private AuthRoleService authRoleService;

    @Override
    public Boolean add(AuthRoleBO authRoleBO) {
        AuthRole authRole = AuthRoleBOConverter.INSTANCE.convertBOToEntity(authRoleBO);
        authRole.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        Integer count = authRoleService.insert(authRole);
        return count > 0;
    }

    @Override
    public Boolean update(AuthRoleBO authRoleBO) {
        AuthRole authRole = AuthRoleBOConverter.INSTANCE.convertBOToEntity(authRoleBO);
        Integer count = authRoleService.update(authRole);
        return count > 0;
    }

    @Override
    public Boolean delete(AuthRoleBO authRoleBO) {
        AuthRole authRole = new AuthRole();
        authRole.setId(authRoleBO.getId());
        authRole.setIsDeleted(IsDeletedFlagEnum.DELETED.getCode());
        Integer count = authRoleService.update(authRole);
        return count > 0;
    }

}
