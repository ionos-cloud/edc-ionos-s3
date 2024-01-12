/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.ionos.edc.provision.s3;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ionos.edc.provision.s3.bucket.IonosS3ProvisionedResource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;



class IonosProvisionedResourceTest {
    private IonosS3ProvisionedResource proviResource;

    @BeforeEach
    void setUp() {
        proviResource = IonosS3ProvisionedResource.Builder.newInstance().id("test").transferProcessId("111")
                .resourceDefinitionId("test-resource").resourceName("resource-name")
                .bucketName("bucket").build();

    }

    @Test
    void verifyDeserialization() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        StringWriter writer = new StringWriter();
        mapper.writeValue(writer, proviResource);

        IonosS3ProvisionedResource deserialized = mapper.readValue(writer.toString(), IonosS3ProvisionedResource.class);

        assertNotNull(deserialized);

        assertEquals("bucket", deserialized.getBucketName());
    }

}