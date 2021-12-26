package com.solvd.homework21.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class PatchRepositoryMethod extends AbstractApiMethodV2 {

    public PatchRepositoryMethod(String owner, String repo) {
        super("patch/request.json", "patch/response.json");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        replaceUrlPlaceholder("owner", owner);
        replaceUrlPlaceholder("repo", repo);
    }

}
