package com.orange.oss.adapter;

import com.orange.oss.entity.FileInfo;
import com.orange.oss.adapter.StorageAdapter;
import com.orange.oss.util.MinioUtil;
import lombok.SneakyThrows;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.List;

public class MinioStorageAdapter implements StorageAdapter {

    @Resource
    private MinioUtil minioUtil;

    @Override
    @SneakyThrows   //编译时自动抛出异常
    public void createBucket(String bucket) {
        minioUtil.createBucket(bucket);
    }

    @Override
    @SneakyThrows   //编译时自动抛出异常
    public void uploadFile(MultipartFile uploadFile, String bucket, String objectName) {
        minioUtil.createBucket(bucket);
        if(objectName!=null){
            minioUtil.uploadFile(uploadFile.getInputStream(),bucket,objectName+"/"+uploadFile.getName());
        }else{
            minioUtil.uploadFile(uploadFile.getInputStream(),bucket,uploadFile.getName());

        }
    }

    @Override
    @SneakyThrows   //编译时自动抛出异常
    public List<String> getAllBucket() {
        return minioUtil.getAllBucket();
    }

    @Override
    @SneakyThrows   //编译时自动抛出异常
    public List<FileInfo> getAllFile(String bucket) {
        return minioUtil.getAllFile(bucket);
    }

    @Override
    @SneakyThrows   //编译时自动抛出异常
    public InputStream downLoad(String bucket, String objectName) {
        return minioUtil.downLoad(bucket,objectName);
    }

    @Override
    @SneakyThrows   //编译时自动抛出异常
    public void deleteBucket(String bucket) {
        minioUtil.deleteBucket(bucket);
    }

    @Override
    @SneakyThrows   //编译时自动抛出异常
    public void deleteObject(String bucket, String objectName) {
        minioUtil.deleteObject(bucket,objectName);
    }
}
