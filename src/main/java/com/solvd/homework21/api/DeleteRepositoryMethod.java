package com.solvd.homework21.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class DeleteRepositoryMethod extends AbstractApiMethodV2 {

    public DeleteRepositoryMethod(String owner, String repo) {
        super("delete/request.json", null);
        replaceUrlPlaceholder("base_url",Configuration.getEnvArg("api_url"));
        replaceUrlPlaceholder("owner", owner);
        replaceUrlPlaceholder("repo", repo);
    }


}
