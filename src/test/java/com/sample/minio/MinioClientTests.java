package com.sample.minio;

import io.minio.*;
import io.minio.messages.Item;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * MinioClientTests
 *
 * @author Aaric, created on 2022-08-18T16:50.
 * @version 0.2.0-SNAPSHOT
 */
@Slf4j
public class MinioClientTests {

    public static final String MINIO_ENDPOINT = "https://play.min.io";
    public static final String MINIO_ACCESS_KEY = "Q3AM3UQ867SPQQA43P2F";
    public static final String MINIO_SECRET_KEY = "zuf+tfteSlswRu7BJ86wekitnifILbZam1KYY3TG";
    public static final String MINIO_BUCKET = "yesoo-bucket";
    public static final String MINIO_TEST_FILENAME = "test.txt";

    public static MinioClient client;

    @BeforeAll
    public static void setUp() {
        client = MinioClient.builder()
                .endpoint(MINIO_ENDPOINT)
                .credentials(MINIO_ACCESS_KEY, MINIO_SECRET_KEY)
                .build();
    }

    @Disabled
    @Test
    public void testBucket() throws Exception {
        BucketExistsArgs args = BucketExistsArgs.builder().bucket(MINIO_BUCKET).build();
        /*if (!client.bucketExists(args)) {
            client.makeBucket(MakeBucketArgs.builder().bucket(MINIO_BUCKET).build());
        }*/
        Assertions.assertTrue(client.bucketExists(args));
    }

    @Disabled
    @Test
    public void testListObjects() throws Exception {
        ListObjectsArgs args = ListObjectsArgs.builder()
                .bucket(MINIO_BUCKET)
                .build();
        Iterable<Result<Item>> results = client.listObjects(args);
        Iterator<Result<Item>> itr = results.iterator();
        while (itr.hasNext()) {
            Result<Item> result = itr.next();
            log.info("testListObjects --> etag={}, objectName={}", result.get().etag(), result.get().objectName());
        }
    }

    @Disabled
    @Test
    public void testGetObject() throws Exception {
        GetObjectArgs args = GetObjectArgs.builder()
                .bucket(MINIO_BUCKET)
                .object(MINIO_TEST_FILENAME)
                .build();
        GetObjectResponse response = client.getObject(args);
        log.info("testGetObject --> bucket={}, objectName={}, region={}", response.bucket(), response.object(), response.region());
    }

    @Disabled
    @Test
    public void testDownloadObject() throws Exception {
        File downloadFile = new File(ClassLoader.getSystemResource("").getPath() + File.separator + MINIO_TEST_FILENAME);
        log.info("testDownloadObject --> downloadFile={}", downloadFile.getPath());
        DownloadObjectArgs args = DownloadObjectArgs.builder()
                .bucket(MINIO_BUCKET)
                .object(MINIO_TEST_FILENAME)
                .filename(downloadFile.getPath())
                .build();
        client.downloadObject(args);
    }

    @Disabled
    @Test
    public void testUploadObject() throws Exception {
        String testFilename = "banzhuan.jpg";
        File testFile = new File(ClassLoader.getSystemResource(testFilename).getPath());
        UploadObjectArgs args = UploadObjectArgs.builder()
                .bucket(MINIO_BUCKET)
                .object(testFilename)
                .filename(testFile.getPath())
                .build();
        client.uploadObject(args);
        log.info("testUploadObject -> testFile={}", testFile.getPath());
    }

    @Disabled
    @Test
    public void testUploadSnowballObjects() throws Exception {
        List<SnowballObject> objects = new ArrayList<>();
        byte[] bytes = "hello java".getBytes(StandardCharsets.UTF_8);
        objects.add(new SnowballObject("java.txt", new ByteArrayInputStream(bytes), bytes.length, null));
        bytes = "hello minio".getBytes(StandardCharsets.UTF_8);
        objects.add(new SnowballObject("minio.txt", new ByteArrayInputStream(bytes), bytes.length, null));
        UploadSnowballObjectsArgs args = UploadSnowballObjectsArgs.builder()
                .bucket(MINIO_BUCKET)
                .objects(objects)
                .build();
        client.uploadSnowballObjects(args);
    }

    @Disabled
    @Test
    public void testRemoveObject() throws Exception {
        RemoveObjectArgs args = RemoveObjectArgs.builder()
                .bucket(MINIO_BUCKET)
                .object("banzhuan.jpg")
                .build();
        client.removeObject(args);
    }
}
