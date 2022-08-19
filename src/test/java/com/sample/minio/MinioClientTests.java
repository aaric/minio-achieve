package com.sample.minio;

import io.minio.BucketExistsArgs;
import io.minio.MinioClient;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * MinioClientTests
 *
 * @author Aaric, created on 2022-08-18T16:50.
 * @version 0.1.0-SNAPSHOT
 */
@Slf4j
public class MinioClientTests {

    public static final String MINIO_ENDPOINT = "http://10.0.11.25:9000";
    public static final String MINIO_ACCESS_KEY = "newuser";
    public static final String MINIO_SECRET_KEY = "newuser123";
    public static final String MINIO_BUCKET = "newbucket";

    public static MinioClient client;

    @BeforeAll
    public static void setUp() {
        client = MinioClient.builder()
                .endpoint(MINIO_ENDPOINT)
                .credentials(MINIO_ACCESS_KEY, MINIO_SECRET_KEY)
                .build();
    }

    @Test
    public void testBucket() throws Exception {
        BucketExistsArgs args = BucketExistsArgs.builder().bucket(MINIO_BUCKET).build();
        /*if (!client.bucketExists(args)) {
            client.makeBucket(MakeBucketArgs.builder().bucket(MINIO_BUCKET).build());
        }*/
        Assertions.assertTrue(client.bucketExists(args));
    }
}
