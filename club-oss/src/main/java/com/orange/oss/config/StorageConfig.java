package com.orange.oss.config;


import com.orange.oss.adapter.StorageAdapter;
import com.orange.oss.adapter.MinioStorageAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RefreshScope
public class StorageConfig {

    @Value("${storage.service.type}")
    private String storageType;


    @Bean
    @RefreshScope
    public StorageAdapter storageService(){
        if("minio".equals(storageType)){
            return new MinioStorageAdapter();
        }else{
            throw new IllegalArgumentException("未找到对应的文件存储处理器");
        }
    }

}
