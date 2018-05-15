/*
 *
 *   Copyright 2016 Walmart Technology
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */

package com.walmart.gatling.client;

import com.walmart.gatling.commons.HostUtils;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Created by walmart on 5/16/17.
 */
public class UploadUtils {

    public static String uploadFile(String server, String path, String authUserName,String authPassword) {
        CloseableHttpClient client = HttpClientBuilder.create()
                .build();

        HttpPost post = new HttpPost( server + "/uploadFile");
        File dataFeedFile = new File(path);
        String host = HostUtils.lookupHost();

        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        builder.addBinaryBody("file", dataFeedFile, ContentType.DEFAULT_BINARY, dataFeedFile.getName());
        builder.addTextBody("client", host, ContentType.DEFAULT_BINARY);

        if (authUserName != null && authPassword != null) {
            String basicAuth = new String(Base64.getEncoder().encodeToString(String.format("%s:%s", authUserName, authPassword).getBytes(StandardCharsets.UTF_8)));
            post.addHeader("Authorization", String.format("Basic %s", basicAuth));
        }

        HttpEntity entity = builder.build();
        post.setEntity(entity);
        try {
            HttpResponse response = client.execute(post);
            final int statusCode = response.getStatusLine().getStatusCode();
            return IOUtils.toString(response.getEntity().getContent());
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "";
    }
}
