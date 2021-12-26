package com.solvd.homework21;

import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.solvd.homework21.api.*;
import com.solvd.homework21.domain.RepositoryInfo;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GithubTest {

    @DataProvider(name = "repositoriesDataProvider")
    public Object[][] repositoryInfo() {
        RepositoryInfo repositoryInfo = new RepositoryInfo();
        repositoryInfo.setRepository("timetable");
        repositoryInfo.setCreatedAt("2021-12-06T07:00:11Z");
        repositoryInfo.setId(435392525L);
        repositoryInfo.setNodeId("R_kgDOGfOQDQ");
        repositoryInfo.setPushedAt("2021-12-19T15:10:27Z");
        repositoryInfo.setSize(301);
        repositoryInfo.setUpdatedAt("2021-12-19T15:06:55Z");

        RepositoryInfo repositoryInfo1 = new RepositoryInfo();
        repositoryInfo1.setRepository("army");
        repositoryInfo1.setCreatedAt("2021-11-19T18:13:03Z");
        repositoryInfo1.setId(429893511L);
        repositoryInfo1.setNodeId("R_kgDOGZ-nhw");
        repositoryInfo1.setPushedAt("2021-12-24T19:59:31Z");
        repositoryInfo1.setSize(187);
        repositoryInfo1.setUpdatedAt("2021-12-24T19:59:34Z");

        return new Object[][]{{repositoryInfo}, {repositoryInfo1}};
    }

    @Test(dataProvider = "repositoriesDataProvider")
    public void verifyRepositoryTest(RepositoryInfo repo) {
        GetRepositoryMethod getReposMethod = new GetRepositoryMethod(repo.getRepository());
        getReposMethod.addProperty("repisotory", repo.getRepository());
        getReposMethod.addProperty("created", repo.getCreatedAt());
        getReposMethod.addProperty("id", repo.getId());
        getReposMethod.addProperty("nodeId", repo.getNodeId());
        getReposMethod.addProperty("pushedAt", repo.getPushedAt());
        getReposMethod.addProperty("size", repo.getSize());
        getReposMethod.addProperty("updatedAt", repo.getUpdatedAt());
        getReposMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getReposMethod.callAPI();
        getReposMethod.validateResponse();
    }

    @Test
    public void verifyUserTest() {
        GetUserMethod getUserMethod = new GetUserMethod();
        getUserMethod.setHeaders(String.format("Authorization=%s","token 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"));
        getUserMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getUserMethod.callAPI();
        getUserMethod.validateResponse();
        getUserMethod.validateResponseAgainstSchema("get/user/response-schema.xsd");
    }

    @Test
    public void checkCreateRepositoryTest() {
        PostRepositoryMethod postRepositoryMethod = new PostRepositoryMethod();
        postRepositoryMethod.setHeaders(String.format("Authorization=%s","token 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"));
        postRepositoryMethod.addProperty("name", "POSTED_REPOSITORY");
        postRepositoryMethod.expectResponseStatus(HttpResponseStatusType.CREATED_201);
        postRepositoryMethod.callAPI();
        postRepositoryMethod.validateResponse();
    }

    @Test(dependsOnMethods = "checkCreateRepositoryTest")
    public void checkUpdateRepositoryTest() {
        PatchRepositoryMethod patchRepositoryMethod = new PatchRepositoryMethod("aaaPetrov", "POSTED_REPOSITORY");
        patchRepositoryMethod.setHeaders(String.format("Authorization=%s","token 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"));
        patchRepositoryMethod.addProperty("name", "POSTED_REPOSITORY");
        patchRepositoryMethod.addProperty("newName", "UPDATED_REPOSITORY");
        patchRepositoryMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        patchRepositoryMethod.callAPI();
        patchRepositoryMethod.validateResponse();
    }

    @Test(dependsOnMethods = "checkUpdateRepositoryTest")
    public void checkDeleteRepositoryTest() {
        DeleteRepositoryMethod deleteRepositoryMethod = new DeleteRepositoryMethod("aaaPetrov", "UPDATED_REPOSITORY");
        deleteRepositoryMethod.setHeaders(String.format("Authorization=%s","token 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"));
        deleteRepositoryMethod.addProperty("name", "UPDATED_REPOSITORY");
        deleteRepositoryMethod.expectResponseStatus(HttpResponseStatusType.NO_CONTENT_204);
        deleteRepositoryMethod.callAPI();
        Object response = deleteRepositoryMethod.getResponse();
        Assert.assertNull(response, "Response is not null.");
    }

}